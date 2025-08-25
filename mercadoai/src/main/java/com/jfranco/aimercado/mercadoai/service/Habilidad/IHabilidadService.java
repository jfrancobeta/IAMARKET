package com.jfranco.aimercado.mercadoai.service.Habilidad;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadDTO;

public interface IHabilidadService {
    
    List<HabilidadDTO> getAllHabilidades();

    HabilidadDTO getHabilidadById(Long id);

    HabilidadDTO saveHabilidad(HabilidadCreateDTO habilidadDTO);

    //HabilidadDTO updateHabilidad(Long id, HabilidadUpdateDTO habilidadDTO);

    void deleteHabilidad(Long id);
}
