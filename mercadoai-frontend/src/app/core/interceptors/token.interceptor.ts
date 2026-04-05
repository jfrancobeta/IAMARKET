import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { PUBLIC_ROUTES } from '../../public-routes';
import { AuthService } from '../services/auth.service';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  const isPublic = PUBLIC_ROUTES.some((route) => req.url.includes(route));
  if (isPublic) {
    return next(req);
  }

  const authService = inject(AuthService);
  const router = inject(Router);
  const token = authService.token;

  if (token != undefined) {
    const authRequest = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' + token),
    });
    return next(authRequest).pipe(
      catchError((error) => {
        // Si el token es inválido (401) o no autorizado (403)
        if (error.status === 401 || error.status === 403) {
          // Limpiar datos de sesión
          sessionStorage.removeItem('login');
          sessionStorage.removeItem('token');

          // Redirigir a login
          router.navigate(['/auth']);

          console.error('Token inválido o expirado. Redirigiendo a login.');
        }
        return throwError(() => error);
      })
    );
  }
  return next(req);
};
