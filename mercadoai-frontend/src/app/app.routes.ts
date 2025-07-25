import { Routes } from '@angular/router';
import { AuthComponent } from './components/autenticacion/auth/auth.component';
import { RegistroLoginComponent } from './components/autenticacion/registro-login/registro-login.component';
import { ForgotPasswordComponent } from './components/autenticacion/forgot-password/forgot-password.component';

export const routes: Routes = [
    {
        path: '',
        pathMatch: 'full',
        redirectTo: '/auth'
    },
    {
        path: 'auth',
        component: AuthComponent,

    },
    {
        path: 'registro-login',
        component: RegistroLoginComponent
    },
    {
        path: 'forgot-password',
        component: ForgotPasswordComponent
    }
];
