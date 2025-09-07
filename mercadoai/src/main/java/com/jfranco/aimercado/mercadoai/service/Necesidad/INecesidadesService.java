package com.jfranco.aimercado.mercadoai.service.Necesidad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;

public interface INecesidadesService {

    Page<NecesidadSummaryDTO> getAllNecesidades(String search, String categoria, String estado, Pageable pageable);

    NecesidadUserDetailsDTO getNecesidadByIdDetails(Long id);

    NecesidadDTO getNecesidadById(Long id);

    NecesidadDTO saveNecesidad(NecesidadCreateDTO necesidad);

    NecesidadDTO updateNecesidad(Long id, NecesidadUpdateDTO necesidadDTO);

    boolean deleteNecesidad(Long id);

}
