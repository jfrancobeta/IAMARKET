import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { PaymentService } from '../../../core/services/payment.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-success-payment',
  standalone: true,
  imports: [CommonModule, RouterModule],
  template: `
    <div class="container py-5 text-center">
      <ng-container *ngIf="loading">
        <i class="bi bi-hourglass-split text-primary fs-1 mb-3"></i>
        <h2>Procesando pago...</h2>
        <p class="text-muted">Por favor espera unos segundos.</p>
      </ng-container>
      <ng-container *ngIf="!loading">
        <ng-container *ngIf="success; else errorTpl">
          <i class="bi bi-check-circle text-success fs-1 mb-3"></i>
          <h2>¡Pago realizado con éxito!</h2>
          <p class="text-muted">Gracias por tu compra.</p>
          <a routerLink="/payments" class="btn btn-primary mt-3">Volver a pagos</a>
        </ng-container>
        <ng-template #errorTpl>
          <i class="bi bi-x-circle text-danger fs-1 mb-3"></i>
          <h2>Error al procesar el pago</h2>
          <p class="text-muted">No se pudo validar el pago.</p>
          <a routerLink="/payments" class="btn btn-primary mt-3">Volver a pagos</a>
        </ng-template>
      </ng-container>
    </div>
  `
})
export class SuccessPaymentComponent implements OnInit {
  success = false;
 loading = true;
  constructor(
    private route: ActivatedRoute,
    private paymentService: PaymentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const paymentId = this.route.snapshot.queryParamMap.get('paymentId');
    const payerId = this.route.snapshot.queryParamMap.get('PayerID');
    if (paymentId && payerId) {
      this.paymentService.successPayment(paymentId, payerId).subscribe({
        next: () => {
            this.success = true;
            this.loading = false;
        },
        error: () => {
            this.success = false;
            this.loading = false;
        }
      });
    } else {
      this.success = false;
      this.loading = false;
    }
  }
}