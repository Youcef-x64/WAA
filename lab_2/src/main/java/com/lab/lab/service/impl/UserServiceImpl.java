package com.lab.lab.service.impl;

import com.lab.lab.dto.UserDto;
import com.lab.lab.entity.User_;
import com.lab.lab.repository.UserRepo;
import com.lab.lab.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> users = new ArrayList<>();
        userRepo.findAll()
                .forEach(user -> users.add(mapper.map(user, UserDto.class)));

        return users;
    }

    @Override
    public List<UserDto> findAllByPostsGreaterThanOne() {
        return userRepo.findUsersByPostsGreaterThan().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(long id) {
        return mapper.map(userRepo.findById(id), UserDto.class);
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(mapper.map(userDto, User_.class));
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }
}
