package com.jfranco.aimercado.mercadoai.dto.Proyecto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoUpdateDTO;

public class ProyectoUpdateDTO {
    private BigDecimal presupuesto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<HitoUpdateDTO> hitos;

    public ProyectoUpdateDTO() {
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

    public List<HitoUpdateDTO> getHitos() {
        return hitos;
    }

    public void setHitos(List<HitoUpdateDTO> hitos) {
        this.hitos = hitos;
    }

}
