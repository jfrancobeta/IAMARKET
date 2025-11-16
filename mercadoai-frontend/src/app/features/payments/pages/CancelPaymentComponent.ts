import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { PaymentService } from '../../../core/services/payment.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cancel-payment',
  standalone: true,
  imports: [CommonModule, RouterModule],
  template: `
    <div class="container py-5 text-center">
      <i class="bi bi-x-circle text-danger fs-1 mb-3"></i>
      <h2>Pago cancelado</h2>
      <p class="text-muted">El pago no se ha procesado.</p>
      <a routerLink="/payments" class="btn btn-outline-secondary mt-3">Volver a pagos</a>
    </div>
  `,
})
export class CancelPaymentComponent {

}
