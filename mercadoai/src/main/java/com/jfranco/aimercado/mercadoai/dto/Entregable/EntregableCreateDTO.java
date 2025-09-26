package com.jfranco.aimercado.mercadoai.dto.Entregable;

import java.time.LocalDate;

public class EntregableCreateDTO {
    private String nombreArchivo;
    private String url;
    private LocalDate fechaEntrega;
    private Long hitoId; 

    public EntregableCreateDTO() {
    }
    
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }


    public Long getHitoId() {
        return hitoId;
    }


    public void setHitoId(Long hitoId) {
        this.hitoId = hitoId;
    }

}
