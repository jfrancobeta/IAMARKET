package com.jfranco.aimercado.mercadoai.model.CancelRequest;

import java.time.LocalDateTime;


import com.jfranco.aimercado.mercadoai.model.Proyecto;
import com.jfranco.aimercado.mercadoai.model.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cancel_requests")
public class CancelRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "requested_by_id")
    private Usuario requestedBy;

    @ManyToOne
    @JoinColumn(name = "requested_to_id")
    private Usuario requestedTo;

    private String reason;

    @Enumerated(EnumType.STRING)
    private CancelStatus status; // PENDING, ACCEPTED, REJECTED, ESCALATED

    private LocalDateTime requestedAt;
    private LocalDateTime respondedAt;
    private String responseReason;

    public CancelRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Usuario requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Usuario getRequestedTo() {
        return requestedTo;
    }

    public void setRequestedTo(Usuario requestedTo) {
        this.requestedTo = requestedTo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CancelStatus getStatus() {
        return status;
    }

    public void setStatus(CancelStatus status) {
        this.status = status;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public LocalDateTime getRespondedAt() {
        return respondedAt;
    }

    public void setRespondedAt(LocalDateTime respondedAt) {
        this.respondedAt = respondedAt;
    }

    public String getResponseReason() {
        return responseReason;
    }

    public void setResponseReason(String responseReason) {
        this.responseReason = responseReason;
    }

}
