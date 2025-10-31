package com.jfranco.aimercado.mercadoai.dto.Rating;

import java.time.LocalDate;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;

public class RatingDTO {
    private Long id;
    private UsuarioDTO usuario;
    private UsuarioDTO usuarioCalificado;
    private ProyectoDTO proyecto;
    private int calificacion;
    private String comentario;
    private String estado;
    private LocalDate fechaCalificacion;

    public RatingDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO getUsuarioCalificado() {
        return usuarioCalificado;
    }

    public void setUsuarioCalificado(UsuarioDTO usuarioCalificado) {
        this.usuarioCalificado = usuarioCalificado;
    }

    public ProyectoDTO getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoDTO proyecto) {
        this.proyecto = proyecto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(LocalDate fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    

}
