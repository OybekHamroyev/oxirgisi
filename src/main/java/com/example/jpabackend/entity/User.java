package com.example.jpabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String imgUrl;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany
    private List<Role> roles;

    public User(Integer id) {
        this.id = id;
    }

    public User(String firstName, String imgUrl, String email, String password, Gender gender, List<Role> roles) {
        this.firstName = firstName;
        this.imgUrl = imgUrl;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.roles = roles;
    }
}
