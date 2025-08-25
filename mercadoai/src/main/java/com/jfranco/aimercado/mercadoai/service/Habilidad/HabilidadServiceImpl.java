package com.jfranco.aimercado.mercadoai.service.Habilidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadDTO;
import com.jfranco.aimercado.mercadoai.mapper.Habilidad.HabilidadMapper;
import com.jfranco.aimercado.mercadoai.model.Habilidad;
import com.jfranco.aimercado.mercadoai.repository.Habilidad.HabilidadRepository;

@Service
public class HabilidadServiceImpl implements IHabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @Autowired
    private HabilidadMapper habilidadMapper;

    @Override
    public List<HabilidadDTO> getAllHabilidades() {
        List<Habilidad> habilidades = habilidadRepository.findAll();
        return habilidades.stream()
                .map(habilidadMapper::toDTO)
                .toList();
    }

    @Override
    public HabilidadDTO getHabilidadById(Long id) {
        Habilidad habilidad = habilidadRepository.findById(id)
                .orElseThrow();
        return habilidadMapper.toDTO(habilidad);
    }

    @Override
    public HabilidadDTO saveHabilidad(HabilidadCreateDTO habilidadDTO) {
        Habilidad habilidad = habilidadMapper.toEntity(habilidadDTO);
        habilidad = habilidadRepository.save(habilidad);
        return habilidadMapper.toDTO(habilidad);
    }
    

    @Override
    public void deleteHabilidad(Long id) {
        Habilidad habilidad = habilidadRepository.findById(id)
                .orElseThrow();
        habilidadRepository.delete(habilidad);
    }
}