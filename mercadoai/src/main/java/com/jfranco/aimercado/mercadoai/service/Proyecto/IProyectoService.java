package com.jfranco.aimercado.mercadoai.service.Proyecto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.model.Propuesta;

public interface IProyectoService {
    
    ProyectoDTO update(Long id, ProyectoUpdateDTO dto);
    ProyectoDTO getById(Long id);
    Page<ProyectoSummaryDTO> getAll(String search, String estado, String tipo, Pageable pageable);
    void delete(Long id);
    ProyectoDTO createFromPropuesta(Propuesta propuestaId);
    HitoDTO addHito(Long proyectoId, HitoCreateDTO dto);
    HitoDTO updateHito(Long proyectoId, Long hitoId, HitoUpdateDTO dto);
    void requestProjectCancel(Long proyectoId, String usuario, String reason);
    void approveProjectCancel(Long proyectoId, String usuario);
    void rejectProjectCancel(Long proyectoId, String usuario, String reason);
}
