package com.jfranco.aimercado.mercadoai.dto.Proyecto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;

public class ProyectoDTO {
    private Long id;
    private SolucionDTO solucion;    
    private PropuestaDTO propuesta;  
    private UsuarioDTO empresa;
    private UsuarioDTO desarrollador; 
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

    public SolucionDTO getSolucion() {
        return solucion;
    }

    public void setSolucion(SolucionDTO solucion) {
        this.solucion = solucion;
    }

    public PropuestaDTO getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(PropuestaDTO propuesta) {
        this.propuesta = propuesta;
    }
    public UsuarioDTO getEmpresa() {
        return empresa;
    }
    public void setEmpresa(UsuarioDTO empresa) {
        this.empresa = empresa;
    }
    public UsuarioDTO getDesarrollador() {
        return desarrollador;
    }
    public void setDesarrollador(UsuarioDTO desarrollador) {
        this.desarrollador = desarrollador;
    }

}
