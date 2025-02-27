package app.gestionProduction.services;

import app.gestionProduction.entity.User;
import app.gestionProduction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService implements UserServiceInter{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public List<User> getAllUsers(){
        return  userRepository.findAll();

    }



    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }




    @Override
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setNom(userDetails.getNom());
            user.setEmail(userDetails.getEmail());
            user.setMotDePasse(userDetails.getMotDePasse());
            user.setRole(userDetails.getRole());
            return userRepository.save(user); // Save updated user to DB
        }).orElse(null); // If user is not found, return null
    }



    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
