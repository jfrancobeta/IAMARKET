import { Routes } from "@angular/router";
import { ProjectsComponent } from "./pages/projects.component";
import { DetailsComponent } from "./pages/details/details.component";

export const poryectosRoutes: Routes = [
  {
    path: 'projects',
    component: ProjectsComponent,
  },
  {
    path: 'projects/:id',
    component: DetailsComponent,
  },
];
