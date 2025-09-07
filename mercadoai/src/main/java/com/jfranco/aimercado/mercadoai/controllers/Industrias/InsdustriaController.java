package com.jfranco.aimercado.mercadoai.controllers.Industrias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.service.Industria.IIndustriaService;

@RestController
@RequestMapping("/industrias")
public class InsdustriaController {

    @Autowired
    private IIndustriaService industriaService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(industriaService.getAllIndustrias());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener industrias: " + e.getMessage());
        }
    }
}