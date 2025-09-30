package com.jfranco.aimercado.mercadoai.controllers.Proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Proyecto.ProyectoUpdateDTO;
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
            @RequestParam(defaultValue = "10") int size) {
        try {
            PageRequest pageable = PageRequest.of(page, size);
            Page<ProyectoSummaryDTO> proyectos = proyectoService.getAll(search, estado, tipo, pageable);
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

    @PostMapping("/")
    public ResponseEntity<ProyectoDTO> crear(@Valid @RequestBody ProyectoCreateDTO proyectoCreateDTO) {
        try {
            ProyectoDTO nuevoProyecto = proyectoService.save(proyectoCreateDTO);
            if (nuevoProyecto != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProyecto);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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
}
