package com.lab.lab.service;

import com.lab.lab.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    PostDto findById(long id);

    List<PostDto> findAllByAuthor(String author);

    void deleteById(long id);

}
