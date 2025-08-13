package com.jfranco.aimercado.mercadoai.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadUpdateDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadResponseDTO;
import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadSummaryDTO;
import com.jfranco.aimercado.mercadoai.service.Necesidades.INecesidadesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<NecesidadSummaryDTO>> listar() {
        try {
            List<NecesidadSummaryDTO> necesidades = necesidadesService.getAllNecesidades();
            return ResponseEntity.ok(necesidades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<NecesidadResponseDTO> obtenerPorId(@PathVariable Long id) {
        try {
            NecesidadResponseDTO necesidad = necesidadesService.getNecesidadById(id);
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
    public ResponseEntity<NecesidadResponseDTO> crear(@Valid @RequestBody NecesidadCreateDTO necesidadCreateDTO) {
        try {
            NecesidadResponseDTO nuevaNecesidad = necesidadesService.saveNecesidad(necesidadCreateDTO);
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
    public ResponseEntity<NecesidadResponseDTO> actualizar(@PathVariable Long id, 
                                                          @Valid @RequestBody NecesidadUpdateDTO necesidadUpdateDTO) {
        try {
            NecesidadResponseDTO necesidadActualizada = necesidadesService.updateNecesidad(id, necesidadUpdateDTO);
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
