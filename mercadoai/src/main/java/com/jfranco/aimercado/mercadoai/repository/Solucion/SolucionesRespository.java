package com.jfranco.aimercado.mercadoai.repository.Solucion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Solucion;

public interface SolucionesRespository extends JpaRepository<Solucion, Long> {
    
    Page<Solucion> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
    Page<Solucion> findByCategoriaNombreIgnoreCase(String categoria, Pageable pageable);
    Page<Solucion> findByEstadoNombreIgnoreCase(String estado, Pageable pageable);
}
