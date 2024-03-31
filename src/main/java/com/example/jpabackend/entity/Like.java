package com.example.jpabackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

    public Like(String content, Post post, User user) {
        this.content = content;
        this.post = post;
        this.user = user;
    }
}
