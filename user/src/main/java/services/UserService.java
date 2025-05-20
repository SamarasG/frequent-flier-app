package services;

import at.favre.lib.crypto.bcrypt.BCrypt;
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
    public User registerUser(User user) {
        // Check if the email already exists
        if (userRepository.find("email", user.getEmail()).firstResult() != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Hash the password
        String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPasswordHash().toCharArray());
        user.setPasswordHash(hashedPassword);

        // Save the user
        userRepository.persist(user);
        return user;
    }

    public boolean authenticateUser(String email, String password) {
        // Retrieve the user by email
        User user = userRepository.find("email", email).firstResult();

        // Check if user exists and validate the password
        if (user != null) {
            return BCrypt.verifyer().verify(password.toCharArray(), user.getPasswordHash()).verified;
        }
        return false;
    }
}