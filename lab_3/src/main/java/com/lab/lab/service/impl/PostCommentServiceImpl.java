package com.lab.lab.service.impl;

import com.lab.lab.dto.CommentDto;
import com.lab.lab.entity.Comment;
import com.lab.lab.entity.Post;
import com.lab.lab.repository.CommentRepo;
import com.lab.lab.repository.PostRepo;
import com.lab.lab.service.PostCommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostCommentServiceImpl implements PostCommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CommentDto> findCommentsByPostId(long postId) {
        Post post = postRepo.findById(postId).orElse(null);

        if (post == null) {
            return new ArrayList<>();
        } else {
            return post.getComments()
                    .stream()
                    .map(comment -> mapper.map(comment, CommentDto.class))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void saveCommentWithPostId(CommentDto comment, long postId) {
        Post post = postRepo.findById(postId).orElse(null);

        if (post != null) {
            post.addComment(mapper.map(comment, Comment.class));
        }
    }

}
