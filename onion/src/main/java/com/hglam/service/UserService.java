package com.hglam.service;

import com.hglam.domain.User;
import com.hglam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    //contrustor of userRepository
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    //method of fetching all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //method of getting user by its id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    //method of creating User
    public User createUser(User user) {
        return userRepository.save(user);
    }
    //method of updating user info
    public User updateUser(Long id, User user) {
        //find the user by id
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            //updating the info of the user with the new info
            User existingUser = existingUserOptional.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            //save the user's info into db
            return userRepository.save(existingUser);
        }
        return null; // send null if not exist user
    }
    //method of deleting user by id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
