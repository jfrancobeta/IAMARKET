package com.jfranco.aimercado.mercadoai.dto.Habilidad;

public class HabilidadDTO {
    private Long id;
    private String nombre;
    private String descripcion;

    
    public HabilidadDTO() {
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

    
}
