package com.jfranco.aimercado.mercadoai.service;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.model.Necesidad;

public interface INecesidadesService {

    List<Necesidad> getAllNecesidades();

    Necesidad getNecesidadById(Long id);

    Necesidad saveNecesidad(NecesidadDTO necesidad);

    Necesidad updateNecesidad(Long id, NecesidadDTO necesidadDTO);
    
    void deleteNecesidad(Long id);
    
}
