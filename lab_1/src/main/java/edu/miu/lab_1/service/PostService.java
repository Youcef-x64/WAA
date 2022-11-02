package edu.miu.lab_1.service;

import edu.miu.lab_1.domain.Post;
import edu.miu.lab_1.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(int id);

    List<PostDto> findByAuthor(String author);

    void save(PostDto post);

    void delete(int id);

}
