package com.jfranco.aimercado.mercadoai.controllers.Estado;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.service.Estado.IEstadoService;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private IEstadoService estadoService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try{
            return ResponseEntity.ok(estadoService.getAllEstados());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Error al obtener los estados");
        }
    }
}