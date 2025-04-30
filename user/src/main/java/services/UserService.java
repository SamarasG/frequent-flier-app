package services;

import models.User;
import repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.listAll();
    }

    public Optional<User> getUserById(UUID id) {
        return Optional.ofNullable(userRepository.findById(id));
    }

    public User createUser(User user) {
        userRepository.persist(user);
        return user;
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}