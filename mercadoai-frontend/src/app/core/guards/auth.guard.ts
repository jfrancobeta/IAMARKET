import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  const service = inject(AuthService);
  const router = inject(Router);

  if(inject(AuthService).isAuthenticated()){
    if(isTokenExpired()){
      service.logout();
      router.navigate(['/login']);
      return false;
    }
    if(!service.isAdmin()){
      router.navigate(['/']);
      return false;
    }

    return true;
  }
  router.navigate(['/auth']);
  return false;
};

const isTokenExpired = () => {
  const token = inject(AuthService).token
  const payload = inject(AuthService).getPayload(token)
  const exp = payload.exp
  const now = new Date().getTime()/1000
  if(now > exp){
    return true 
  }
  return false
};
