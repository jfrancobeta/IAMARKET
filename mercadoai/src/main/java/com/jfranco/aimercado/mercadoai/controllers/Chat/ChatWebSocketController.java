package com.jfranco.aimercado.mercadoai.controllers.Chat;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;

import com.jfranco.aimercado.mercadoai.dto.Chat.SendMessageRequest;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.service.Chat.ChatService;

@Controller
public class ChatWebSocketController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UsuarioRepository usuarioRepository;

   @MessageMapping("/chat.send")
    public void sendMessage(SendMessageRequest request, SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("=== CONTROLLER ===");
        
        // Get user from header accessor
        Object userObj = headerAccessor.getUser();
        System.out.println("User from headerAccessor: " + userObj);
        
        if (userObj == null) {
            throw new RuntimeException("Usuario no autenticado");
        }
        
        String username = ((UsernamePasswordAuthenticationToken) userObj).getName();
        System.out.println("Username: " + username);
        
        Usuario sender = usuarioRepository.findByUsername(username)
                .orElseThrow();
        chatService.sendMessage(request.getChatRoomId(), sender.getId(), request.getContent());
    }
}
