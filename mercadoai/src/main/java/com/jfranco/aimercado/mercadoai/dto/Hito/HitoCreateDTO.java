package com.jfranco.aimercado.mercadoai.dto.Hito;

import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Entregable.EntregableCreateDTO;


public class HitoCreateDTO {
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntrega;
    private List<EntregableCreateDTO> entregables;

    public HitoCreateDTO() {
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

    public List<EntregableCreateDTO> getEntregables() {
        return entregables;
    }

    public void setEntregables(List<EntregableCreateDTO> entregables) {
        this.entregables = entregables;
    }
}
