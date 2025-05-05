package dto;

import model.ChatMessage;

import java.util.UUID;

public class ChatMessageDto {
    private UUID senderId;
    private String messageContent;

    public ChatMessageDto(ChatMessage message) {
        this.senderId = message.getSenderId();
        this.messageContent = message.getMessageContent();
    }

    // Getters and Setters
    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}