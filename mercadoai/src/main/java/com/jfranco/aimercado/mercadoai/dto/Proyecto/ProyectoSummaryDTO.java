package com.jfranco.aimercado.mercadoai.dto.Proyecto;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Solucion.SolucionDTO;

public class ProyectoSummaryDTO {
    private Long id;
    private SolucionDTO solucion;
    private PropuestaDTO propuesta;

    public ProyectoSummaryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropuestaDTO getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(PropuestaDTO propuesta) {
        this.propuesta = propuesta;
    }

    public SolucionDTO getSolucion() {
        return solucion;
    }

    public void setSolucion(SolucionDTO solucion) {
        this.solucion = solucion;
    }

}
