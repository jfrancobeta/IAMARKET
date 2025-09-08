import { Routes } from "@angular/router";
import { DetailsUserComponent } from "./pages/details-user/details-user.component";
import { ProfileComponent } from "./pages/profile.component";

export const perfilRoutes: Routes = [
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'details-user/:username',
        component: DetailsUserComponent
    }, 
]