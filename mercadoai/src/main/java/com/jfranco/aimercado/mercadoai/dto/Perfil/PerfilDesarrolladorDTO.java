package com.jfranco.aimercado.mercadoai.dto.Perfil;

import com.jfranco.aimercado.mercadoai.model.PerfilDesarrollador;

public class PerfilDesarrolladorDTO {
    
    private Long id;
    private String habilidades;
    private Integer experiencia;
    private String portafolioURL;

    // Constructor vacío
    public PerfilDesarrolladorDTO() {}

    // Constructor completo
    public PerfilDesarrolladorDTO(Long id, String habilidades, Integer experiencia, String portafolioURL) {
        this.id = id;
        this.habilidades = habilidades;
        this.experiencia = experiencia;
        this.portafolioURL = portafolioURL;
    }

    // Constructor que recibe una entidad PerfilDesarrollador
    public PerfilDesarrolladorDTO(PerfilDesarrollador perfilDesarrollador) {
        if (perfilDesarrollador != null) {
            this.id = perfilDesarrollador.getId();
            this.habilidades = perfilDesarrollador.getHabilidades();
            this.experiencia = perfilDesarrollador.getExperiencia();
            this.portafolioURL = perfilDesarrollador.getPortafolioURL();
        }
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public String getPortafolioURL() {
        return portafolioURL;
    }

    public void setPortafolioURL(String portafolioURL) {
        this.portafolioURL = portafolioURL;
    }
}
