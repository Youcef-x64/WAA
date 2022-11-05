package com.lab.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_post")
    private List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

}
