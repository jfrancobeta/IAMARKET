import { Routes } from "@angular/router";
import { DetailsSolutionsComponent } from "./pages/details-solutions/details-solutions.component";
import { SolutionsComponent } from "./pages/solutions.component";

export const solutionsRoutes: Routes = [
    {
        path: 'solutions',
        component: SolutionsComponent
    },
    {
        path: 'solutions/create',
        component: SolutionsComponent
    },
    {
        path: 'solutions/:id',
        component: DetailsSolutionsComponent
    },
]