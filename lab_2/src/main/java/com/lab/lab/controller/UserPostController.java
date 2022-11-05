package com.lab.lab.controller;

import com.lab.lab.dto.PostDto;
import com.lab.lab.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserPostController {

    @Autowired
    private UserPostService userPostService;

    @GetMapping("/users/{id}/posts")
    public List<PostDto> getAllPosts(@PathVariable("id") int id) {
        return userPostService.findPostsByUserId(id);
    }

    @PostMapping("/users/{userId}/posts")
    public void savePost(@RequestBody PostDto postDto, @PathVariable long userId){
        userPostService.savePostByUserId(postDto, userId);
    }
}
