package com.jfranco.aimercado.mercadoai.repository.Proyecto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfranco.aimercado.mercadoai.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    Integer countByPropuesta_Desarrollador_id(Long propuestaId);

    Page<Proyecto> findBySolucionIsNotNull(Pageable pageable);

    Page<Proyecto> findByPropuestaIsNotEmpty(Pageable pageable);

    @Query("""
            SELECT p
            FROM Proyecto p
            WHERE
                (p.propuesta IS NOT NULL AND LOWER(p.propuesta.necesidad.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')))
             OR (p.solucion IS NOT NULL AND LOWER(p.solucion.titulo) LIKE LOWER(CONCAT('%', :titulo, '%')))
            """)
    Page<Proyecto> searchByTitulo(@Param("titulo") String titulo, Pageable pageable);

    Page<Proyecto> findByEstadoNombreIgnoreCase(String estado, Pageable pageable);

}
