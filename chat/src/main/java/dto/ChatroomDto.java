package dto;

import model.Chatroom;

import java.util.UUID;

public class ChatroomDto {
    private UUID id;
    private String status;

    public ChatroomDto(Chatroom chatroom) {
        this.id = chatroom.getId();
        this.status = chatroom.getStatus();
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}