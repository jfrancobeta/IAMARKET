package com.jfranco.aimercado.mercadoai.dto.Need;

import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoUpdateDTO;

public class NecesidadUpdateDTO {
    
    private String titulo;
    private String descripcion;
    private Long categoria;
    
    @Positive(message = "El presupuesto debe ser positivo")
    private BigDecimal presupuesto;
    
    private LocalDate fechaLimite;
    private List<Long> skillsRequiredIds;
    private List<String> requirements;
    private List<HitoUpdateDTO> hitos;
    private Long estadoId;

    // Constructors
    public NecesidadUpdateDTO() {}

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public List<Long> getSkillsRequiredIds() {
        return skillsRequiredIds;
    }

    public void setSkillsRequiredIds(List<Long> skillsRequiredIds) {
        this.skillsRequiredIds = skillsRequiredIds;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public List<HitoUpdateDTO> getHitos() {
        return hitos;
    }

    public void setHitos(List<HitoUpdateDTO> hitos) {
        this.hitos = hitos;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
