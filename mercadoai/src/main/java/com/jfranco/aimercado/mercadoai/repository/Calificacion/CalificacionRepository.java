package com.jfranco.aimercado.mercadoai.repository.Calificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfranco.aimercado.mercadoai.model.Calificacion;


public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    
    @Query("SELECT AVG(c.calificacion) FROM Calificacion c WHERE c.usuarioCalificado.id = :usuarioId")
    Double findPromedioCalificacionByUsuarioId(@Param("usuarioId") Long usuarioId);
    
}
