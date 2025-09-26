package com.jfranco.aimercado.mercadoai.dto.Hito;

import java.time.LocalDate;

public class HitoCreateDTO {
    private String nombre;
    private String descripcion;
    private LocalDate fechaEntrega;

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
}
