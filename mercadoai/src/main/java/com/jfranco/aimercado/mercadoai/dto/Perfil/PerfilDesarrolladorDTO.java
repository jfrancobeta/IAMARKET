package com.jfranco.aimercado.mercadoai.dto.Perfil;

import java.util.ArrayList;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadDTO;
import com.jfranco.aimercado.mercadoai.model.PerfilDesarrollador;

public class PerfilDesarrolladorDTO {
    
    private Long id;
    private List<HabilidadDTO> habilidades;
    private Integer experiencia;
    private String portafolioURL;

    // Constructor vacío
    public PerfilDesarrolladorDTO() {}

    // Constructor completo
    public PerfilDesarrolladorDTO(Long id, List<HabilidadDTO> habilidades, Integer experiencia, String portafolioURL) {
        this.id = id;
        this.habilidades = habilidades;
        this.experiencia = experiencia;
        this.portafolioURL = portafolioURL;
    }

    // Constructor que recibe una entidad PerfilDesarrollador
    public PerfilDesarrolladorDTO(PerfilDesarrollador perfilDesarrollador) {
        if (perfilDesarrollador != null) {
            this.id = perfilDesarrollador.getId();
            List<HabilidadDTO> habilidadesDTO = new ArrayList<>();
            if (perfilDesarrollador.getHabilidades() != null) {
                for (var habilidad : perfilDesarrollador.getHabilidades()) {
                    HabilidadDTO habilidadDTO = new HabilidadDTO();
                    habilidadDTO.setId(habilidad.getId());
                    habilidadDTO.setNombre(habilidad.getNombre());
                    habilidadDTO.setDescripcion(habilidad.getDescripcion());
                    habilidadesDTO.add(habilidadDTO);
                }
            }
            this.habilidades = habilidadesDTO;
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

    public List<HabilidadDTO> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<HabilidadDTO> habilidades) {
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
