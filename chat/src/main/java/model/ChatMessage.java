package model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
public class ChatMessage {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID chatroomId;
    private UUID senderId;
    private String messageContent;

    @Column(updatable = false)
    private Instant sentAt;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(UUID chatroomId) {
        this.chatroomId = chatroomId;
    }

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

    public Instant getSentAt() {
        return sentAt;
    }

    public void setSentAt(Instant sentAt) {
        this.sentAt = sentAt;
    }
}