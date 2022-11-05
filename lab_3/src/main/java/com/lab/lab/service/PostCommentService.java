package com.lab.lab.service;

import com.lab.lab.dto.CommentDto;

import java.util.List;

public interface PostCommentService {

    List<CommentDto> findCommentsByPostId(long postId);

    void saveCommentWithPostId(CommentDto comment, long postId);

}
