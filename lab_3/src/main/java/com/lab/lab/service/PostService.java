package com.lab.lab.service;

import com.lab.lab.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    List<PostDto> findAllByTitle(String title);

    List<PostDto> findAllByAuthor(String author);

    PostDto findById(long id);

    void deleteById(long id);

}
