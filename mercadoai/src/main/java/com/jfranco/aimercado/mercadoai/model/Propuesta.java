package com.jfranco.aimercado.mercadoai.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "propuestas")
public class Propuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Necesidad necesidad;
    @ManyToOne
    private Usuario desarrollador;
    private BigDecimal precio;
    private String entrega;
    private String descripcion;
    private String estado; // "pendiente", "aceptada", "rechazada"
    private LocalDate fechaCreacion;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Necesidad getNecesidad() {
        return necesidad;
    }
    public void setNecesidad(Necesidad necesidad) {
        this.necesidad = necesidad;
    }
    public Usuario getDesarrollador() {
        return desarrollador;
    }
    public void setDesarrollador(Usuario desarrollador) {
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
