package com.jfranco.aimercado.mercadoai.dto.Propuesta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoUpdateDTO;

public class PropuestaUpdateDTO {
     private BigDecimal precio;
    private LocalDate entrega;
    private String descripcion;
    private List<HitoUpdateDTO> hitos;
    public PropuestaUpdateDTO() {
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
    public List<HitoUpdateDTO> getHitos() {
        return hitos;
    }
    public void setHitos(List<HitoUpdateDTO> hitos) {
        this.hitos = hitos;
    }

    
}
