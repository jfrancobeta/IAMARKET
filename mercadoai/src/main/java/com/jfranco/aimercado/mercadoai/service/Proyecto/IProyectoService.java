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
import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.model.Usuario;

public interface IProyectoService {

    com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoStatsDTO getStats(String username);
    
    ProyectoDTO update(Long id, ProyectoUpdateDTO dto);
    ProyectoDTO getById(Long id);
    com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDetailStatsDTO getDetailStats(Long proyectoId);
    Page<ProyectoSummaryDTO> getAll(String search, String estado, String tipo, Pageable pageable, String username);
    void delete(Long id);
    ProyectoDTO createFromPropuesta(Propuesta propuestaId);
    ProyectoDTO createFromSolucion(Solucion solucion, Usuario empresa);
    HitoDTO addHito(Long proyectoId, HitoCreateDTO dto);
    HitoDTO updateHito(Long proyectoId, Long hitoId, HitoUpdateDTO dto);
    void deleteHito(Long proyectoId, Long hitoId);
    void requestProjectCancel(Long proyectoId, String usuario, String reason);
    void requestProjectFinalize(Long proyectoId, String usuario, String reason);
    void approveProjectFinalize(Long proyectoId, String usuario);
    void rejectProjectFinalize(Long proyectoId, String usuario, String reason);
    void finalizeProjectDirect(Long proyectoId, String usuario, boolean force, String reason);
    void approveProjectCancel(Long proyectoId, String usuario);
    void rejectProjectCancel(Long proyectoId, String usuario, String reason);
    java.util.List<String> getFinalizeChecklist(Long proyectoId, String usuario);
}
