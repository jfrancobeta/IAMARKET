package com.jfranco.aimercado.mercadoai.repository.Calificacion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfranco.aimercado.mercadoai.model.Rating.Calificacion;
import com.jfranco.aimercado.mercadoai.model.Rating.StatusRatingEnum;


public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    
    @Query("SELECT AVG(c.calificacion) FROM Calificacion c WHERE c.usuarioCalificado.id = :usuarioId")
    Double findPromedioCalificacionByUsuarioId(@Param("usuarioId") Long usuarioId);

     // Buscar la primera calificación pendiente para un usuario
    Optional<Calificacion> findFirstByUsuario_UsernameAndEstado(String username, StatusRatingEnum estado);

    // Calificaciones recibidas por un usuario (completadas)
    List<Calificacion> findByUsuarioCalificado_UsernameAndEstado(String username, StatusRatingEnum estado);

    // Calificaciones dadas por un usuario (completadas)
    List<Calificacion> findByUsuario_UsernameAndEstado(String username, StatusRatingEnum estado);

    // Calificaciones de un proyecto (completadas)
    List<Calificacion> findByProyecto_IdAndEstado(Long proyectoId, StatusRatingEnum estado);
    
}
