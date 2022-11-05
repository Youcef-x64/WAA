package com.lab.lab.service;

import com.lab.lab.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserPostService {
    
    void savePostByUserId(PostDto postDto,long userId);
    List<PostDto>  findPostsByUserId(long userId);
}
