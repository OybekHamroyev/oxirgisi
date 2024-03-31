package com.example.jpabackend.repository;


import com.example.jpabackend.entity.Post;
import com.example.jpabackend.projection.PostProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    @Query(value = "select p.id as id,p.img as postImg,p.content as content, p.createdAt as createdAt," +
            " p.user.firstName as userName, " +
            "p.user.imgUrl as userImg, :myId as myId from posts p")
    List<PostProjection> getMyPosts(Integer myId);
}

