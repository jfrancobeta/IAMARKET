package com.jfranco.aimercado.mercadoai.repository.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfranco.aimercado.mercadoai.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
    
}
