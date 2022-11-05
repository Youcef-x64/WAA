package com.lab.lab.controller;

import com.lab.lab.dto.UserDto;
import com.lab.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAll(@RequestParam(name = "post_number", required = false) Integer postNumber) {
        if (postNumber == null)
            return userService.findAll();
        else
            return userService.findAllByPostsGreaterThan(postNumber);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.deleteById(id);
    }

}
