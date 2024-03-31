package com.example.jpabackend.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface PostProjection {

    Integer getId();
    String getContent();
    LocalDateTime getCreatedAt();
    String  getUserName();
    String  getUserImg();
    String getPostImg();
    @Value("#{@likeRepo.countAllByPostId(target.id)}")
    Integer getCountAllLikes();
    @Value("#{@likeRepo.isActive(target.myId, target.id)}")
    Boolean getActive();
    @Value("#{@commentRepo.findAllByPostId(target.id)}")
    List<CommentProjection> getCommentList();
}
