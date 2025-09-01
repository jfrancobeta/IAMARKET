package com.jfranco.aimercado.mercadoai.dto.Need;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Future;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO para crear una nueva necesidad
 * Contiene solo los campos necesarios para la creación
 */
public class NecesidadCreateDTO {
    
    @NotBlank(message = "El título es obligatorio")
    private String titulo;
    
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    @NotBlank(message = "La categoría es obligatoria")
    private long categoria;
    
    @NotNull(message = "El presupuesto es obligatorio")
    @Positive(message = "El presupuesto debe ser positivo")
    private BigDecimal presupuesto;
    
    @Future(message = "La fecha límite debe ser futura")
    private LocalDate fechaLimite;
    
    private List<Long> skillsRequiredIds;
    
    private List<String> requirements;

    private List<String> expectedDeliverables;
    
    @NotNull(message = "El estado es obligatorio")
    private Long estadoId;

    // Constructors
    public NecesidadCreateDTO() {}

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

    public long getCategoria() {
        return categoria;
    }

    public void setCategoria(long categoria) {
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

    public List<String> getExpectedDeliverables() {
        return expectedDeliverables;
    }

    public void setExpectedDeliverables(List<String> expectedDeliverables) {
        this.expectedDeliverables = expectedDeliverables;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
