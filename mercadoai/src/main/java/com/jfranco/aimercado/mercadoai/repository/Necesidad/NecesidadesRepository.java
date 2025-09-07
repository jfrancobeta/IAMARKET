package com.jfranco.aimercado.mercadoai.repository.Necesidad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Necesidad;

public interface NecesidadesRepository extends JpaRepository<Necesidad,Long>{ 

    Page<Necesidad> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
    Page<Necesidad> findByCategoriaNombreIgnoreCase(String categoria, Pageable pageable);
    Page<Necesidad> findByEstadoNombreIgnoreCase(String estado, Pageable pageable);
}
