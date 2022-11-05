package com.lab.lab.service;

import com.lab.lab.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    List<UserDto> findAllByPostsGreaterThanOne();

    UserDto findById(long id);

    void save(UserDto userDto);

    void deleteById(long id);

}
