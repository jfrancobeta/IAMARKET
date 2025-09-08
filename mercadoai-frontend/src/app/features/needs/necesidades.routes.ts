import { Routes } from '@angular/router';
import { NeedsComponent } from './pages/needs.component';
import { CreateComponent } from './pages/create/create.component';
import { DetailsComponent } from './pages/details/details.component';

export const necesidadesroutes: Routes = [
  {
    path: 'needs',
    component: NeedsComponent,
  },
  {
    path: 'needs/create',
    component: CreateComponent,
  },
  {
    path: 'needs/:id/edit',
    component: CreateComponent,
  },
  {
    path: 'needs/:id',
    component: DetailsComponent,
  },
];
