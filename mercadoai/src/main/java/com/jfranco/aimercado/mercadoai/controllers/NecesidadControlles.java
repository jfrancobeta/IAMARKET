package com.jfranco.aimercado.mercadoai.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Need.NecesidadDTO;
import com.jfranco.aimercado.mercadoai.model.Necesidad;
import com.jfranco.aimercado.mercadoai.service.Necesidades.INecesidadesService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/necesidades")
public class NecesidadControlles {


    @Autowired
    private INecesidadesService necesidadesService;

    @GetMapping("/")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(necesidadesService.getAllNecesidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getid(@PathVariable Long id) {
        return ResponseEntity.ok(necesidadesService.getNecesidadById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> guardar(@RequestBody NecesidadDTO necesidad) {
        Necesidad entity = necesidadesService.saveNecesidad(necesidad);
        if (entity == null) {
            return ResponseEntity.badRequest().body("Error al guardar la necesidad");
        }
        return ResponseEntity.ok(entity);
        
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody NecesidadDTO necesidad) {
        try {
            Necesidad actualizada = necesidadesService.updateNecesidad(id, necesidad);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Necesidad> neceOptional = Optional.of(necesidadesService.getNecesidadById(id));
        if (neceOptional.isPresent()) {
            necesidadesService.deleteNecesidad(id);
            return ResponseEntity.ok("Necesidad eliminada exitosamente");
        } else {
            return ResponseEntity.status(404).body("Necesidad no encontrada con id: " + id);
            
        }
    }
    
    
    
    
}
