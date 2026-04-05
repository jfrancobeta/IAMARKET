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
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoStatsDTO;
import com.jfranco.aimercado.mercadoai.model.Entregable;
import com.jfranco.aimercado.mercadoai.model.Estado;
import com.jfranco.aimercado.mercadoai.model.FinalizeRequest;
import com.jfranco.aimercado.mercadoai.model.Hito;
import com.jfranco.aimercado.mercadoai.model.Propuesta;
import com.jfranco.aimercado.mercadoai.model.Proyecto;
import com.jfranco.aimercado.mercadoai.model.Solucion;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.model.CancelRequest.CancelRequest;
import com.jfranco.aimercado.mercadoai.model.CancelRequest.CancelStatus;
import com.jfranco.aimercado.mercadoai.repository.CancelRequest.CancelRequestRepository;
import com.jfranco.aimercado.mercadoai.repository.CancelRequest.FinalizeRequestRepository;
import com.jfranco.aimercado.mercadoai.model.FinalizeStatus;
import com.jfranco.aimercado.mercadoai.repository.Estado.EstadoRepository;
import com.jfranco.aimercado.mercadoai.repository.Proyecto.ProyectoRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.repository.Calificacion.CalificacionRepository;

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
    private FinalizeRequestRepository finalizeRequestRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HitoMapper hitoMapper;

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public Page<ProyectoSummaryDTO> getAll(String search, String estado, String tipo,
            Pageable pageable, String username) {

        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", username));
        
        Page<Proyecto> proyectosPage;

        if ("solucion".equalsIgnoreCase(tipo)) {
            proyectosPage = proyectoRepository.findBySolucionIsNotNullAndUsuario(usuario.getId(), pageable);
        } else if ("propuesta".equalsIgnoreCase(tipo)) {
            proyectosPage = proyectoRepository.findByPropuestaIsNotNullAndUsuario(usuario.getId(), pageable);
        } else if (search != null && !search.isEmpty()) {
            proyectosPage = proyectoRepository.searchByTituloAndUsuario(search, usuario.getId(), pageable);
        } else if (estado != null && !estado.isEmpty()) {
            proyectosPage = proyectoRepository.findByEstadoNombreIgnoreCaseAndUsuario(estado, usuario.getId(), pageable);
        } else {
            proyectosPage = proyectoRepository.findByEmpresaIdOrDesarrolladorId(usuario.getId(), usuario.getId(), pageable);
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
    public com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDetailStatsDTO getDetailStats(Long proyectoId) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        int totalHitos = proyecto.getHitos() == null ? 0 : proyecto.getHitos().size();
        int hitosCompletados = 0;
        int entregablesPendientes = 0;
        int entregablesEnRevision = 0;
        int entregablesAprobados = 0;
        java.time.LocalDate today = java.time.LocalDate.now();
        int diasRestantes = Integer.MAX_VALUE;

        if (proyecto.getHitos() != null) {
            for (Hito h : proyecto.getHitos()) {
                boolean hitoCompletado = true;
                if (h.getEntregables() != null) {
                    for (Entregable e : h.getEntregables()) {
                        String estadoNombre = e.getEstado() != null ? e.getEstado().getNombre() : "";
                        if (estadoNombre == null) estadoNombre = "";
                        String estLower = estadoNombre.toLowerCase();
                        if (estLower.contains("aprob") || estLower.equals("aprobado")) {
                            entregablesAprobados++;
                        } else if (estLower.contains("revis")) {
                            entregablesEnRevision++;
                            hitoCompletado = false;
                        } else if (estLower.contains("pend") || estLower.equals("") || estLower.contains("cread")) {
                            entregablesPendientes++;
                            hitoCompletado = false;
                        } else {
                            // any other state treat as not completed
                            hitoCompletado = false;
                        }
                    }
                } else {
                    hitoCompletado = false;
                }

                if (hitoCompletado) hitosCompletados++;

                if (h.getFechaEntrega() != null) {
                    int diff = (int) java.time.temporal.ChronoUnit.DAYS.between(today, h.getFechaEntrega());
                    if (diff >= 0 && diff < diasRestantes) diasRestantes = diff;
                }
            }
        }

        if (diasRestantes == Integer.MAX_VALUE) diasRestantes = 0;

        int totalEntregables = entregablesAprobados + entregablesEnRevision + entregablesPendientes;
        double progreso = 0.0;
        if (totalEntregables > 0) {
            progreso = ((double) entregablesAprobados / (double) totalEntregables) * 100.0;
        } else if (totalHitos > 0) {
            // fallback: progress by completed hitos
            progreso = ((double) hitosCompletados / (double) totalHitos) * 100.0;
        }

        return new com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDetailStatsDTO(hitosCompletados, totalHitos, entregablesPendientes, entregablesEnRevision, diasRestantes, Math.round(progreso*100.0)/100.0);
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
        proyecto.setEmpresa(propuesta.getNecesidad().getCompania());
        proyecto.setDesarrollador(propuesta.getDesarrollador());
        
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
    public ProyectoDTO createFromSolucion(Solucion solucion, Usuario empresa) {
        Proyecto proyecto = new Proyecto();

        Estado estado = estadoRepository.findByNombre("En Proceso")
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "nombre", "En Proceso"));
        
        proyecto.setEstado(estado);
        proyecto.setFechaInicio(LocalDate.now());
        proyecto.setSolucion(solucion);
        proyecto.setPresupuesto(solucion.getPrecio());
        proyecto.setDesarrollador(solucion.getDesarrollador());
        proyecto.setEmpresa(empresa);

        if(solucion.getHitos() != null){
            List<Hito> hitosProyecto = solucion.getHitos().stream().map(hitoSolucion -> {
                Hito hito = new Hito();
                hito.setNombre(hitoSolucion.getNombre());
                hito.setDescripcion(hitoSolucion.getDescripcion());
                hito.setFechaEntrega(hitoSolucion.getFechaEntrega());
                if (hitoSolucion.getEntregables() != null) {
                    List<Entregable> entregables = hitoSolucion.getEntregables().stream().map(entregableSolucion -> {
                        Entregable entregable = new Entregable();
                        entregable.setNombreArchivo(entregableSolucion.getNombreArchivo());
                        entregable.setFechaEntrega(entregableSolucion.getFechaEntrega());
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
    public void deleteHito(Long proyectoId, Long hitoId) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        boolean removed = proyecto.getHitos().removeIf(h -> h.getId().equals(hitoId));
        if (!removed) {
            throw new RuntimeException("Hito no encontrado");
        }
        proyectoRepository.save(proyecto);
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
    public void requestProjectFinalize(Long proyectoId, String usuario, String reason) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", proyectoId));
        Usuario solicitante = usuarioRepository.findByUsername(usuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", usuario));

        boolean exists = finalizeRequestRepository.existsByProyectoIdAndStatus(proyectoId, FinalizeStatus.PENDING);
        if (exists)
            throw new InvalidOperationException("Ya existe una solicitud de finalización pendiente para este proyecto");

        FinalizeRequest request = new FinalizeRequest();
        request.setProyecto(proyecto);
        request.setRequestedBy(solicitante);
        request.setReason(reason);
        request.setStatus(FinalizeStatus.PENDING);
        request.setRequestedAt(java.time.LocalDateTime.now());

        finalizeRequestRepository.save(request);
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
    public void approveProjectFinalize(Long proyectoId, String usuario) {
        FinalizeRequest request = finalizeRequestRepository
                .findFirstByProyectoIdAndStatus(proyectoId, FinalizeStatus.PENDING)
                .orElseThrow(() -> new ResourceNotFoundException("FinalizeRequest", "proyectoId", proyectoId));

        // The company should be the one to approve
        Proyecto proyecto = request.getProyecto();
        Usuario destinatario = proyecto.getEmpresa();
        if (!destinatario.getUsername().equals(usuario)) {
            throw new InvalidOperationException("Solo la empresa puede aprobar la solicitud de finalización");
        }

        request.setStatus(FinalizeStatus.ACCEPTED);
        request.setRespondedAt(java.time.LocalDateTime.now());
        finalizeRequestRepository.save(request);

        // finalize the project
        Estado estadoCompletado = estadoRepository.findByNombre("Completada")
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "nombre", "Completada"));

        proyecto.setEstado(estadoCompletado);
        proyectoRepository.save(proyecto);

        // create pending ratings for both parties
        this.createPendingRatingsForProject(proyecto);
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

    @Override
    public void rejectProjectFinalize(Long proyectoId, String usuario, String reason) {
        FinalizeRequest request = finalizeRequestRepository
                .findFirstByProyectoIdAndStatus(proyectoId, FinalizeStatus.PENDING)
                .orElseThrow(() -> new InvalidOperationException("No hay solicitud pendiente para este proyecto"));

        Proyecto proyecto = request.getProyecto();
        Usuario destinatario = proyecto.getEmpresa();

        if (!destinatario.getUsername().equals(usuario)) {
            throw new InvalidOperationException("Solo la empresa puede rechazar la solicitud de finalización");
        }

        request.setStatus(FinalizeStatus.REJECTED);
        request.setRespondedAt(java.time.LocalDateTime.now());
        request.setResponseReason(reason);
        finalizeRequestRepository.save(request);
    }

    @Override
    public ProyectoStatsDTO getStats(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Long usuarioId = usuario.getId();

        String completedState = "Completada";
        long completed = proyectoRepository.countByEstadoNombreAndUsuario(completedState, usuarioId);
        long active = proyectoRepository.countByEstadoNombreNotAndUsuario(completedState, usuarioId);
        java.math.BigDecimal totalRevenue = proyectoRepository.sumPresupuestoByUsuario(usuarioId);
        if (totalRevenue == null) {
            totalRevenue = java.math.BigDecimal.ZERO;
        }
        double avgProgress = 0.0; // Progress not modeled; defaulting to 0.0

        return new ProyectoStatsDTO(active, completed, totalRevenue, avgProgress);
    }

    // Finalize direct (company can finalize directly, force option)
    @Override
    public void finalizeProjectDirect(Long proyectoId, String usuario, boolean force, String reason) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", proyectoId));

        Usuario requester = usuarioRepository.findByUsername(usuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "username", usuario));

        // Only company (project owner) can finalize directly
        if (!proyecto.getEmpresa().getId().equals(requester.getId())) {
            throw new InvalidOperationException("Solo la empresa puede finalizar directamente el proyecto");
        }

        // Validate checklist
        var checklist = this.validateFinalizeChecklist(proyecto);
        if (!checklist.isEmpty() && !force) {
            throw new InvalidOperationException("Checklist incompleto: " + String.join(", ", checklist));
        }

        Estado estadoCompletado = estadoRepository.findByNombre("Completada")
                .orElseThrow(() -> new ResourceNotFoundException("Estado", "nombre", "Completada"));

        proyecto.setEstado(estadoCompletado);
        proyectoRepository.save(proyecto);

        // mark finalize request if exists
        finalizeRequestRepository.findFirstByProyectoIdAndStatus(proyectoId, com.jfranco.aimercado.mercadoai.model.FinalizeStatus.PENDING).ifPresent(req -> {
            req.setStatus(com.jfranco.aimercado.mercadoai.model.FinalizeStatus.ACCEPTED);
            req.setRespondedAt(java.time.LocalDateTime.now());
            req.setResponseReason(reason);
            finalizeRequestRepository.save(req);
        });

        // create pending ratings
        this.createPendingRatingsForProject(proyecto);

        // TODO: integrate with payment service to release/mark payments if applicable
    }

    @Override
    public java.util.List<String> getFinalizeChecklist(Long proyectoId, String usuario) {
        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto", "id", proyectoId));
        return this.validateFinalizeChecklist(proyecto);
    }

    private java.util.List<String> validateFinalizeChecklist(Proyecto proyecto) {
        java.util.List<String> issues = new java.util.ArrayList<>();

        // Check hitos and entregables
        if (proyecto.getHitos() != null) {
            for (Hito h : proyecto.getHitos()) {
                if (h.getEntregables() != null && !h.getEntregables().isEmpty()) {
                    for (Entregable e : h.getEntregables()) {
                        String estadoNombre = e.getEstado() != null ? e.getEstado().getNombre() : "";
                        String estLower = estadoNombre.toLowerCase();
                        if (!estLower.contains("aprob")) {
                            issues.add("Entregable no aprobado: " + e.getNombreArchivo());
                        }
                    }
                } else {
                    issues.add("Hito sin entregables: " + h.getNombre());
                }
            }
        }

        // Check payments (placeholder): find unpaid payments in Payment repository (not implemented)
        // if (hasUnpaidPayments) issues.add("Pagos pendientes");

        return issues;
    }

    private void createPendingRatingsForProject(Proyecto proyecto) {
        // Create rating entities in PENDING state for company->developer and developer->company
        try {
            com.jfranco.aimercado.mercadoai.model.Rating.Calificacion cal1 = new com.jfranco.aimercado.mercadoai.model.Rating.Calificacion();
            cal1.setUsuario(proyecto.getEmpresa());
            cal1.setUsuarioCalificado(proyecto.getDesarrollador());
            cal1.setProyecto(proyecto);
            cal1.setEstado(com.jfranco.aimercado.mercadoai.model.Rating.StatusRatingEnum.PENDING);
            calificacionRepository.save(cal1);

            com.jfranco.aimercado.mercadoai.model.Rating.Calificacion cal2 = new com.jfranco.aimercado.mercadoai.model.Rating.Calificacion();
            cal2.setUsuario(proyecto.getDesarrollador());
            cal2.setUsuarioCalificado(proyecto.getEmpresa());
            cal2.setProyecto(proyecto);
            cal2.setEstado(com.jfranco.aimercado.mercadoai.model.Rating.StatusRatingEnum.PENDING);
            calificacionRepository.save(cal2);
        } catch (Exception e) {
            // swallow errors for now
        }
    }

}