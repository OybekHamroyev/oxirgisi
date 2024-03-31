package com.example.jpabackend.repository;


import com.example.jpabackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User, Integer> {

}

