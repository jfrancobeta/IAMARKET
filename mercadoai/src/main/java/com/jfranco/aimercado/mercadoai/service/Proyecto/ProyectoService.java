package com.jfranco.aimercado.mercadoai.service.Proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Proyecto.ProyectoMapper;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Proyecto;
import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.repository.Propuesta.PropuestaRepository;
import com.jfranco.aimercado.mercadoai.repository.Proyecto.ProyectoRepository;
import com.jfranco.aimercado.mercadoai.repository.Solucion.SolucionesRespository;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private PropuestaRepository propuestaRepository;

    @Autowired
    private SolucionesRespository solucionesRespository;
    
    @Autowired
    private ProyectoMapper proyectoMapper;
    
    @Override
    public Page<ProyectoSummaryDTO> getAll(String search, String estado, String tipo,
            Pageable pageable) {

        Page<Proyecto> proyectosPage;

        if ("solucion".equalsIgnoreCase(tipo)) {
            proyectosPage = proyectoRepository.findBySolucionIsNotNull(pageable);
        } else if ("propuesta".equalsIgnoreCase(tipo)) {
            proyectosPage = proyectoRepository.findByPropuestaIsNotEmpty(pageable);
        } else if (search != null && !search.isEmpty()) {
            proyectosPage = proyectoRepository.searchByTitulo(search, pageable);
        } else if (estado != null && !estado.isEmpty()) {
            proyectosPage = proyectoRepository.findByEstadoNombreIgnoreCase(estado, pageable);
        } else {
            proyectosPage = proyectoRepository.findAll(pageable);
        }

        return proyectosPage.map(proyectoMapper::toSummaryDTO);
    }

    @Override
    public ProyectoDTO save(ProyectoCreateDTO dto) {
        Propuesta propuesta = propuestaRepository.findById(dto.getPropuestaId())
            .orElseThrow(() -> new RuntimeException("Propuesta no encontrada"));

        Solucion solucion = solucionesRespository.findById(dto.getSolucionId())
            .orElseThrow(() -> new RuntimeException("Solucion no encontrada"));

        Proyecto proyecto = proyectoMapper.toEntity(dto, propuesta, solucion);

        proyecto = proyectoRepository.save(proyecto);
        
        return proyectoMapper.toDto(proyecto);
    }

    @Override
    public ProyectoDTO update(Long id, ProyectoUpdateDTO dto) {
        Proyecto proyecto = proyectoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        
        proyectoMapper.updateEntity(dto, proyecto);
        proyecto = proyectoRepository.save(proyecto);

        return proyectoMapper.toDto(proyecto);
    }

    @Override
    public ProyectoDTO getById(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        
        return proyectoMapper.toDto(proyecto);
    }


    @Override
    public void delete(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        proyectoRepository.delete(proyecto);
    }

    
    
}