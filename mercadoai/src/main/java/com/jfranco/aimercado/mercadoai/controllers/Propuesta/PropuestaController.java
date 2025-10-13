package com.jfranco.aimercado.mercadoai.controllers.Propuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaCreateDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaSummaryDTO;
import com.jfranco.aimercado.mercadoai.dto.Propuesta.PropuestaUpdateDTO;
import com.jfranco.aimercado.mercadoai.service.Propuestas.IPropuestasService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/propuestas")
public class PropuestaController {

    @Autowired
    private IPropuestasService propuestaService;

    @GetMapping("/sent")
    public ResponseEntity<?> getAll(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            PageRequest pageable = PageRequest.of(page, size);
            Page<PropuestaSummaryDTO> propuestas = propuestaService.getAllSent(search, estado, pageable);
            return ResponseEntity.ok(propuestas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request");
        }
    }

    @GetMapping("/received")
    public ResponseEntity<?> getAllReceived(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            PageRequest pageable = PageRequest.of(page, size);
            Page<PropuestaSummaryDTO> propuestas = propuestaService.getAllReceived(pageable);
            return ResponseEntity.ok(propuestas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            PropuestaDTO propuesta = propuestaService.getById(id);
            return ResponseEntity.ok(propuesta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            propuestaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PropuestaCreateDTO propuesta) {
        try {
            PropuestaDTO created = propuestaService.save(propuesta);
            return ResponseEntity.status(201).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PropuestaUpdateDTO propuesta) {
        try {
            PropuestaDTO updated = propuestaService.update(id, propuesta);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request");
        }
    }

    @PostMapping("/{id}/aceptar")
    public ResponseEntity<?> aceptarPropuesta(@PathVariable Long id) {
        try {
            propuestaService.aceptarPropuesta(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al aceptar la propuesta");
        }
    }

    @PostMapping("/{id}/rechazar")
    public ResponseEntity<?> rechazarPropuesta(@PathVariable Long id) {
        try {
            propuestaService.rechazarPropuesta(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al rechazar la propuesta");
        }
    }


}
