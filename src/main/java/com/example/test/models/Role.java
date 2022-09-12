package com.example.test.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="role_id")
    private long role_id;

    @Column(name="role_name")
    private String roleName;


}