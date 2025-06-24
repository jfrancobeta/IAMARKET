package com.jfranco.aimercado.mercadoai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.repository.NecesidadesRepository;

@Service
public class NecesidadServiceImpl implements INecesidadesService {

    @Autowired
    private NecesidadesRepository necesidadesRepostitory;
    
    @Override
    public List<Necesidad> getAllNecesidades() {
        return necesidadesRepostitory.findAll();
    }

    @Override
    public Necesidad getNecesidadById(Long id) {
        return necesidadesRepostitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada con id: " + id));
    }

    @Override
    public Necesidad saveNecesidad(Necesidad necesidad) {
        return necesidadesRepostitory.save(necesidad);
    }

    @Override
    public void deleteNecesidad(Long id) {
        Necesidad necesidad = getNecesidadById(id);
        necesidadesRepostitory.delete(necesidad);
    }
    
}
