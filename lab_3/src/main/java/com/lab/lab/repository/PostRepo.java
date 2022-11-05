package com.lab.lab.repository;

import com.lab.lab.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post,Long> {

    List<Post> findAllByAuthor(String author);

    List<Post> findAllByTitle(String title);

}
