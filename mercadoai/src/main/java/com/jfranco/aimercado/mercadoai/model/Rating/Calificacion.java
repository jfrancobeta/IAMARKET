package com.jfranco.aimercado.mercadoai.model.Rating;

import java.time.LocalDate;

import com.jfranco.aimercado.mercadoai.model.Proyecto;
import com.jfranco.aimercado.mercadoai.model.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Usuario usuarioCalificado;

    @ManyToOne
    private Proyecto proyecto;
    
    private Integer calificacion; 

    @Enumerated(EnumType.STRING)
    private StatusRatingEnum estado;
    
    private String comentario;

    private LocalDate fechaCalificacion;

    
    public Calificacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioCalificado() {
        return usuarioCalificado;
    }

    public void setUsuarioCalificado(Usuario usuarioCalificado) {
        this.usuarioCalificado = usuarioCalificado;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(LocalDate fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }


    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public StatusRatingEnum getEstado() {
        return estado;
    }

    public void setEstado(StatusRatingEnum estado) {
        this.estado = estado;
    }

    

}
