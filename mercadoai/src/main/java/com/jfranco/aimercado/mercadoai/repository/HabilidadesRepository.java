package com.jfranco.aimercado.mercadoai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfranco.aimercado.mercadoai.model.Habilidad;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidad, Long> {


    
} 