package com.jfranco.aimercado.mercadoai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfranco.aimercado.mercadoai.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
    
}
