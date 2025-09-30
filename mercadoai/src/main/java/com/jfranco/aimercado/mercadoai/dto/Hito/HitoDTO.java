package com.jfranco.aimercado.mercadoai.dto.Hito;

import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableDTO;

public class HitoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntrega;
    private List<EntregableDTO> entregables;

    public HitoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public List<EntregableDTO> getEntregables() {
        return entregables;
    }

    public void setEntregables(List<EntregableDTO> entregables) {
        this.entregables = entregables;
    }

}
