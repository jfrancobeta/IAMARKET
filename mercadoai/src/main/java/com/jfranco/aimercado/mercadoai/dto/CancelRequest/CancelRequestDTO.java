package com.jfranco.aimercado.mercadoai.dto.CancelRequest;

import java.time.LocalDateTime;

public class CancelRequestDTO {
    private Long id;
    private Long proyectoId;
    private Long requestedById;
    private String requestedByUsername;
    private Long requestedToId;
    private String requestedToUsername;
    private String reason;
    private String status;
    private LocalDateTime requestedAt;
    private LocalDateTime respondedAt;
    private String responseReason;

    public CancelRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }

    public Long getRequestedById() {
        return requestedById;
    }

    public void setRequestedById(Long requestedById) {
        this.requestedById = requestedById;
    }

    public String getRequestedByUsername() {
        return requestedByUsername;
    }

    public void setRequestedByUsername(String requestedByUsername) {
        this.requestedByUsername = requestedByUsername;
    }

    public Long getRequestedToId() {
        return requestedToId;
    }

    public void setRequestedToId(Long requestedToId) {
        this.requestedToId = requestedToId;
    }

    public String getRequestedToUsername() {
        return requestedToUsername;
    }

    public void setRequestedToUsername(String requestedToUsername) {
        this.requestedToUsername = requestedToUsername;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
