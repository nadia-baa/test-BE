package com.example.test.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;

    @Column(name="full_name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="company")
    private String company;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE}
    )
    @JoinColumn(name="user_id_fk")
    private List<Role> roles;

}
