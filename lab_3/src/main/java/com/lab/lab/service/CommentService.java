package com.lab.lab.service;

import com.lab.lab.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();

    CommentDto findById(long id);

    void deleteById(long id);

}
