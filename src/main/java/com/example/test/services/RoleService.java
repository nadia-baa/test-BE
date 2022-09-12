package com.example.test.services;

import com.example.test.models.Role;
import com.example.test.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    public RoleRepository roleRepository;

    public Role getRoleById(long id){
        return this.roleRepository.getById(id);
    }

    public Role saveRole(Role role){
        return this.roleRepository.save(role);
    }

    public void deleteRoleById(long id){
        this.roleRepository.deleteById(id);
    }
}
