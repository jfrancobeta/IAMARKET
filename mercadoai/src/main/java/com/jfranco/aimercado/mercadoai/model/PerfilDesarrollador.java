package com.jfranco.aimercado.mercadoai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil_desarrollador")
public class PerfilDesarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario usuario;
    private String habilidades;
    private Integer experiencia;
    private String portafolioURL;
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
