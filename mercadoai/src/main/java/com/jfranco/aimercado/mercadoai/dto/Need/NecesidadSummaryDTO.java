package com.jfranco.aimercado.mercadoai.dto.Need;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO simplificado para listados de necesidades
 * Contiene solo información esencial para optimizar transferencia de datos
 */
public class NecesidadSummaryDTO {
    
    private Long id;
    private String titulo;
    private String categoria;
    private String descripcion;
    private BigDecimal presupuesto;
    private String compañiaNombre;
    private LocalDate fechaLimite;
    private String estadoNombre;
    private Integer propuestas;
    private LocalDate fechaCreacion;

    // Constructors
    public NecesidadSummaryDTO() {}

    public NecesidadSummaryDTO(Long id, String titulo, String categoria, BigDecimal presupuesto,
                              String compañiaNombre, LocalDate fechaLimite, String estadoNombre,
                              LocalDate fechaCreacion, Integer propuestas, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.presupuesto = presupuesto;
        this.compañiaNombre = compañiaNombre;
        this.fechaLimite = fechaLimite;
        this.estadoNombre = estadoNombre;
        this.fechaCreacion = fechaCreacion;
        this.propuestas = propuestas;
        this.descripcion = descripcion;
    }

    

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getCompañiaNombre() {
        return compañiaNombre;
    }

    public void setCompañiaNombre(String compañiaNombre) {
        this.compañiaNombre = compañiaNombre;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
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

    public Integer getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(Integer propuestas) {
        this.propuestas = propuestas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
