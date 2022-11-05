package com.lab.lab.service.impl;

import com.lab.lab.dto.PostDto;
import com.lab.lab.entity.Post;
import com.lab.lab.repository.PostRepo;
import com.lab.lab.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDto> findAll() {
        List<PostDto> posts = new ArrayList<>();
        postRepo.findAll()
                .forEach(post -> posts.add(modelMapper.map(post, PostDto.class)));

        return posts;
    }

    @Override
    public List<PostDto> findAllByTitle(String title) {
        return postRepo.findAllByTitle(title).stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findAllByAuthor(String author) {
        return postRepo.findAllByAuthor(author).stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

}
