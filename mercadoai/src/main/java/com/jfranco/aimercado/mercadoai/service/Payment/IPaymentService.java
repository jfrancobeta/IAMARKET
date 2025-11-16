package com.jfranco.aimercado.mercadoai.service.Payment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfranco.aimercado.mercadoai.dto.Payment.PaymentResponseDTO;
import com.jfranco.aimercado.mercadoai.model.Payment.StatusPayment;

public interface IPaymentService {
    public PaymentResponseDTO createPendingPayment(Long objectId, String type, String username);
    public Page<PaymentResponseDTO> getAllPendingPayments(String username, Pageable pageable);
    public Page<PaymentResponseDTO> getAllPayments(String username, StatusPayment status, String search, String type, Pageable pageable);
    public PaymentResponseDTO generatePaymentInitPoint(Long paymentId, String username);
    public void executePayment(String paymentId, String payerId);
    public void cancelPayment(Long id, String username);
}
