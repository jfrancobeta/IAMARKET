package com.jfranco.aimercado.mercadoai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Usuario;

import java.util.List;


public interface PropuestaRepository extends JpaRepository<Propuesta, Long> {
    
    List<Propuesta> findByNecesidad(Necesidad necesidad);

    List<Propuesta> findByDesarrollador(Usuario desarrollador);

    Integer countByNecesidadId(Long necesidadId);
}
