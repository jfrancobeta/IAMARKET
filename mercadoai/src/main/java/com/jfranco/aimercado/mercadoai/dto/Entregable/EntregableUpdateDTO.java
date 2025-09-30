package com.jfranco.aimercado.mercadoai.dto.Entregable;

public class EntregableUpdateDTO {
    private Long id;
    private String nombreArchivo;

    public EntregableUpdateDTO() {
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
