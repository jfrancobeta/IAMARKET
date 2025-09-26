package com.jfranco.aimercado.mercadoai.dto.Proyecto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;

public class ProyectoDTO {
    private Long id;
    private Long solucionId;    
    private Long propuestaId;   
    private BigDecimal presupuesto;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private List<HitoDTO> hitos;
    public ProyectoDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSolucionId() {
        return solucionId;
    }
    public void setSolucionId(Long solucionId) {
        this.solucionId = solucionId;
    }
    public Long getPropuestaId() {
        return propuestaId;
    }
    public void setPropuestaId(Long propuestaId) {
        this.propuestaId = propuestaId;
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
    public List<HitoDTO> getHitos() {
        return hitos;
    }
    public void setHitos(List<HitoDTO> hitos) {
        this.hitos = hitos;
    }

}
