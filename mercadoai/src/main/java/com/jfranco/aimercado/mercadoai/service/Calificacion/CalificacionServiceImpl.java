package com.jfranco.aimercado.mercadoai.service.Calificacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.model.Calificacion;
import com.jfranco.aimercado.mercadoai.repository.CalificacionRepository;

@Service
public class CalificacionServiceImpl implements ICalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

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
    
    
}
