package com.jfranco.aimercado.mercadoai.service.Propuestas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUpdateDTO;


public interface IPropuestasService {
    PropuestaDTO save(PropuestaCreateDTO dto);
    PropuestaDTO update(Long id, PropuestaUpdateDTO dto);
    PropuestaDTO getById(Long id);
    Page<PropuestaSummaryDTO> getAll(String search, String estado, Pageable pageable);
    void delete(Long id);
}
