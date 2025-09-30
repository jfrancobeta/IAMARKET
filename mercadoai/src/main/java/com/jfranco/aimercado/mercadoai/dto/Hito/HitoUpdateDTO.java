package com.jfranco.aimercado.mercadoai.dto.Hito;

import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableUpdateDTO;


public class HitoUpdateDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntrega;
    private List<EntregableUpdateDTO> entregables;

    public HitoUpdateDTO() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EntregableUpdateDTO> getEntregables() {
        return entregables;
    }

    public void setEntregables(List<EntregableUpdateDTO> entregables) {
        this.entregables = entregables;
    }
    
}
