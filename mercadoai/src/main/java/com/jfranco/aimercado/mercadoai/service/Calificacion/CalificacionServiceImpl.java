package com.jfranco.aimercado.mercadoai.service.Calificacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Rating.CompleteRatingDTO;
import com.jfranco.aimercado.mercadoai.dto.Rating.PendingRatingDTO;
import com.jfranco.aimercado.mercadoai.dto.Rating.RatingDTO;
import com.jfranco.aimercado.mercadoai.mapper.Rating.RatingMapper;
import com.jfranco.aimercado.mercadoai.model.Rating.Calificacion;
import com.jfranco.aimercado.mercadoai.model.Rating.StatusRatingEnum;
import com.jfranco.aimercado.mercadoai.repository.Calificacion.CalificacionRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;

@Service
public class CalificacionServiceImpl implements ICalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RatingMapper ratingMapper;

    @Override
    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion findById(Long id) {
        return calificacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Calificacion> findAll() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion update(Long id, Calificacion calificacion) {
        if (calificacionRepository.existsById(id)) {
            calificacion.setId(id);
            return calificacionRepository.save(calificacion);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (calificacionRepository.existsById(id)) {
            calificacionRepository.deleteById(id);
        }
    }

    @Override
    public Double getPromedioCalificacionByUsuarioId(Long usuarioId) {
        Double promedio = calificacionRepository.findPromedioCalificacionByUsuarioId(usuarioId);
        return promedio != null ? promedio : 0.0;
    }

    @Override
    public RatingDTO completeRating(Long ratingId, CompleteRatingDTO ratingDTO) {
        Calificacion calificacion = calificacionRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Calificación pendiente no encontrada"));

        if (calificacion.getEstado() != StatusRatingEnum.PENDING) {
            throw new RuntimeException("La calificación ya fue completada");
        }

        calificacion.setCalificacion(ratingDTO.getCalificacion());
        calificacion.setComentario(ratingDTO.getComentario());
        calificacion.setEstado(StatusRatingEnum.COMPLETED);
        calificacion.setFechaCalificacion(java.time.LocalDate.now());

        calificacionRepository.save(calificacion);
        return ratingMapper.toDTO(calificacion);
    }

    @Override
    public List<PendingRatingDTO> getPendingRating(String username) {
        List<Calificacion> calificaciones = calificacionRepository
                .findByUsuario_UsernameAndEstado(username, StatusRatingEnum.PENDING);
        return calificaciones.stream().map(ratingMapper::toPendingDTO).collect(Collectors.toList());
    }

    @Override
    public List<RatingDTO> getRatingRecived(String username) {
        List<Calificacion> calificaciones = calificacionRepository.findByUsuarioCalificado_UsernameAndEstado(username,
                StatusRatingEnum.COMPLETED);
        return calificaciones.stream().map(ratingMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<RatingDTO> getRatingGiven(String username) {
        List<Calificacion> calificaciones = calificacionRepository.findByUsuario_UsernameAndEstado(username,
                StatusRatingEnum.COMPLETED);
        return calificaciones.stream().map(ratingMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<RatingDTO> getAllRatingsByProjectId(Long proyectoId) {
        List<Calificacion> calificaciones = calificacionRepository.findByProyecto_IdAndEstado(proyectoId,
                StatusRatingEnum.COMPLETED);
        return calificaciones.stream().map(ratingMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteRating(Long ratingId) {
        if (calificacionRepository.existsById(ratingId)) {
            calificacionRepository.deleteById(ratingId);
        }
    }

}
