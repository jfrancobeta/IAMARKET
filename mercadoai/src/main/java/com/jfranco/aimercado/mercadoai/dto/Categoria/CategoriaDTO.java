package com.jfranco.aimercado.mercadoai.dto.Categoria;

public class CategoriaDTO {
    private Long id;
    private String nombre;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id2, String nombre2) {
        this.id = id2;
        this.nombre = nombre2;
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
}
