package com.jfranco.aimercado.mercadoai.dto.Propuesta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PropuestaSummaryDTO {
    private Long id;
    private Long necesidadId;
    private Long desarrolladorId;
    private BigDecimal precio;
    private LocalDate entrega;
    private String descripcion;
    private String estadoNombre;
    private LocalDate fechaCreacion;
    public PropuestaSummaryDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getNecesidadId() {
        return necesidadId;
    }
    public void setNecesidadId(Long necesidadId) {
        this.necesidadId = necesidadId;
    }
    public Long getDesarrolladorId() {
        return desarrolladorId;
    }
    public void setDesarrolladorId(Long desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public LocalDate getEntrega() {
        return entrega;
    }
    public void setEntrega(LocalDate entrega) {
        this.entrega = entrega;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstadoNombre() {
        return estadoNombre;
    }
    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}