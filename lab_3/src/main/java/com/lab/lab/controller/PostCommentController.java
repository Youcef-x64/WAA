package com.lab.lab.controller;

import com.lab.lab.dto.CommentDto;
import com.lab.lab.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostCommentController {

    @Autowired
    private PostCommentService postCommentService;

    @GetMapping("/{id}/comments")
    public List<CommentDto> getAllPostComments(@PathVariable long id) {
        return postCommentService.findCommentsByPostId(id);
    }

    @PostMapping("/{id}/comments")
    public void savePostComment(@RequestBody CommentDto comment, @PathVariable long id) {

        postCommentService.saveCommentWithPostId(comment, id);
    }

}
