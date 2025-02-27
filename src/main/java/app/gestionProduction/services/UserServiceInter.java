package app.gestionProduction.services;

import app.gestionProduction.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInter {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);


}
