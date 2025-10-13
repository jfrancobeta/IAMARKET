package com.jfranco.aimercado.mercadoai.service.Propuestas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUpdateDTO;
import com.jfranco.aimercado.mercadoai.mapper.Propuesta.PropuestaMapper;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.Estado.EstadoRepository;
import com.jfranco.aimercado.mercadoai.repository.Necesidad.NecesidadesRepository;
import com.jfranco.aimercado.mercadoai.repository.Propuesta.PropuestaRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.service.Proyecto.ProyectoService;

@Service
public class PropuestaServiceImpl implements IPropuestasService {

    @Autowired
    private PropuestaRepository propuestaRepository;

    @Autowired
    private PropuestaMapper propuestaMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NecesidadesRepository necesidadRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ProyectoService proyectoService;

    @Override
    public PropuestaDTO save(PropuestaCreateDTO dto) {
        Long desarrolladorId = getUsuarioActualId();
        
        Usuario desarrollador = usuarioRepository.findById(desarrolladorId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Necesidad necesidad = necesidadRepository.findById(dto.getNecesidadId())
                .orElseThrow(() -> new RuntimeException("Necesidad no encontrada"));

        Estado estado = estadoRepository.findByNombre("PENDIENTE")
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        Propuesta propuesta = propuestaMapper.toEntity(dto, necesidad, desarrollador, estado);

        if (propuesta.getHitos() != null) {
            propuesta.getHitos().forEach(hito -> {
                if (hito.getEntregables() != null) {
                    hito.getEntregables().forEach(entregable -> entregable.setHito(hito));
                }
            });
        }
        propuesta = propuestaRepository.save(propuesta);
        return propuestaMapper.toDto(propuesta);
    }

    @Override
    public PropuestaDTO update(Long id, PropuestaUpdateDTO dto) {
        Propuesta propuesta = propuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id " + id));

        propuestaMapper.updateEntityFromDto(dto, propuesta);
        
        if (propuesta.getHitos() != null) {
            propuesta.getHitos().forEach(hito -> {
                if (hito.getEntregables() != null) {
                    hito.getEntregables().forEach(entregable -> entregable.setHito(hito));
                }
            });
        }

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
    public Page<PropuestaSummaryDTO> getAllSent(String search, String estado, Pageable pageable) {
        Long desarrolladorId = getUsuarioActualId();
        Page<Propuesta> propuestas;
        if (search != null && !search.isEmpty()) {
            propuestas = propuestaRepository
                    .findByDesarrolladorIdAndNecesidadTituloContainingIgnoreCase(desarrolladorId, search, pageable);
        } else if (estado != null && !estado.isEmpty()) {
            propuestas = propuestaRepository.findByDesarrolladorIdAndEstadoNombreIgnoreCase(desarrolladorId, estado,
                    pageable);
        } else {
            propuestas = propuestaRepository.findByDesarrolladorId(desarrolladorId, pageable);
        }
        return propuestas.map(propuesta -> propuestaMapper.toSummaryDto(propuesta));
    }

    @Override
    public Page<PropuestaSummaryDTO> getAllReceived(Pageable pageable) {
        Long usuarioId = getUsuarioActualId();
        Page<Propuesta> propuestas = propuestaRepository.findByNecesidadCompaniaId(usuarioId, pageable);
        return propuestas.map(propuestaMapper::toSummaryDto);
    }

    @Override
    public void delete(Long id) {
        Propuesta propuesta = propuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id " + id));
        propuestaRepository.delete(propuesta);
    }

    private Long getUsuarioActualId() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"))
                .getId();
    }

    @Override
    public void aceptarPropuesta(Long id) {
        Propuesta propuesta = propuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada con id " + id));

        Estado estadoAceptado = estadoRepository.findByNombre("Aceptada")
                .orElseThrow(() -> new RuntimeException("Estado 'Aceptada' no encontrado"));

        propuesta.setEstado(estadoAceptado);

        List<Propuesta> otras = propuestaRepository.findByNecesidad(propuesta.getNecesidad());
        Estado rechazada = estadoRepository.findByNombre("Rechazada")
                .orElseThrow(() -> new RuntimeException("Estado 'Rechazada' no encontrado"));
        for (Propuesta otra : otras) {
            if (!otra.getId().equals(id)) {
                otra.setEstado(rechazada);
                propuestaRepository.save(otra);
            }
        }

        Necesidad necesidad = propuesta.getNecesidad();
        Estado estadoAceptadoNecesidad = estadoRepository.findByNombre("En Proceso")
                .orElseThrow(() -> new RuntimeException("Estado 'EN PROGRESO' no encontrado"));
        necesidad.setEstado(estadoAceptadoNecesidad);
        necesidadRepository.save(necesidad);

        proyectoService.createFromPropuesta(propuesta);

        propuestaRepository.save(propuesta);
    }

    @Override
    public void rechazarPropuesta(Long id) {
        Propuesta propuesta = propuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propuesta no encontrada"));
        Estado rechazada = estadoRepository.findByNombre("Rechazada")
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        propuesta.setEstado(rechazada);
        propuestaRepository.save(propuesta);
    }

}
