package com.jfranco.aimercado.mercadoai.dto.Pais;

public class PaisDTO {
    private Long id;
    private String nombre;
    private String codigoIso;
    
    public PaisDTO() {
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
    public String getCodigoIso() {
        return codigoIso;
    }
    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }

    

}
