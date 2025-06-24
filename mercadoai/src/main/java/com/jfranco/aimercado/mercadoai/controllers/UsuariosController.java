package com.jfranco.aimercado.mercadoai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.RegistroRequest;
import com.jfranco.aimercado.mercadoai.service.IUsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController()
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok(usuarioService.getUsuarioById(id));
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> save(@RequestBody RegistroRequest registroRequest) {
        try{
            usuarioService.saveUsuario(registroRequest);
            return ResponseEntity.ok("Usuario registrado exitosamente");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al registrar el usuario: " + e.getMessage());
        }
        
    }
    
    
    
    
}
