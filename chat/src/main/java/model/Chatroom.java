package model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
public class Chatroom {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID flightLogId;
    private String status;

    @Column(updatable = false)
    private Instant createdAt;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getFlightLogId() {
        return flightLogId;
    }

    public void setFlightLogId(UUID flightLogId) {
        this.flightLogId = flightLogId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}