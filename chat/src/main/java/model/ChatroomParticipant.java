package model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
public class ChatroomParticipant {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID chatroomId;
    private UUID userId;

    @Column(updatable = false)
    private Instant joinedAt;

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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Instant joinedAt) {
        this.joinedAt = joinedAt;
    }
}