package com.jfranco.aimercado.mercadoai.service.Calificacion;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Rating.CompleteRatingDTO;
import com.jfranco.aimercado.mercadoai.dto.Rating.PendingRatingDTO;
import com.jfranco.aimercado.mercadoai.dto.Rating.RatingDTO;
import com.jfranco.aimercado.mercadoai.model.Rating.Calificacion;

public interface ICalificacionService {
    
    Calificacion save(Calificacion calificacion);
    Calificacion findById(Long id);
    List<Calificacion> findAll();
    Calificacion update(Long id, Calificacion calificacion);
    void delete(Long id);
    Double getPromedioCalificacionByUsuarioId(Long usuarioId);

    RatingDTO completeRating(Long ratingId, CompleteRatingDTO ratingDTO);

    List<PendingRatingDTO> getPendingRating(String username);

    List<RatingDTO> getRatingRecived(String username);

    List<RatingDTO> getRatingGiven(String username);

    List<RatingDTO> getAllRatingsByProjectId(Long proyectoId);

    void deleteRating(Long ratingId);


}   
