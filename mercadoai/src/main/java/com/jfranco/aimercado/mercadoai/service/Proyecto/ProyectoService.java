package com.jfranco.aimercado.mercadoai.service.Proyecto;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.exception.InvalidOperationException;
import com.jfranco.aimercado.mercadoai.exception.ResourceNotFoundException;
import com.jfranco.aimercado.mercadoai.mapper.Hito.HitoMapper;
import com.jfranco.aimercado.mercadoai.mapper.Proyecto.ProyectoMapper;
import com.jfranco.aimercado.mercadoai.model.Entregable;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.Hito;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Proyecto;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.model.CancelRequest.CancelRequest;
import com.jfranco.aimercado.mercadoai.model.CancelRequest.CancelStatus;
import com.jfranco.aimercado.mercadoai.repository.CancelRequest.CancelRequestRepository;
import com.jfranco.aimercado.mercadoai.repository.Estado.EstadoRepository;
import com.jfranco.aimercado.mercadoai.repository.Proyecto.ProyectoRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private ProyectoMapper proyectoMapper;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CancelRequestRepository cancelRequestRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HitoMapper hitoMapper;

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

    @Override
    public ProyectoDTO createFromPropuesta(Propuesta propuesta) {
        Proyecto proyecto = new Proyecto();

        Estado estado = estadoRepository.findByNombre("En Proceso")
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        proyecto.setEstado(estado);
        proyecto.setFechaInicio(LocalDate.now());
        proyecto.setPropuesta(propuesta);
        proyecto.setPresupuesto(propuesta.getPrecio());
        if (propuesta.getHitos() != null) {
            List<Hito> hitosProyecto = propuesta.getHitos().stream().map(hitoPropuesta -> {
                Hito hito = new Hito();
                hito.setNombre(hitoPropuesta.getNombre());
                hito.setDescripcion(hitoPropuesta.getDescripcion());
                hito.setFechaEntrega(hitoPropuesta.getFechaEntrega());
                if (hitoPropuesta.getEntregables() != null) {
                    List<Entregable> entregables = hitoPropuesta.getEntregables().stream().map(entregablePropuesta -> {
                        Entregable entregable = new Entregable();
                        entregable.setNombreArchivo(entregablePropuesta.getNombreArchivo());
                        entregable.setFechaEntrega(entregablePropuesta.getFechaEntrega());
                        entregable.setHito(hito);
                        return entregable;
                    }).toList();
                    hito.setEntregables(entregables);
                }
                return hito;
            }).toList();
            proyecto.setHitos(hitosProyecto);
        }

        proyectoRepository.save(proyecto);

        return proyectoMapper.toDto(proyecto);
    }

    @Override
    public HitoDTO addHito(Long proyectoId, HitoCreateDTO dto) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Hito hito = hitoMapper.toEntity(dto);

        Estado estadoCreado = estadoRepository.findByNombre("Creado")
                .orElseThrow(() -> new RuntimeException("Estado 'Creado' no encontrado"));

        if (dto.getEntregables() != null) {
            List<Entregable> entregables = dto.getEntregables().stream().map(entregableDTO -> {
                Entregable entregable = new Entregable();
                entregable.setNombreArchivo(entregableDTO.getNombreArchivo());
                entregable.setHito(hito);
                entregable.setEstado(estadoCreado);
                return entregable;
            }).toList();
            hito.setEntregables(entregables);
        }

        if (proyecto.getHitos() == null) {
            proyecto.setHitos(new java.util.ArrayList<>());
        }
        proyecto.getHitos().add(hito);

        proyectoRepository.save(proyecto);

        HitoDTO hitoDTO = hitoMapper.toDTO(hito);

        return hitoDTO;
    }

    @Override
    public HitoDTO updateHito(Long proyectoId, Long hitoId, HitoUpdateDTO dto) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Hito hito = proyecto.getHitos().stream()
                .filter(h -> h.getId().equals(hitoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Hito no encontrado"));

        Estado estadoCreado = estadoRepository.findByNombre("Creado")
                .orElseThrow(() -> new RuntimeException("Estado 'Creado' no encontrado"));

        hitoMapper.updateEntity(dto, hito);

        if (dto.getEntregables() != null) {

            hito.getEntregables().clear();

            for (var entregableDTO : dto.getEntregables()) {
                Entregable entregable = new Entregable();

                entregable.setNombreArchivo(entregableDTO.getNombreArchivo());
                entregable.setHito(hito);
                entregable.setEstado(estadoCreado);

                hito.getEntregables().add(entregable);
            }
        }

        proyectoRepository.save(proyecto);

        return hitoMapper.toDTO(hito);
    }

    @Override
    public void requestProjectCancel(Long proyectoId, String usuario, String reason) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", proyectoId));
        Usuario solicitante = usuarioRepository.findByUsername(usuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", usuario));

        boolean exists = cancelRequestRepository.existsByProyectoIdAndStatus(proyectoId, CancelStatus.PENDING);
        
        if (exists)
            throw new InvalidOperationException("Ya existe una solicitud de cancelación pendiente para este proyecto");

        Usuario destinatario = proyecto.getEmpresa().getId().equals(solicitante.getId()) ? proyecto.getDesarrollador() : proyecto.getEmpresa();

        CancelRequest request = new CancelRequest();
        request.setProyecto(proyecto);
        request.setRequestedBy(solicitante);
        request.setRequestedTo(destinatario);
        request.setReason(reason);
        request.setStatus(CancelStatus.PENDING);
        request.setRequestedAt(java.time.LocalDateTime.now());

        cancelRequestRepository.save(request);
    }

    @Override
    public void approveProjectCancel(Long proyectoId, String usuario) {
        CancelRequest request = cancelRequestRepository
                .findFirstByProyectoIdAndStatus(proyectoId, CancelStatus.PENDING)
                .orElseThrow(() -> new ResourceNotFoundException("CancelRequest", "proyectoId", proyectoId));

        if (!request.getRequestedTo().getUsername().equals(usuario)) {
            throw new InvalidOperationException("Solo la otra parte puede aprobar la cancelación");
        }

        request.setStatus(CancelStatus.ACCEPTED);
        request.setRespondedAt(java.time.LocalDateTime.now());
        cancelRequestRepository.save(request);

        Proyecto proyecto = request.getProyecto();
        Estado estadoCancelado = estadoRepository.findByNombre("Cancelada")
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "nombre", "Cancelada"));

        proyecto.setEstado(estadoCancelado);
        proyectoRepository.save(proyecto);
    }

    @Override
    public void rejectProjectCancel(Long proyectoId, String usuario, String reason) {
        CancelRequest request = cancelRequestRepository
                .findFirstByProyectoIdAndStatus(proyectoId, CancelStatus.PENDING)
                .orElseThrow(() -> new InvalidOperationException("No hay solicitud pendiente para este proyecto"));

        if (!request.getRequestedTo().getUsername().equals(usuario)) {
            throw new InvalidOperationException("Solo la otra parte puede rechazar la cancelación");
        }

        request.setStatus(CancelStatus.REJECTED);
        request.setRespondedAt(java.time.LocalDateTime.now());
        request.setResponseReason(reason);
        cancelRequestRepository.save(request);
    }

}