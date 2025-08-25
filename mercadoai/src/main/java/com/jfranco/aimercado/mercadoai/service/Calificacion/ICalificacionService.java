package com.jfranco.aimercado.mercadoai.service.Calificacion;

import com.jfranco.aimercado.mercadoai.model.Calificacion;
import java.util.List;

public interface ICalificacionService {
    
    Calificacion save(Calificacion calificacion);
    Calificacion findById(Long id);
    List<Calificacion> findAll();
    Calificacion update(Long id, Calificacion calificacion);
    void delete(Long id);
    Double getPromedioCalificacionByUsuarioId(Long usuarioId);
}   
