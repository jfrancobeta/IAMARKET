import { Routes } from "@angular/router";
import { ForgotPasswordComponent } from "./pages/forgot-password/forgot-password.component";
import { RegistroLoginComponent } from "./pages/registro-login/registro-login.component";
import { ResetPasswordComponent } from "./pages/reset-password/reset-password.component";
import { VerifyCodeComponent } from "./pages/verify-code/verify-code.component";
import { AuthComponent } from "./pages/auth/auth.component";

export const autenticacionRoutes: Routes = [
  {
    path: 'reset-password',
    component: ResetPasswordComponent,
  },
  {
    path: 'verify-code',
    component: VerifyCodeComponent,
  },
  {
    path: 'registro-login',
    component: RegistroLoginComponent,
  },
  {
    path: 'forgot-password',
    component: ForgotPasswordComponent,
  },
  {
        path: 'auth',
        component: AuthComponent,

  },
];
