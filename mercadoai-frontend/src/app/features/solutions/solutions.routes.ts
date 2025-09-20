import { Routes } from "@angular/router";
import { DetailsSolutionsComponent } from "./pages/details-solutions/details-solutions.component";
import { SolutionsComponent } from "./pages/solutions.component";
import { CreateComponent } from "./pages/create/create.component";

export const solutionsRoutes: Routes = [
    {
        path: 'solutions',
        component: SolutionsComponent
    },
    {
        path: 'solutions/create',
        component: CreateComponent
    },
    {
        path: 'solutions/edit/:id',
        component: CreateComponent
    },
    {
        path: 'solutions/:id',
        component: DetailsSolutionsComponent
    },
]