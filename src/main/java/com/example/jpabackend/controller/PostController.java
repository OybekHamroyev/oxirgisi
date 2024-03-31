package com.example.jpabackend.controller;

import com.example.jpabackend.entity.Post;
import com.example.jpabackend.entity.User;
import com.example.jpabackend.projection.PostProjection;
import com.example.jpabackend.repository.PostRepo;
import com.example.jpabackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostRepo postRepo;
    @Autowired
    UserRepo userRepo;
    @PostMapping
    public ResponseEntity<?> savePost(@RequestBody Post post){
        User user = userRepo.findById(1).orElseThrow();
        Post salomPost = postRepo.save(new Post(post.getContent(),post.getImg(),user));
        return ResponseEntity.ok(salomPost);
    }
    @GetMapping
    public ResponseEntity<?> getPosts(@RequestParam Integer myId){
        //ctrl+shift+t ni bosamiz
        List<PostProjection> myPosts = postRepo.getMyPosts(myId);
        return ResponseEntity.ok(myPosts);
    }
}

