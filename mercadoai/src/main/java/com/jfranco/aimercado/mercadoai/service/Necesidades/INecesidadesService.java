package com.jfranco.aimercado.mercadoai.service.Necesidades;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadResponseDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;

public interface INecesidadesService {

    List<NecesidadSummaryDTO> getAllNecesidades();

    NecesidadResponseDTO getNecesidadById(Long id);

    NecesidadResponseDTO saveNecesidad(NecesidadCreateDTO necesidad);

    NecesidadResponseDTO updateNecesidad(Long id, NecesidadUpdateDTO necesidadDTO);

    boolean deleteNecesidad(Long id);

}
