package com.jfranco.aimercado.mercadoai.dto.User;

import java.time.LocalDateTime;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Perfil.PerfilCompaniaDTO;
import com.jfranco.aimercado.mercadoai.dto.Perfil.PerfilDesarrolladorDTO;

public class UsuarioCalificacionDTO {

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
    private PerfilCompaniaDTO perfilCompania;
    private PerfilDesarrolladorDTO perfilDesarrollador;
    private Double calificacionPromedio;
    private Integer cantidadCalificaciones;
    private Integer cantidadProyectos;

    public UsuarioCalificacionDTO() {
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

    public PerfilCompaniaDTO getPerfilCompania() {
        return perfilCompania;
    }

    public void setPerfilCompania(PerfilCompaniaDTO perfilCompania) {
        this.perfilCompania = perfilCompania;
    }

    public PerfilDesarrolladorDTO getPerfilDesarrollador() {
        return perfilDesarrollador;
    }

    public void setPerfilDesarrollador(PerfilDesarrolladorDTO perfilDesarrollador) {
        this.perfilDesarrollador = perfilDesarrollador;
    }

    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public Integer getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(Integer cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public Integer getCantidadProyectos() {
        return cantidadProyectos;
    }

    public void setCantidadProyectos(Integer cantidadProyectos) {
        this.cantidadProyectos = cantidadProyectos;
    } 
}