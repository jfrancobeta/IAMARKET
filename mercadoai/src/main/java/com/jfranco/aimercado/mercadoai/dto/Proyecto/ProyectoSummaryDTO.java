package com.jfranco.aimercado.mercadoai.dto.Proyecto;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionSummaryDTO;

public class ProyectoSummaryDTO {
    private Long id;
    private SolucionSummaryDTO solucion;
    private PropuestaSummaryDTO propuesta;

    public ProyectoSummaryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SolucionSummaryDTO getSolucion() {
        return solucion;
    }

    public void setSolucion(SolucionSummaryDTO solucion) {
        this.solucion = solucion;
    }

    public PropuestaSummaryDTO getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(PropuestaSummaryDTO propuesta) {
        this.propuesta = propuesta;
    }

    

}
