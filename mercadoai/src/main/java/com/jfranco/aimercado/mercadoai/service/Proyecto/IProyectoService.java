package com.jfranco.aimercado.mercadoai.service.Proyecto;

import java.util.List;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;

public interface IProyectoService {
    
    ProyectoDTO save(ProyectoCreateDTO dto);
    ProyectoDTO update(Long id, ProyectoUpdateDTO dto);
    ProyectoDTO getById(Long id);
    List<ProyectoDTO> getAll();
    void delete(Long id);

}
