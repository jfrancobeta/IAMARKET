package com.jfranco.aimercado.mercadoai.controllers.Necesidad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUserDetailsDTO;
import com.jfranco.aimercado.mercadoai.service.Necesidad.INecesidadesService;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;

import java.util.List;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/necesidades")
public class NecesidadControlles {

    @Autowired
    private INecesidadesService necesidadesService;

    @GetMapping("/")
    public ResponseEntity<Page<NecesidadSummaryDTO>> listar(
        @RequestParam(required = false) String search,
        @RequestParam(required = false) String categoria,
        @RequestParam(required = false) String estado,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        try {
            PageRequest pageable = PageRequest.of(page, size);
            Page<NecesidadSummaryDTO> necesidades = necesidadesService.getAllNecesidades(search, categoria, estado, pageable);
            return ResponseEntity.ok(necesidades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<NecesidadDTO> getById(@PathVariable Long id) {
        try {
            NecesidadDTO necesidad = necesidadesService.getNecesidadById(id);
            if (necesidad != null) {
                return ResponseEntity.ok(necesidad);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<NecesidadUserDetailsDTO> getByidDetails(@PathVariable Long id) {
        try {
            NecesidadUserDetailsDTO necesidad = necesidadesService.getNecesidadByIdDetails(id);
            if (necesidad != null) {
                return ResponseEntity.ok(necesidad);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<NecesidadDTO> crear(@Valid @RequestBody NecesidadCreateDTO necesidadCreateDTO) {
        try {
            NecesidadDTO nuevaNecesidad = necesidadesService.saveNecesidad(necesidadCreateDTO);
            if (nuevaNecesidad != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNecesidad);
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
    public ResponseEntity<NecesidadDTO> actualizar(@PathVariable Long id, 
                                                          @Valid @RequestBody NecesidadUpdateDTO necesidadUpdateDTO) {
        try {
            NecesidadDTO necesidadActualizada = necesidadesService.updateNecesidad(id, necesidadUpdateDTO);
            if (necesidadActualizada != null) {
                return ResponseEntity.ok(necesidadActualizada);
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
            boolean eliminada = necesidadesService.deleteNecesidad(id);
            if (eliminada) {
                return ResponseEntity.ok("Necesidad eliminada exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Necesidad no encontrada con id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error interno del servidor");
        }
    }
}
