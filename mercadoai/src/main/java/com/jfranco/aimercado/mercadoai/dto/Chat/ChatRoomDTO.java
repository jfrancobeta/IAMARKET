package com.jfranco.aimercado.mercadoai.dto.Chat;

import java.util.List;

public class ChatRoomDTO {
    private Long id;
    private String name;
    private List<Long> participantIds;
    private String createdAt;
    private ChatMessageDTO lastMessage;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Long> getParticipantIds() {
        return participantIds;
    }
    public void setParticipantIds(List<Long> participantIds) {
        this.participantIds = participantIds;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public ChatMessageDTO getLastMessage() {
        return lastMessage;
    }
    public void setLastMessage(ChatMessageDTO lastMessage) {
        this.lastMessage = lastMessage;
    }  
}