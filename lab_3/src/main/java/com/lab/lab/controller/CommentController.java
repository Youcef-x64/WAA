package com.lab.lab.controller;

import com.lab.lab.dto.CommentDto;
import com.lab.lab.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDto> getComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDto getComment(@PathVariable long id) {
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.deleteById(id);
    }

}
