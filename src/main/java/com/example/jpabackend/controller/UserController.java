package com.example.jpabackend.controller;

import com.example.jpabackend.entity.Gender;
import com.example.jpabackend.entity.Role;
import com.example.jpabackend.entity.User;
import com.example.jpabackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @PostMapping
    public ResponseEntity<?> saveUser(){
        User user = new User("ali","12","ali","123", Gender.MALE,
                List.of(new Role(1,"ROLE_ADMIN")));
        userRepo.save(user);
        return ResponseEntity.ok("saved");
    }
}

