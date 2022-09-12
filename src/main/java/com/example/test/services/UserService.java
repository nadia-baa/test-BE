package com.example.test.services;

import com.example.test.models.User;
import com.example.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(long id){
        return this.userRepository.findById(id);

    }

    public User addUser(User user){
        return this.userRepository.save(user);
    }

    public User login(String email, String password){
        return this.userRepository.login(email,password).iterator().next();
    }

    public User updateUser(User user){
       return this.userRepository.save(user);
    }

    public void deleteUser(long id){
         this.userRepository.deleteById(id);
    }

}
