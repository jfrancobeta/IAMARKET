package com.jfranco.aimercado.mercadoai.controllers.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.jfranco.aimercado.mercadoai.dto.Payment.PaymentResponseDTO;
import com.jfranco.aimercado.mercadoai.model.Payment.StatusPayment;
import com.jfranco.aimercado.mercadoai.service.Payment.PaymentService;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @PostMapping("/pending")
    public ResponseEntity<PaymentResponseDTO> createPendingPayment(
            @RequestParam("objectId") Long objectId,
            @RequestParam("type") String type,
            Principal principal) {
        PaymentResponseDTO response = paymentService.createPendingPayment(objectId, type, principal.getName());
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/pending")
    public ResponseEntity<Page<PaymentResponseDTO>> getAllPendingPayments(
            Principal principal,
            Pageable pageable) {
        Page<PaymentResponseDTO> response = paymentService.getAllPendingPayments(principal.getName(), pageable);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @PostMapping("/init-point")
    public ResponseEntity<PaymentResponseDTO> generatePaymentInitPoint(
            @RequestParam("paymentId") Long paymentId,
            Principal principal) {
        PaymentResponseDTO response = paymentService.generatePaymentInitPoint(paymentId, principal.getName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/success")
    public ResponseEntity<?> successPayment(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String payerId) {
        paymentService.executePayment(paymentId, payerId);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Pago exitoso");
        response.put("paymentId", paymentId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancelPendingPayment(@PathVariable Long id, Principal principal) {
        paymentService.cancelPayment(id, principal.getName());
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Pago cancelado por el usuario");
        response.put("id", id);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/all")
    public ResponseEntity<Page<PaymentResponseDTO>> getAllPayments(
            Principal principal,
            @RequestParam(value = "status", required = false) StatusPayment status,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "type", required = false) String type,
            Pageable pageable) {
        Page<PaymentResponseDTO> response = paymentService.getAllPayments(
                principal.getName(), status, search, type, pageable);
        return ResponseEntity.ok(response);
    }
}