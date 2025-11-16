import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../shared/layout/main-layout/main-layout.component';
import { PaymentService } from '../../../core/services/payment.service';
import { PaymentResponseDTO } from '../../../core/models/payment/PaymentResponseDTO';
import { CommonModule, DecimalPipe } from '@angular/common';

@Component({
  selector: 'app-payments',
  standalone: true,
  imports: [MainLayoutComponent, DecimalPipe, CommonModule],
  templateUrl: './payments.component.html',
})
export class PaymentsComponent implements OnInit {
  pendingPayments: PaymentResponseDTO[] = [];
  paymentHistory: PaymentResponseDTO[] = [];
  pendingTotal: number = 0;
  processedTotal: number = 0;
  commissionTotal: number = 0;
  constructor(private paymentService: PaymentService) {}

  ngOnInit(): void {
    this.loadPendingPayments();
    this.loadPaymentHistory();
  }

  loadPendingPayments(): void {
    this.paymentService.getAllPendingPayments().subscribe({
      next: (page) => {
        this.pendingPayments = page.content;
        this.pendingTotal = this.pendingPayments.reduce(
          (sum, p) => sum + (p.amount || 0),
          0
        );
      },
      error: (err) => {
        console.error('Error loading pending payments', err);
      },
    });
  }

  loadPaymentHistory(): void {
    this.paymentService.getAllPayments().subscribe({
      next: (page) => {
        this.paymentHistory = page.content;
        this.processedTotal = this.paymentHistory.reduce(
          (sum, p) => sum + (p.amount || 0),
          0
        );
        this.commissionTotal = this.paymentHistory.reduce(
          (sum, p) => sum + (p.amount || 0),
          0
        );
      },
      error: (err) => {
        console.error('Error loading payment history', err);
      },
    });
  }

  payNow(paymendId: number): void {
    this.paymentService.generatePaymentInitPoint(paymendId).subscribe({
      next: (response) => {
        console.log('Payment init point response:', response);
        if (response && response.initPoint) {
          console.log('Redirecting to payment init point:', response.initPoint);
          window.location.href = response.initPoint;
        } else {
          alert('No se pudo generar el enlace de pago.');
        }
      },
      error: (err) => {
        console.error('Error generating payment init point', err);
      },
    });
  }
  
  cancelPendingPayment(Id: number): void {
    if(confirm('¿Estás seguro de que deseas cancelar este pago pendiente?')) {
      this.paymentService.cancelPayment(Id).subscribe({
        next: () => {
          alert('Pago pendiente cancelado correctamente.');
          this.loadPendingPayments();
          this.loadPaymentHistory();
        },
        error: (err) => {
          console.error('Error cancelando el pago pendiente', err);
          alert('No se pudo cancelar el pago pendiente.');
        }
      });
    }
  }
}
