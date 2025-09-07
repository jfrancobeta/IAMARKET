package com.jfranco.aimercado.mercadoai.dto.Perfil;

import com.jfranco.aimercado.mercadoai.model.PerfilCompania;

public class PerfilCompaniaDTO {
    
    private Long id;
    private String nombreCompania;
    private String industria;
    private String website;

    // Constructor vacío
    public PerfilCompaniaDTO() {}

    // Constructor completo
    public PerfilCompaniaDTO(Long id, String nombreCompania, String industria, String website, String ubicacion) {
        this.id = id;
        this.nombreCompania = nombreCompania;
        this.industria = industria;
        this.website = website;
    }

    // Constructor que recibe una entidad PerfilCompania
    public PerfilCompaniaDTO(PerfilCompania perfilCompania) {
        if (perfilCompania != null) {
            this.id = perfilCompania.getId();
            this.nombreCompania = perfilCompania.getNombreCompania();
            this.industria = perfilCompania.getIndustria().getNombre();
            this.website = perfilCompania.getWebsite();
        }
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getIndustria() {
        return industria;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
