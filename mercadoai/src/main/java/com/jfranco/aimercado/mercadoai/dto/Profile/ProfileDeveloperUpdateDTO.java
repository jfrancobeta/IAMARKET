package com.jfranco.aimercado.mercadoai.dto.Profile;

import java.util.List;

public class ProfileDeveloperUpdateDTO {
    private String portafolioURL;
    private String githubURL;
    private String linkedinURL;
    private List<Long> habilidades;
    private Integer experiencia;

    public ProfileDeveloperUpdateDTO() {
    }

    public String getPortafolioURL() {
        return portafolioURL;
    }

    public void setPortafolioURL(String portafolioURL) {
        this.portafolioURL = portafolioURL;
    }

    public String getGithubURL() {
        return githubURL;
    }

    public void setGithubURL(String githubURL) {
        this.githubURL = githubURL;
    }

    public String getLinkedinURL() {
        return linkedinURL;
    }

    public void setLinkedinURL(String linkedinURL) {
        this.linkedinURL = linkedinURL;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public List<Long> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Long> habilidades) {
        this.habilidades = habilidades;
    }

}
