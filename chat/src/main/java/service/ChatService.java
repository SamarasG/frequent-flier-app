package service;

import jakarta.enterprise.context.ApplicationScoped;
import model.Chatroom;

import java.util.UUID;

@ApplicationScoped
public class ChatService {
    public Chatroom createChatroom(UUID flightLogId, String status) {
        Chatroom chatroom = new Chatroom();
        chatroom.setFlightLogId(flightLogId);
        chatroom.setStatus(status);
        chatroom.setCreatedAt(java.time.Instant.now());
        return chatroom;
    }
}