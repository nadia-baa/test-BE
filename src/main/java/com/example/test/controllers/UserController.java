package com.example.test.controllers;

import com.example.test.models.User;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return this.userService.getUserById(id);
    }

    @PostMapping("/user/add")
    public User saveUser(@RequestBody User user){
       return this.userService.addUser(user);
    }

    @PostMapping("/user")
    public User login(@RequestBody User user){
        User myUser = this.userService.login(user.getEmail(), user.getPassword());
        if(myUser != null){
            return myUser;
        }
        else{
            return null;
        }
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable long id){
        this.userService.deleteUser(id);
    }
}
