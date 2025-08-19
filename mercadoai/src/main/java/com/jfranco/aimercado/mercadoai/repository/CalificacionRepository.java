package com.jfranco.aimercado.mercadoai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Calificacion;


public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    
}
