package com.example.jpabackend.repository;


import com.example.jpabackend.entity.Comment;
import com.example.jpabackend.projection.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<CommentProjection> findAllByPostId(Integer postId);
}

