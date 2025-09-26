package com.jfranco.aimercado.mercadoai.dto.Solucion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.model.UnidadEntrega;

public class SolucionDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    private int vistas;
    private int pedidos;
    private Long categoriaId;
    private Long estadoId;
    private List<Long> habilidadesIds;
    private List<String> caracteristicas;
    private List<String> requisitos;
    private List<HitoDTO> hitos;
    private int tiempoEntrega;
    private UnidadEntrega unidadEntrega;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;
    private Long desarrolladorId;

    public SolucionDTO() {
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public int getPedidos() {
        return pedidos;
    }

    public void setPedidos(int pedidos) {
        this.pedidos = pedidos;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public List<Long> getHabilidadesIds() {
        return habilidadesIds;
    }

    public void setHabilidadesIds(List<Long> habilidadesIds) {
        this.habilidadesIds = habilidadesIds;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<String> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<String> requisitos) {
        this.requisitos = requisitos;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public UnidadEntrega getUnidadEntrega() {
        return unidadEntrega;
    }

    public void setUnidadEntrega(UnidadEntrega unidadEntrega) {
        this.unidadEntrega = unidadEntrega;
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

    public Long getDesarrolladorId() {
        return desarrolladorId;
    }

    public void setDesarrolladorId(Long desarrolladorId) {
        this.desarrolladorId = desarrolladorId;
    }

    public List<HitoDTO> getHitos() {
        return hitos;
    }

    public void setHitos(List<HitoDTO> hitos) {
        this.hitos = hitos;
    }

}
