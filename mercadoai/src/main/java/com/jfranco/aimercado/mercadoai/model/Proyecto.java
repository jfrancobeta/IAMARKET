package com.jfranco.aimercado.mercadoai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Necesidad necesidad;

    @OneToOne
    private Propuesta propuesta;

    public Proyecto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Necesidad getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(Necesidad necesidad) {
        this.necesidad = necesidad;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    

   

    
}
