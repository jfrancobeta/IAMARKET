package com.jfranco.aimercado.mercadoai.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.RegistroRequest;
import com.jfranco.aimercado.mercadoai.dto.ResetCodeRequest;
import com.jfranco.aimercado.mercadoai.dto.ResetPasswordRequest;
import com.jfranco.aimercado.mercadoai.dto.VerifyCodeRequest;
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

    @PostMapping("/create-user")
    public ResponseEntity<?> save(@RequestBody RegistroRequest registroRequest) {
        try{
            usuarioService.saveUsuario(registroRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "Usuario registrado exitosamente"));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al registrar el usuario: " + e.getMessage());
        }
        
    }

    // Enviar código de recuperación al correo
    @PostMapping("/send-reset-code")
    public ResponseEntity<?> sendResetCode(@RequestBody ResetCodeRequest request) {
        try {
            boolean valid = usuarioService.sendResetCode(request.getEmail());
            if (!valid) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correo no encontrado");
            }else {
                return ResponseEntity.ok(Collections.singletonMap("message", "Código enviado al correo"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al enviar el código: " + e.getMessage());
        }
    }

    
    @PostMapping("/verify-reset-code")
    public ResponseEntity<?> verifyResetCode(@RequestBody VerifyCodeRequest request) {
        boolean valid = usuarioService.verifyResetCode(request.getEmail(), request.getCode());
        if (valid) {
            return ResponseEntity.ok(Collections.singletonMap("message", "Código válido"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Código inválido o expirado");
        }
    }

    
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        try {
            boolean valid = usuarioService.resetPassword(request.getEmail(), request.getCode(), request.getNewPassword());
            if (valid) {
                return ResponseEntity.ok(Collections.singletonMap("message", "Contraseña actualizada correctamente"));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error al actualizar la contraseña: Código inválido o expirado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar la contraseña: " + e.getMessage());
        }
    }
    
    
    
    
}
