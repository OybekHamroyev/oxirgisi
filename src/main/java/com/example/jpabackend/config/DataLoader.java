package com.example.jpabackend.config;

import com.example.jpabackend.entity.Gender;
import com.example.jpabackend.entity.Role;
import com.example.jpabackend.entity.User;
import com.example.jpabackend.repository.RoleRepo;
import com.example.jpabackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Override
    public void run(String... args) throws Exception {
        List<Role> all = roleRepo.findAll();
        if (all.isEmpty()){
            List<Role> roles = roleRepo.saveAll(List.of(new Role("ROLE_ADMIN"),new Role("ROLE_USER")));
            User user = new User("user","img","123", "admin",Gender.MALE,roles);
            userRepo.save(user);
        }
    }
}
