package edu.miu.lab_1.repo;

import edu.miu.lab_1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo {

    List<Post> findAll();

    Post findById(int id);

    Post findByAuthor(String author);

    void save(Post post);

    void delete(int id);

}
