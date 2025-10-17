package com.jfranco.aimercado.mercadoai.dto.User;

public class UserPersonalUpdateDTO {

    private String nombre;
    private String email;
    private String descripcion;
    private Long paisId;

    public UserPersonalUpdateDTO() {
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

}
