package com.jfranco.aimercado.mercadoai.service.Propuestas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Propuesta.PropuestaMapper;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.repository.Propuesta.PropuestaRepository;

public class PropuestaServiceImpl implements IPropuestasService {

    @Autowired
    private PropuestaRepository propuestaRepository;

    @Autowired
    private PropuestaMapper propuestaMapper;

    @Override
    public PropuestaDTO save(PropuestaCreateDTO dto) {
        Propuesta propuesta = propuestaMapper.toEntity(dto);
        propuesta = propuestaRepository.save(propuesta);

        return propuestaMapper.toDto(propuesta);
    }

    @Override
    public PropuestaDTO update(Long id, PropuestaUpdateDTO dto) {
        Propuesta propuesta = propuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id " + id));
        
        propuestaMapper.updateEntityFromDto(dto, propuesta);
        propuesta = propuestaRepository.save(propuesta);
        
        return propuestaMapper.toDto(propuesta);
    }

    @Override
    public PropuestaDTO getById(Long id) {
        Propuesta propuesta = propuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id " + id));
        return propuestaMapper.toDto(propuesta);
    }

    @Override
    public Page<PropuestaSummaryDTO> getAll(String search, String estado, Pageable pageable) {
        Page<Propuesta> propuestas;
        if (search != null && !search.isEmpty()) {
            propuestas = propuestaRepository.findByNecesidadTituloContainingIgnoreCase(search, pageable);
        } else if (estado != null && !estado.isEmpty()) {
            propuestas = propuestaRepository.findByEstadoNombreIgnoreCase(estado, pageable);
        } else {
            propuestas = propuestaRepository.findAll(pageable);
        }
        return propuestas.map(propuesta -> propuestaMapper.toSummaryDto(propuesta));
    }

    @Override
    public void delete(Long id) {
        Propuesta propuesta = propuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id " + id));
        propuestaRepository.delete(propuesta);
    }

}
