import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { PUBLIC_ROUTES } from '../../public-routes';
import { AuthService } from '../services/auth.service';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  const isPublic = PUBLIC_ROUTES.some((route) => req.url.includes(route));
  if (isPublic) {
    return next(req);
  }

  const token = inject(AuthService).token;
  if (token != undefined) {
    const authRequest = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' + token),
    });
    return next(authRequest);
  }
  return next(req);
};
