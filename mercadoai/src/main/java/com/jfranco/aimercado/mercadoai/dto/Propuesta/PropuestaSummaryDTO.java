package com.jfranco.aimercado.mercadoai.dto.Propuesta;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;

public class PropuestaSummaryDTO {
    private Long id;
    private NecesidadSummaryDTO necesidad;
    private UsuarioDTO desarrollador;
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
    public NecesidadSummaryDTO getNecesidad() {
        return necesidad;
    }
    public void setNecesidad(NecesidadSummaryDTO necesidad) {
        this.necesidad = necesidad;
    }
    public UsuarioDTO getDesarrollador() {
        return desarrollador;
    }
    public void setDesarrollador(UsuarioDTO desarrollador) {
        this.desarrollador = desarrollador;
    }
}