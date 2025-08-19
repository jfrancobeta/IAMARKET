package com.jfranco.aimercado.mercadoai.dto.User;

import java.time.LocalDateTime;
import java.util.List;
import com.jfranco.aimercado.mercadoai.model.Usuario;

public class UsuarioDTO {

    private Long id;
    private String username;
    private String email;
    private String nombre;
    private String descripcion;
    private String foto;
    private Integer userType;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private List<String> roles; 
    private Double calificacionPromedio;

    public UsuarioDTO(Long id, String username, String email, String nombre, String descripcion, String foto,
            Integer userType, Boolean estado, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion,
            List<String> roles, Double calificacionPromedio) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.userType = userType;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
        this.roles = roles;
        this.calificacionPromedio = calificacionPromedio;
    }

    // Constructor que recibe un Usuario y la calificación promedio
    public UsuarioDTO(Usuario usuario, Double calificacionPromedio) {
        this.id = usuario.getId();
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.nombre = usuario.getNombre();
        this.descripcion = usuario.getDescripcion();
        this.foto = usuario.getFoto();
        this.userType = usuario.getUserType();
        this.estado = usuario.getEstado();
        this.fechaCreacion = usuario.getFechaCreacion();
        this.fechaActualizacion = usuario.getFechaActualizacion();
        // Mapear los nombres de los roles
        this.roles = usuario.getRoles() != null ? usuario.getRoles().stream().map(r -> r.getNombre()).toList() : null;
        this.calificacionPromedio = calificacionPromedio;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public Integer getUserType() {
        return userType;
    }
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }
    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }


    
}
