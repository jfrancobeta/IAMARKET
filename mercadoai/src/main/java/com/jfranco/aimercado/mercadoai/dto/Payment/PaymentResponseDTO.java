package com.jfranco.aimercado.mercadoai.dto.Payment;

import java.math.BigDecimal;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDTO;

public class PaymentResponseDTO {
    private Long id;
    private String paymentId;
    private String preferenceId;
    private String initPoint;
    private String status;
    private BigDecimal amount;
    private SolucionDTO solucion;
    private PropuestaDTO propuesta;

    public PaymentResponseDTO() {
    }

    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    public String getInitPoint() {
        return initPoint;
    }

    public void setInitPoint(String initPoint) {
        this.initPoint = initPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getPaymentId() {
        return paymentId;
    }



    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public SolucionDTO getSolucion() {
        return solucion;
    }

    public void setSolucion(SolucionDTO solucion) {
        this.solucion = solucion;
    }

    public PropuestaDTO getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(PropuestaDTO propuesta) {
        this.propuesta = propuesta;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
