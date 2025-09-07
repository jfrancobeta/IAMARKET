package com.jfranco.aimercado.mercadoai.controllers.Paises;

import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.service.Pais.IPaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private IPaisService  paisService;

    @GetMapping("/")
    public ResponseEntity<?> GetAll() {
        try {
            return ResponseEntity.ok(paisService.getAllPaises());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener paises: " + e.getMessage());
        }
    }
}