package com.jfranco.aimercado.mercadoai.dto.Propuesta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Estado.EstadoDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;

public class PropuestaDTO {
    private Long id;
    private NecesidadDTO necesidad;
    private UsuarioDTO desarrollador;
    private BigDecimal precio;
    private LocalDate entrega;
    private String descripcion;
    private EstadoDTO estado;
    private List<HitoDTO> hitos;
    private LocalDate fechaCreacion;

    public PropuestaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NecesidadDTO getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(NecesidadDTO necesidad) {
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

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public List<HitoDTO> getHitos() {
        return hitos;
    }

    public void setHitos(List<HitoDTO> hitos) {
        this.hitos = hitos;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



}
