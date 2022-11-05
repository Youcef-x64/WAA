package com.lab.lab.controller;


import com.lab.lab.dto.PostDto;
import com.lab.lab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> getPosts(@RequestParam(name = "author", required = false) String author) {
        if (author == null)
            return postService.findAll();
        else
            return postService.findAllByAuthor(author);
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable("id") int id) {
        return postService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        postService.deleteById(id);
    }

}
