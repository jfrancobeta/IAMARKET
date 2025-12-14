package com.jfranco.aimercado.mercadoai.mapper.Chat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jfranco.aimercado.mercadoai.dto.Chat.ChatMessageDTO;
import com.jfranco.aimercado.mercadoai.dto.Chat.ChatRoomDTO;
import com.jfranco.aimercado.mercadoai.model.Chat.ChatMessage;
import com.jfranco.aimercado.mercadoai.model.Chat.ChatRoom;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    @Mapping(target = "senderId", source = "sender.id")
    @Mapping(target = "senderName", source = "sender.username")
    @Mapping(target = "chatRoomId", source = "chatRoom.id")
    public ChatMessageDTO toMessageDTO(ChatMessage chatMessage);

    public ChatRoomDTO toRoomDTO(ChatRoom chatRoom);
    
}
