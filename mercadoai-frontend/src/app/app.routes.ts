import { Routes } from '@angular/router';
import { AuthComponent } from './components/autenticacion/auth/auth.component';
import { RegistroLoginComponent } from './components/autenticacion/registro-login/registro-login.component';
import { ForgotPasswordComponent } from './components/autenticacion/forgot-password/forgot-password.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ProfileComponent } from './components/profile/profile.component';
import { NeedsComponent } from './components/needs/needs.component';
import { DetailsComponent } from './components/needs/details/details.component';
import { CreateComponent } from './components/needs/create/create.component';

import { MessagesComponent } from './components/messages/messages.component';
import { PaymentsComponent } from './components/payments/payments.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { DetailsComponent as ProjectDetailsComponent } from './components/projects/details/details.component';
import { ProposalsComponent } from './components/proposals/proposals.component';
import { SendProposalComponent } from './components/needs/send-proposal/send-proposal.component';
import { DetailsProposalComponent } from './components/proposals/details-proposal/details-proposal.component';
import { RatingComponent } from './components/rating/rating.component';
import { SolutionsComponent } from './components/solutions/solutions.component';
import { DetailsSolutionsComponent } from './components/solutions/details-solutions/details-solutions.component';
import { CreateComponent as SolutionCreateComponent } from './components/solutions/create/create.component';
import { NotificationsComponent } from './components/notifications/notifications.component';
import { DetailsUserComponent } from './components/profile/details-user/details-user.component';
import { PostsComponent } from './components/admin/posts/posts.component';
import { StatsComponent } from './components/admin/stats/stats.component';
import { UsersComponent } from './components/admin/users/users.component';
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
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'needs',
        component: NeedsComponent
    },
    {
        path: 'needs/create',
        component: CreateComponent
    },
    {
        path: 'needs/:id',
        component: DetailsComponent
    },
    {
        path: 'messages',
        component: MessagesComponent
    },
    {
        path: 'payments',
        component: PaymentsComponent
    },
    {
        path: 'projects',
        component: ProjectsComponent
    },
    {
        path: 'projects/:id',
        component: ProjectDetailsComponent
    },
    {
        path: 'proposals',
        component: ProposalsComponent
    },
    {
        path: 'needs/:id/send-proposal',
        component: SendProposalComponent
    },
    {
        path: 'proposals/:id',
        component: DetailsProposalComponent
    },
    {
        path: 'ratings',
        component: RatingComponent
    },
    {
        path: 'solutions',
        component: SolutionsComponent
    },
    {
        path: 'solutions/create',
        component: SolutionCreateComponent
    },
    {
        path: 'solutions/:id',
        component: DetailsSolutionsComponent
    },
    {
        path: 'notifications',
        component: NotificationsComponent
    },
    {
        path: 'details-user/:username',
        component: DetailsUserComponent
    },
    {
        path: 'admin/posts',
        component: PostsComponent
    },
    {
        path: 'admin/stats',
        component: StatsComponent
    },
    {
        path: 'admin/users',
        component: UsersComponent
    }
];
