package com.jfranco.aimercado.mercadoai.controllers.Habilidad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Habilidad.HabilidadCreateDTO;
import com.jfranco.aimercado.mercadoai.service.Habilidad.IHabilidadService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {

    @Autowired
    private IHabilidadService habilidadService;


    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(habilidadService.getAllHabilidades());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener habilidades: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(habilidadService.getHabilidadById(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Habilidad no encontrada: " + e.getMessage());
        }
    }


    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody HabilidadCreateDTO habilidadDTO) {
        try {
            return ResponseEntity.ok(habilidadService.saveHabilidad(habilidadDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear habilidad: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            habilidadService.deleteHabilidad(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar habilidad: " + e.getMessage());
        }
    }
}
