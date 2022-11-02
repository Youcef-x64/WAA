package edu.miu.lab_1.controller;

import edu.miu.lab_1.domain.Post;
import edu.miu.lab_1.domain.dto.PostDto;
import edu.miu.lab_1.service.PostService;
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
            return postService.findByAuthor(author);
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable("id") int id) {
        return postService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PostDto postDto) {
        postService.save(postDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        postService.delete(id);
    }

}
