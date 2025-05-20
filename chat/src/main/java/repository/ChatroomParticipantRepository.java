package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.ChatroomParticipant;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ChatroomParticipantRepository implements PanacheRepository<ChatroomParticipant> {
    public Optional<ChatroomParticipant> findByChatroomIdAndUserId(UUID chatroomId, UUID userId) {
        return find("chatroomId = ?1 and userId = ?2", chatroomId, userId).firstResultOptional();
    }
}