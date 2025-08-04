import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from '../services/auth.service';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  const token = inject(AuthService).token;
  console.log("TokenInterceptor", token);
  if(token != undefined){
    const authRequest = req.clone({
      headers: req.headers.set("Authorization", 'Bearer ' + token)
    })
    return next(authRequest)
  }
  return next(req);
};
