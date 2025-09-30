package com.jfranco.aimercado.mercadoai.dto.Propuesta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PropuestaCreateDTO {
    private Long necesidadId;
    private BigDecimal precio;
    private LocalDate entrega;
    private String descripcion;
    private List<PropuestaCreateDTO> hitos;
    public PropuestaCreateDTO() {
    }
    public Long getNecesidadId() {
        return necesidadId;
    }
    public void setNecesidadId(Long necesidadId) {
        this.necesidadId = necesidadId;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public LocalDate getEntrega() {
        return entrega;
    }
    public void setEntrega(LocalDate entrega) {
        this.entrega = entrega;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<PropuestaCreateDTO> getHitos() {
        return hitos;
    }
    public void setHitos(List<PropuestaCreateDTO> hitos) {
        this.hitos = hitos;
    }

    

}
