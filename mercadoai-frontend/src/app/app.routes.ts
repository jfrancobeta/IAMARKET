import { Routes } from '@angular/router';

import { adminRoutes } from './features/admin/admin.routes';
import { autenticacionRoutes } from './features/autenticacion/autenticacion.routes';
import { dashboardRoutes } from './features/dashboard/dashboard.routes';
import { mensajesRoutes } from './features/messages/mensajes.routes';
import { necesidadesroutes } from './features/needs/necesidades.routes';
import { notificacionesRoutes } from './features/notifications/notificaciones.routes';
import { pagosRoutes } from './features/payments/pagos.routes';
import { perfilRoutes } from './features/profile/perfil.routes';
import { poryectosRoutes } from './features/projects/proyectos.routes';
import { proposalsRoutes } from './features/proposals/proposals.routes';
import { ratingRoutes } from './features/rating/rating.routes';
import { solutionsRoutes } from './features/solutions/solutions.routes';

export const routes: Routes = [
    ...adminRoutes,
    ...autenticacionRoutes,
    ...dashboardRoutes,
    ...mensajesRoutes,
    ...necesidadesroutes,
    ...notificacionesRoutes,
    ...pagosRoutes,
    ...perfilRoutes,
    ...poryectosRoutes,
    ...proposalsRoutes,
    ...ratingRoutes,
    ...solutionsRoutes,
    {
        path: '',
        pathMatch: 'full',
        redirectTo: '/auth'
    },
];
