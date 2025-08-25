package com.jfranco.aimercado.mercadoai.service.Proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.repository.Proyecto.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Integer countProyectosByPropuestaId(Long propuestaId) {
        return proyectoRepository.countByPropuesta_Desarrollador_id(propuestaId);
    }
    
}