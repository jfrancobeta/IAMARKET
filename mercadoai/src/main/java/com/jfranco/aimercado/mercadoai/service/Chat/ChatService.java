package com.jfranco.aimercado.mercadoai.service.Chat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.jfranco.aimercado.mercadoai.dto.Chat.ChatMessageDTO;
import com.jfranco.aimercado.mercadoai.dto.Chat.ChatRoomDTO;
import com.jfranco.aimercado.mercadoai.exception.ResourceNotFoundException;
import com.jfranco.aimercado.mercadoai.mapper.Chat.ChatMapper;
import com.jfranco.aimercado.mercadoai.model.Usuario;
import com.jfranco.aimercado.mercadoai.model.Chat.ChatMessage;
import com.jfranco.aimercado.mercadoai.model.Chat.ChatRoom;
import com.jfranco.aimercado.mercadoai.repository.Chat.ChatMessageRepository;
import com.jfranco.aimercado.mercadoai.repository.Chat.ChatRoomRepository;
import com.jfranco.aimercado.mercadoai.repository.Usuario.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ChatService implements IChatService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Transactional
    public ChatRoomDTO createOrGetPrivateChat(Long user1Id, Long user2Id) {
        if (user1Id.equals(user2Id)) {
                throw new IllegalArgumentException("no se puede crear un chat privado consigo mismo");
         }
        return chatRoomRepository.findPrivateChatBetween(user1Id, user2Id)
                .map(chatMapper::toRoomDTO)
                .orElseGet(() -> {
                    Usuario user1 = usuarioRepository.findById(user1Id)
                            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", user1Id));
                    Usuario user2 = usuarioRepository.findById(user2Id)
                            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", user2Id));

                    ChatRoom chatRoom = new ChatRoom();
                    chatRoom.setName("Private Chat");
                    Set<Usuario> participants = new HashSet<>();
                    participants.add(user1);
                    participants.add(user2);
                    chatRoom.setParticipants(participants);

                    chatRoomRepository.save(chatRoom);
                    return chatMapper.toRoomDTO(chatRoom);
                });
    }

    public List<ChatRoomDTO> getUserChatRooms(Long userId) {
        return chatRoomRepository.findByParticipantId(userId).stream()
                .map(chatMapper::toRoomDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ChatMessageDTO sendMessage(Long chatRoomId, Long senderId, String content) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId)
                .orElseThrow(() -> new ResourceNotFoundException("ChatRoom", "id", chatRoomId));

        Usuario sender = usuarioRepository.findById(senderId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", senderId));

        ChatMessage message = new ChatMessage();
        message.setChatRoom(chatRoom);
        message.setSender(sender);
        message.setContent(content);

        chatMessageRepository.save(message);

        ChatMessageDTO dto = chatMapper.toMessageDTO(message);

        // Send via WebSocket
        messagingTemplate.convertAndSend("/topic/chat/" + chatRoomId, dto);

        return dto;
    }

    public Page<ChatMessageDTO> getChatMessages(Long chatRoomId, Pageable pageable) {
        return chatMessageRepository.findByChatRoomIdOrderBySentAtDesc(chatRoomId, pageable)
                .map(chatMapper::toMessageDTO);
    }

    public List<ChatMessageDTO> getRecentMessages(Long chatRoomId) {
        return chatMessageRepository.findTop50ByChatRoomIdOrderBySentAtDesc(chatRoomId).stream()
                .map(chatMapper::toMessageDTO)
                .collect(Collectors.toList());
    }
}
