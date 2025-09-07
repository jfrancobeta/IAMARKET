package com.jfranco.aimercado.mercadoai.repository.Industria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfranco.aimercado.mercadoai.model.Industria;

@Repository
public interface IndustriaRepository extends JpaRepository<Industria, Long> {
    
}
