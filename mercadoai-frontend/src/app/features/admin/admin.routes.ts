import { Routes } from '@angular/router';
import { PostsComponent } from './pages/posts/posts.component';
import { StatsComponent } from './pages/stats/stats.component';
import { UsersComponent } from './pages/users/users.component';

export const adminRoutes: Routes = [
  {
    path: 'admin/posts',
    component: PostsComponent,
  },
  {
    path: 'admin/stats',
    component: StatsComponent,
  },
  {
    path: 'admin/users',
    component: UsersComponent,
  },
];
