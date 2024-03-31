package com.example.jpabackend.projection;

import com.example.jpabackend.entity.Comment;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentProjection {
    Integer getId();
    String getContent();
}
