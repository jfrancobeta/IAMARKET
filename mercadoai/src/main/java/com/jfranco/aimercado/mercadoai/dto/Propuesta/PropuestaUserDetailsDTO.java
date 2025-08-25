package com.jfranco.aimercado.mercadoai.dto.Propuesta;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.jfranco.aimercado.mercadoai.dto.User.UsuarioCalificacionDTO;

public class PropuestaUserDetailsDTO {
    private Long id;
    private Long necesidad; 
    private UsuarioCalificacionDTO desarrollador;      
    private BigDecimal precio;
    private String entrega;
    private String descripcion;
    private String estado;            
    private LocalDate fechaCreacion;

    public PropuestaUserDetailsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(Long necesidad) {
        this.necesidad = necesidad;
    }

    public UsuarioCalificacionDTO getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(UsuarioCalificacionDTO desarrollador) {
        this.desarrollador = desarrollador;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    

    

}
