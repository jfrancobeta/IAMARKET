package com.jfranco.aimercado.mercadoai.dto.Rating;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;

public class PendingRatingDTO {
    private Long id;
    private ProyectoDTO proyecto;
    private UsuarioDTO usuarioCalificado;
    private String estado;

    public PendingRatingDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProyectoDTO getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoDTO proyecto) {
        this.proyecto = proyecto;
    }

    public UsuarioDTO getUsuarioCalificado() {
        return usuarioCalificado;
    }

    public void setUsuarioCalificado(UsuarioDTO usuarioCalificado) {
        this.usuarioCalificado = usuarioCalificado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
