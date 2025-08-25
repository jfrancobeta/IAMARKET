package com.jfranco.aimercado.mercadoai.service.Necesidad;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;

public interface INecesidadesService {

    List<NecesidadSummaryDTO> getAllNecesidades();

    NecesidadUserDetailsDTO getNecesidadById(Long id);

    NecesidadDTO saveNecesidad(NecesidadCreateDTO necesidad);

    NecesidadDTO updateNecesidad(Long id, NecesidadUpdateDTO necesidadDTO);

    boolean deleteNecesidad(Long id);

}
