package edu.miu.lab_1.service.impl;

import edu.miu.lab_1.domain.Post;
import edu.miu.lab_1.domain.dto.PostDto;
import edu.miu.lab_1.repo.PostRepo;
import edu.miu.lab_1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return postRepo.findAll().stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public List<PostDto> findByAuthor(String author) {
        return postRepo.findAll().stream()
                .filter(post -> post.getAuthor().equals(author))
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

}
