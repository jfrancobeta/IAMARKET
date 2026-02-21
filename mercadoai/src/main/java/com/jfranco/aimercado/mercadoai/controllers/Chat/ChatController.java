package com.jfranco.aimercado.mercadoai.controllers.Chat;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfranco.aimercado.mercadoai.dto.Chat.ChatMessageDTO;
import com.jfranco.aimercado.mercadoai.dto.Chat.ChatRoomDTO;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;
import com.jfranco.aimercado.mercadoai.service.Chat.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @PostMapping("/rooms/private")
    public ResponseEntity<ChatRoomDTO> createPrivateChat(
            @RequestParam Long otherUserId,
            Principal principal) {
        Usuario currentUser = usuarioRepository.findByUsername(principal.getName())
                .orElseThrow();
        ChatRoomDTO room = chatService.createOrGetPrivateChat(currentUser.getId(), otherUserId);
        return ResponseEntity.ok(room);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/rooms")
    public ResponseEntity<List<ChatRoomDTO>> getUserChatRooms(Principal principal) {
        Usuario currentUser = usuarioRepository.findByUsername(principal.getName())
                .orElseThrow();
        List<ChatRoomDTO> rooms = chatService.getUserChatRooms(currentUser.getId());
        return ResponseEntity.ok(rooms);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/rooms/{chatRoomId}/messages")
    public ResponseEntity<Page<ChatMessageDTO>> getChatMessages(
            @PathVariable Long chatRoomId,
            Pageable pageable) {
        Page<ChatMessageDTO> messages = chatService.getChatMessages(chatRoomId, pageable);
        return ResponseEntity.ok(messages);
    }

    @PreAuthorize("hasAnyRole('ADMIN','COMPANY','DEVELOPER')")
    @GetMapping("/rooms/{chatRoomId}/recent")
    public ResponseEntity<List<ChatMessageDTO>> getRecentMessages(@PathVariable Long chatRoomId) {
        List<ChatMessageDTO> messages = chatService.getRecentMessages(chatRoomId);
        return ResponseEntity.ok(messages);
    }
}