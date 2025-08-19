package com.jfranco.aimercado.mercadoai.dto.Propuesta;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;
import com.jfranco.aimercado.mercadoai.model.Propuesta;

public class PropuestaDTO {
    private Long id;
    private Long necesidad; 
    private UsuarioDTO desarrollador;      
    private BigDecimal precio;
    private String entrega;
    private String descripcion;
    private String estado;            
    private LocalDate fechaCreacion;

    public PropuestaDTO(Long id, Long necesidad, UsuarioDTO desarrollador, BigDecimal precio,
            String entrega, String descripcion, String estado, LocalDate fechaCreacion) {
        this.id = id;
        this.necesidad = necesidad;
        this.desarrollador = desarrollador;
        this.precio = precio;
        this.entrega = entrega;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public PropuestaDTO(Propuesta p, Object object) {
        //TODO Auto-generated constructor stub
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
    public UsuarioDTO getDesarrollador() {
        return desarrollador;
    }
    public void setDesarrollador(UsuarioDTO desarrollador) {
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
