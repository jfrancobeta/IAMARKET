package com.jfranco.aimercado.mercadoai.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "perfil_desarrollador_habilidad",
        joinColumns = @JoinColumn(name = "perfil_desarrollador_id"),
        inverseJoinColumns = @JoinColumn(name = "habilidad_id")
    )
    private List<Habilidad> habilidades;

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
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<Habilidad> habilidades) {
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
