import { Routes } from "@angular/router";
import { PaymentsComponent } from "./pages/payments.component";
import { CancelPaymentComponent } from "./pages/CancelPaymentComponent";
import { SuccessPaymentComponent } from "./pages/SuccessPaymentComponent";

export const pagosRoutes: Routes = [ 
    {
        path: 'payments',
        component: PaymentsComponent
    },
    {
        path: 'payments/success',
        component: SuccessPaymentComponent
    },
    {
        path: 'payments/cancel',
        component: CancelPaymentComponent
    }
]