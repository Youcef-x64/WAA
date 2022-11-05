package com.lab.lab.service.impl;

import com.lab.lab.dto.CommentDto;
import com.lab.lab.repository.CommentRepo;
import com.lab.lab.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CommentDto> findAll() {
        List<CommentDto> comments = new ArrayList<>();

        commentRepo.findAll()
                .forEach(comment -> comments.add(mapper.map(comment, CommentDto.class)));

        return comments;
    }

    @Override
    public CommentDto findById(long id) {
        return mapper.map(commentRepo.findById(id), CommentDto.class);
    }

    @Override
    public void deleteById(long id) {
        commentRepo.deleteById(id);
    }

}
