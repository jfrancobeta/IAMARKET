package com.jfranco.aimercado.mercadoai.service.Proyecto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Propuesta;

public interface IProyectoService {
    
    ProyectoDTO save(ProyectoCreateDTO dto);
    ProyectoDTO update(Long id, ProyectoUpdateDTO dto);
    ProyectoDTO getById(Long id);
    Page<ProyectoSummaryDTO> getAll(String search, String estado, String tipo, Pageable pageable);
    void delete(Long id);
    ProyectoDTO createFromPropuesta(Propuesta propuestaId);

}
