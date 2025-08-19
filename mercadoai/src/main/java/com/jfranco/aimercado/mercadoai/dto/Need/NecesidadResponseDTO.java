package com.jfranco.aimercado.mercadoai.dto.Need;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;

/**
 * DTO para respuestas de necesidades
 * Incluye información completa para mostrar al cliente
 */
public class NecesidadResponseDTO {
    
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private BigDecimal presupuesto;
    private UsuarioDTO compania;
    private LocalDate fechaLimite;
    private List<String> skillsRequired; 
    private String requirements;
    private List<String> expectedDeliverables;
    private String estadoNombre;
    private List<PropuestaDTO> propuestas;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;


    // Constructors
    public NecesidadResponseDTO() {}

    public NecesidadResponseDTO(Long id, String titulo, String descripcion, String categoria, 
                               BigDecimal presupuesto, UsuarioDTO compania, LocalDate fechaLimite,
                               List<String> skillsRequired, String requirements, 
                               List<String> expectedDeliverables, String estadoNombre,
                               List<PropuestaDTO> propuestas,
                               LocalDate fechaCreacion, LocalDate fechaActualizacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.presupuesto = presupuesto;
        this.compania = compania;
        this.fechaLimite = fechaLimite;
        this.skillsRequired = skillsRequired;
        this.requirements = requirements;
        this.expectedDeliverables = expectedDeliverables;
        this.estadoNombre = estadoNombre;
        this.propuestas = propuestas;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public UsuarioDTO getCompania() {
        return compania;
    }

    public void setCompania(UsuarioDTO compania) {
        this.compania = compania;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public List<String> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<String> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<String> getExpectedDeliverables() {
        return expectedDeliverables;
    }

    public void setExpectedDeliverables(List<String> expectedDeliverables) {
        this.expectedDeliverables = expectedDeliverables;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public List<PropuestaDTO> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(List<PropuestaDTO> propuestas) {
        this.propuestas = propuestas;
    }
}
