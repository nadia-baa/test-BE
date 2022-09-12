package com.example.test.controllers;

import com.example.test.models.Role;
import com.example.test.services.RoleService;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/roles")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostMapping("/role/{userId}")
    public Role saveRole(@RequestBody Role role, @PathVariable long userId){
        this.userService.getUserById(userId).get().getRoles().add(role);
        return this.roleService.saveRole(role);
    }

    @DeleteMapping("/role/delete/{id}")
    public void deleteRoleById(@PathVariable long id){
        this.roleService.deleteRoleById(id);
    }
}
