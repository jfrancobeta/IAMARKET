package com.jfranco.aimercado.mercadoai.dto.Proyecto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoCreateDTO;

public class ProyectoCreateDTO {
    private Long id;
    private Long solucion;
    private Long propuesta;
    private BigDecimal presupuesto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private List<HitoCreateDTO> hitos;

    public ProyectoCreateDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSolucion() {
        return solucion;
    }

    public void setSolucion(Long solucion) {
        this.solucion = solucion;
    }

    public Long getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Long propuesta) {
        this.propuesta = propuesta;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<HitoCreateDTO> getHitos() {
        return hitos;
    }

    public void setHitos(List<HitoCreateDTO> hitos) {
        this.hitos = hitos;
    }

}
