package edu.miu.lab_1.repo.impl;

import edu.miu.lab_1.domain.Post;
import edu.miu.lab_1.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts;
    private static int postId = 1;

    static {
        posts = new ArrayList<>();

        posts.add(new Post(postId++, "Title 1", "Content 1", "John Doe"));
        posts.add(new Post(postId++, "Title 2", "Content 2", "John Doe 2"));
    }


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public Post findByAuthor(String author) {
        return posts.stream()
                .filter(post -> post.getAuthor().equals(author))
                .findFirst()
                .get();
    }

    @Override
    public void save(Post post) {
        post.setId(postId++);
        posts.add(post);
    }

    @Override
    public void delete(int id) {
        var post = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();

        posts.remove(post);
    }
}