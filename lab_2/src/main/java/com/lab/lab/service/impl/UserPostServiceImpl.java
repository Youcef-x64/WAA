package com.lab.lab.service.impl;

import com.lab.lab.dto.PostDto;
import com.lab.lab.entity.Post;
import com.lab.lab.entity.User_;
import com.lab.lab.repository.PostRepo;
import com.lab.lab.repository.UserRepo;
import com.lab.lab.service.UserPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserPostServiceImpl implements UserPostService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void savePostByUserId(PostDto postDto, long userId) {
        User_ user = userRepo.findById(userId).orElse(null);

        if (user != null) {
            user.addPost(mapper.map(postDto, Post.class));
            userRepo.save(user);
        }
    }

    @Override
    public List<PostDto> findPostsByUserId(long userid) {
        User_ user = userRepo.findById(userid).orElse(null);

        if (user != null)
            return user.getPosts().stream()
                    .map(post -> mapper.map(post, PostDto.class))
                    .collect(Collectors.toList());
        else
            return new ArrayList<>();
    }
}
