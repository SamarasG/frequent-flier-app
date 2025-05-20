package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.ChatMessage;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ChatMessageRepository implements PanacheRepository<ChatMessage> {
    public List<ChatMessage> findByChatroomId(UUID chatroomId) {
        return list("chatroomId", chatroomId);
    }
}