package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Chatroom;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ChatroomRepository implements PanacheRepository<Chatroom> {
    public Optional<Chatroom> findByFlightLogId(UUID flightLogId) {
        return find("flightLogId", flightLogId).firstResultOptional();
    }
}