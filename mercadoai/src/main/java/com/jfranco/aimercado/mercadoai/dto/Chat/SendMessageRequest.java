package com.jfranco.aimercado.mercadoai.dto.Chat;

public class SendMessageRequest {
    private Long chatRoomId;
    private String content;
    
    public Long getChatRoomId() {
        return chatRoomId;
    }
    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
