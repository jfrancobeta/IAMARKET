package com.jfranco.aimercado.mercadoai.controllers.Proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Hito.HitoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoDTO;
import com.jfranco.aimercado.mercadoai.dto.Hito.HitoUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoStatsDTO;
import com.jfranco.aimercado.mercadoai.service.Proyecto.IProyectoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping("/")
    public ResponseEntity<Page<ProyectoSummaryDTO>> listar(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String tipo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @AuthenticationPrincipal String username) {
        try {
            PageRequest pageable = PageRequest.of(page, size);
            Page<ProyectoSummaryDTO> proyectos = proyectoService.getAll(search, estado, tipo, pageable, username);
            return ResponseEntity.ok(proyectos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> getById(@PathVariable Long id) {
        try {
            ProyectoDTO proyecto = proyectoService.getById(id);
            if (proyecto != null) {
                return ResponseEntity.ok(proyecto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDetailStatsDTO> getDetailStats(@PathVariable Long id) {
        try {
            var stats = proyectoService.getDetailStats(id);
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO> actualizar(@PathVariable Long id,
            @Valid @RequestBody ProyectoUpdateDTO proyectoUpdateDTO) {
        try {
            ProyectoDTO proyectoActualizado = proyectoService.update(id, proyectoUpdateDTO);
            if (proyectoActualizado != null) {
                return ResponseEntity.ok(proyectoActualizado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        try {
            proyectoService.delete(id);
            return ResponseEntity.ok("Proyecto eliminado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado con id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor");
        }
    }

    @PostMapping("/{proyectoId}/hitos")
    public ResponseEntity<?> addHito(
            @PathVariable Long proyectoId,
            @RequestBody HitoCreateDTO dto) {
        try {
            HitoDTO nuevoHito = proyectoService.addHito(proyectoId, dto);
            return ResponseEntity.status(201).body(nuevoHito);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al agregar el hito: " + e.getMessage());
        }
    }

    @PutMapping("/{proyectoId}/hitos/{hitoId}")
    public ResponseEntity<?> updateHito(
            @PathVariable Long proyectoId,
            @PathVariable Long hitoId,
            @RequestBody HitoUpdateDTO dto) {
        try {
            HitoDTO hitoActualizado = proyectoService.updateHito(proyectoId, hitoId, dto);
            return ResponseEntity.ok(hitoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hito o proyecto no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el hito");
        }
    }

    @DeleteMapping("/{proyectoId}/hitos/{hitoId}")
    public ResponseEntity<?> deleteHito(@PathVariable Long proyectoId, @PathVariable Long hitoId) {
        try {
            proyectoService.deleteHito(proyectoId, hitoId);
            return ResponseEntity.ok("Hito eliminado");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hito o proyecto no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el hito");
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @PostMapping("/{id}/cancel-request")
    public ResponseEntity<?> requestCancel(
            @PathVariable Long id,
            @RequestBody String reason,
            @AuthenticationPrincipal String user) {
        proyectoService.requestProjectCancel(id, user, reason);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @PostMapping("/{id}/cancel-accept")
    public ResponseEntity<?> approveCancel(
            @PathVariable Long id,
            @AuthenticationPrincipal String user) {
        proyectoService.approveProjectCancel(id, user);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @PostMapping("/{id}/cancel-reject")
    public ResponseEntity<?> rejectCancel(
            @PathVariable Long id,
            @RequestBody String reason,
            @AuthenticationPrincipal String user) {
        proyectoService.rejectProjectCancel(id, user, reason);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stats")
    public ResponseEntity<ProyectoStatsDTO> getStats(@AuthenticationPrincipal String username) {
        try {
            ProyectoStatsDTO stats = proyectoService.getStats(username);
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
