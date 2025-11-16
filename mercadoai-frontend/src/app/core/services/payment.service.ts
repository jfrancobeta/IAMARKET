import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { PaymentResponseDTO } from '../models/payment/PaymentResponseDTO';
import { Page } from '../models/shared/page';

@Injectable({
  providedIn: 'root',
})
export class PaymentService {
  private BASE_URL = `${environment.apiUrl}payment`;

  constructor(private http: HttpClient) {}

  // Crear pago pendiente
  createPendingPayment(
    objectId: number,
    type: string
  ): Observable<PaymentResponseDTO> {
    const params = new HttpParams()
      .set('objectId', objectId.toString())
      .set('type', type);
    return this.http.post<PaymentResponseDTO>(
      `${this.BASE_URL}/pending`,
      null,
      { params }
    );
  }

  // Obtener pagos pendientes (paginados)
  getAllPendingPayments(
    page: number = 0,
    size: number = 10
  ): Observable<Page<PaymentResponseDTO>> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());
    return this.http.get<Page<PaymentResponseDTO>>(`${this.BASE_URL}/pending`, {
      params,
    });
  }

  // Generar init point de pago
  generatePaymentInitPoint(paymentId: number): Observable<PaymentResponseDTO> {
    const params = new HttpParams().set('paymentId', paymentId.toString());
    return this.http.post<PaymentResponseDTO>(
      `${this.BASE_URL}/init-point`,
      null,
      { params }
    );
  }

  // Éxito de pago
  successPayment(paymentId: string, payerId: string): Observable<string> {
    const params = new HttpParams()
      .set('paymentId', paymentId)
      .set('PayerID', payerId);
    return this.http.get<string>(`${this.BASE_URL}/success`, { params });
  }

  // Cancelar pago
  cancelPayment(paymentId: number): Observable<any> {
    return this.http.post<any>(`${this.BASE_URL}/cancel/${paymentId}`, null);
  }

  // Obtener todos los pagos (historial, paginados y filtrados)
  getAllPayments(
    page: number = 0,
    size: number = 10,
    status?: string,
    search?: string,
    type?: string
  ): Observable<Page<PaymentResponseDTO>> {
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());
    if (status) params = params.set('status', status);
    if (search) params = params.set('search', search);
    if (type) params = params.set('type', type);
    return this.http.get<Page<PaymentResponseDTO>>(`${this.BASE_URL}/all`, {
      params,
    });
  }
}
