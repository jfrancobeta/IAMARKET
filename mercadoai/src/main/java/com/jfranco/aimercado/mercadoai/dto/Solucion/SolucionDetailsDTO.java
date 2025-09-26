package com.jfranco.aimercado.mercadoai.dto.Solucion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Categoria.CategoriaDTO;
import com.jfranco.aimercado.mercadoai.dto.Estado.EstadoDTO;
import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.User.UsuarioDTO;
import com.jfranco.aimercado.mercadoai.model.UnidadEntrega;

public class SolucionDetailsDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private BigDecimal precio;
    private int vistas;
    private int pedidos;
    private CategoriaDTO categoria;
    private EstadoDTO estado;
    private List<HabilidadDTO> habilidades;
    private List<String> caracteristicas;
    private List<String> requisitos;
    private List<HitoDTO> hitos;
    private int tiempoEntrega;
    private UnidadEntrega unidadEntrega;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualizacion;
    private UsuarioDTO desarrollador;

    public SolucionDetailsDTO() {
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

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public List<HabilidadDTO> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<HabilidadDTO> habilidades) {
        this.habilidades = habilidades;
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

    public UsuarioDTO getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(UsuarioDTO desarrollador) {
        this.desarrollador = desarrollador;
    }

    public List<HitoDTO> getHitos() {
        return hitos;
    }

    public void setHitos(List<HitoDTO> hitos) {
        this.hitos = hitos;
    }

    
}
