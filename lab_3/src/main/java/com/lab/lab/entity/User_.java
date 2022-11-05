package com.lab.lab.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    List<Post> posts;

    public void addPost(Post post){
        posts.add(post);
    }
}
