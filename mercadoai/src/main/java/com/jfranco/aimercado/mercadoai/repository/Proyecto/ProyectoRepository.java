package com.jfranco.aimercado.mercadoai.repository.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    Integer countByPropuesta_Desarrollador_id(Long propuestaId);

}
