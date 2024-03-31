package com.example.jpabackend.controller;

import com.example.jpabackend.entity.Like;
import com.example.jpabackend.entity.Post;
import com.example.jpabackend.entity.User;
import com.example.jpabackend.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/like")
public class LikeController {
    @Autowired
    LikeRepo likeRepo;
    @PatchMapping
    public ResponseEntity<?> updateLike(@RequestParam Integer userId, @RequestParam Integer postId ){
        Like foundLike = likeRepo.findByUserIdAndPostId(userId, postId);
        if (foundLike!=null){
            likeRepo.deleteMyLike(userId,postId);
        }else {
            likeRepo.save(new Like("ok",new Post(postId),new User(userId)));
        }

        return ResponseEntity.ok("successful");
    }
}

