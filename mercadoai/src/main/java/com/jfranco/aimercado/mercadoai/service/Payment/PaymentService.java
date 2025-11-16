package com.jfranco.aimercado.mercadoai.service.Payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Payment.PaymentResponseDTO;
import com.jfranco.aimercado.mercadoai.exception.ResourceNotFoundException;
import com.jfranco.aimercado.mercadoai.mapper.Payment.PaymentMapper;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.model.Payment.Payment;
import com.jfranco.aimercado.mercadoai.model.Payment.StatusPayment;
import com.jfranco.aimercado.mercadoai.repository.Payment.PaymentRepository;
import com.jfranco.aimercado.mercadoai.repository.Propuesta.PropuestaRepository;
import com.jfranco.aimercado.mercadoai.repository.Solucion.SolucionesRespository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.service.Proyecto.ProyectoService;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SolucionesRespository solucionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PropuestaRepository propuestaRepository;

    @Autowired
    private APIContext apiContext;

    @Value("${paypal.success.url}")
    private String successUrl;

    @Value("${paypal.cancel.url}")
    private String cancelUrl;

    @Override
    public PaymentResponseDTO createPendingPayment(Long objectId, String type, String username) {
        Usuario buyer = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", username));

        Payment pago = new Payment();
        pago.setBuyer(buyer);
        pago.setStatus(StatusPayment.PENDING);
        pago.setCreationDate(LocalDateTime.now());

        if ("solucion".equals(type)) {
            Solucion solucion = solucionRepository.findById(objectId)
                    .orElseThrow(() -> new ResourceNotFoundException("Solucion", "id", objectId));
            pago.setSolucion(solucion);
            pago.setReceiver(solucion.getDesarrollador());
            pago.setAmount(solucion.getPrecio());
        }else if("propuesta".equals(type)) {
            Propuesta propuesta = propuestaRepository.findById(objectId)
                    .orElseThrow(() -> new ResourceNotFoundException("Propuesta", "id", objectId));
            pago.setPropuesta(propuesta);
            pago.setReceiver(propuesta.getDesarrollador());
            pago.setAmount(propuesta.getPrecio());
        } else {
            throw new RuntimeException("Tipo de objeto no soportado para el pago pendiente");
        }

        paymentRepository.save(pago);

        return paymentMapper.toDTO(pago);
    }

    @Override
    public Page<PaymentResponseDTO> getAllPendingPayments(String username, Pageable pageable) {
        Usuario user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", username));

        Page<Payment> paymentsPage = paymentRepository.findByBuyerAndStatus(user, StatusPayment.PENDING, pageable);

        return paymentMapper.toDTO(paymentsPage);
    }

    @Override
    public PaymentResponseDTO generatePaymentInitPoint(Long paymentId, String username) {
        Payment pago = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "id", paymentId));

        if (!pago.getBuyer().getUsername().equals(username)) {
            throw new RuntimeException("No autorizado");
        }

        // Crear el pago en PayPal
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(pago.getAmount().setScale(2, java.math.RoundingMode.HALF_UP).toPlainString());

        Transaction transaction = new Transaction();
        transaction.setDescription(
                pago.getSolucion() != null ? pago.getSolucion().getDescripcion()
                        : pago.getPropuesta() != null ? pago.getPropuesta().getDescripcion() : "Pago");
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        com.paypal.api.payments.Payment payment = new com.paypal.api.payments.Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);

        try {
            com.paypal.api.payments.Payment createdPayment = payment.create(apiContext);

            pago.setPaymentId(createdPayment.getId());
            paymentRepository.save(pago);

            String approvalUrl = createdPayment.getLinks().stream()
                    .filter(link -> link.getRel().equals("approval_url"))
                    .findFirst()
                    .map(Links::getHref)
                    .orElse(null);

            PaymentResponseDTO response = paymentMapper.toDTO(pago);
            response.setInitPoint(approvalUrl);
            response.setPreferenceId(createdPayment.getId());
            response.setStatus("PENDING");
            return response;
        } catch (PayPalRESTException e) {
            throw new RuntimeException("Error al crear el pago: " + e.getMessage());
        }
    }

    @Override
    public void executePayment(String paymentId, String payerId) {
        try {
            com.paypal.api.payments.Payment payment = new com.paypal.api.payments.Payment();
            payment.setId(paymentId);

            PaymentExecution paymentExecution = new PaymentExecution();
            paymentExecution.setPayerId(payerId);

            com.paypal.api.payments.Payment executedPayment = payment.execute(apiContext, paymentExecution);

            Payment pagoDb = paymentRepository.findByPaymentId(paymentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Pago", "paymentId", paymentId));

            if (executedPayment.getState().equals("approved")) {
                pagoDb.setStatus(StatusPayment.APPROVED);
                pagoDb.setApprovalDate(LocalDateTime.now());

                if(pagoDb.getSolucion() != null) {
                    proyectoService.createFromSolucion(pagoDb.getSolucion(), pagoDb.getBuyer());
                } else if (pagoDb.getPropuesta() != null) {
                    proyectoService.createFromPropuesta(pagoDb.getPropuesta());
                }
            } else {
                pagoDb.setStatus(StatusPayment.REJECTED);
            }

            paymentRepository.save(pagoDb);

        } catch (PayPalRESTException e) {
            throw new RuntimeException("Error al ejecutar el pago: " + e.getMessage());
        }
    }

    @Override
    public void cancelPayment(Long id, String username) {
        Payment pagoDb = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "id", id));

        // Solo el comprador puede cancelar su propio pago pendiente
        if (!pagoDb.getBuyer().getUsername().equals(username)) {
            throw new RuntimeException("No autorizado para cancelar este pago");
        }

        // Solo cancela si está pendiente
        if (pagoDb.getStatus() == StatusPayment.PENDING) {
            pagoDb.setStatus(StatusPayment.CANCELLED);
            paymentRepository.save(pagoDb);
        }
    }

    @Override
    public Page<PaymentResponseDTO> getAllPayments(String username, StatusPayment status, String search, String type,
            Pageable pageable) {
        Usuario user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", username));

        Page<Payment> pagos;

        if (search != null && !search.isEmpty()) {
            pagos = paymentRepository.findByUserParticipationAndSearch(user, search, pageable);
        } else if (type != null && !type.isEmpty()) {
            pagos = paymentRepository.findByUserParticipationAndType(user, type, pageable);
        } else if (status != null) {
            pagos = paymentRepository.findByUserParticipationAndStatus(user, status, pageable);
        } else {
            pagos = paymentRepository.findByUserParticipation(user, pageable);
        }

        return paymentMapper.toDTO(pagos);
    }

}
