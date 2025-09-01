package com.jfranco.aimercado.mercadoai.dto.Need;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaDTO;
import com.jfranco.aimercado.mercadoai.dto.Estado.EstadoDTO;
import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;

public class NecesidadDTO {
    
    private Long id;
    private String titulo;
    private String descripcion;
    private CategoriaDTO categoria;
    private BigDecimal presupuesto;
    private UsuarioDTO compania;
    private LocalDate fechaLimite;
    private List<HabilidadDTO> skillsRequired;
    private List<String> requirements;
    private List<String> expectedDeliverables;
    private EstadoDTO estado;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;

    // Constructors
    public NecesidadDTO() {}

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

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
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

    public List<HabilidadDTO> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<HabilidadDTO> skillsRequired) {
        this.skillsRequired = skillsRequired;
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

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
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
}
