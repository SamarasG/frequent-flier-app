package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import models.User;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public User findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void deleteById(UUID id) {
        delete("id", id);
    }
}