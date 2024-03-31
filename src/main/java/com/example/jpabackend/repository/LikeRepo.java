package com.example.jpabackend.repository;


import com.example.jpabackend.entity.Like;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepo extends JpaRepository<Like, Integer> {
    Integer countAllByPostId(@Param("postId") Integer postId);
    @Query(value = "select case when count(l.id)=1  then true else false end from likes l where l.post_id=:postId and l.user_id=:myId",nativeQuery = true)

    Boolean isActive(@Param("myId") Integer myId, Integer postId);

    Like findByUserIdAndPostId(@Param("userId") Integer userId,@Param("postId") Integer postId);
//    void deleteByPostIdAndUserId();
    @Modifying
    @Transactional
    @Query("delete likes l where l.user.id=:userId and l.post.id=:postId")
    void deleteMyLike(Integer userId, Integer postId);
}

