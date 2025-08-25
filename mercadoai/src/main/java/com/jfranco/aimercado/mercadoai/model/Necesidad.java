package com.jfranco.aimercado.mercadoai.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "necesidades")
public class Necesidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private BigDecimal presupuesto;
    @ManyToOne
    @JoinColumn(name = "compania_id")
    private Usuario compania;
    private LocalDate fechaLimite;
    @ManyToMany
    @JoinTable(
        name = "necesidad_habilidad",
        joinColumns = @JoinColumn(name = "necesidad_id"),
        inverseJoinColumns = @JoinColumn(name = "habilidad_id")
    )
    private List<Habilidad> skillsRequired;

    @ElementCollection
    private List<String> requirements;

    @ElementCollection
    private List<String> expectedDeliverables;
    
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;// Estado: 0 - Pendiente, 1 - En Proceso, 2 - Completada, 3 - Cancelada
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;


    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDate.now();
        this.fechaActualizacion = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaActualizacion = LocalDate.now();
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCompania() {
        return compania;
    }

    public void setCompania(Usuario compania) {
        this.compania = compania;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
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

    public List<Habilidad> getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(List<Habilidad> skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    
}
