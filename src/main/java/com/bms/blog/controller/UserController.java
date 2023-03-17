package com.bms.blog.controller;

import com.bms.blog.dto.UserDto;
import com.bms.blog.entity.User;
import com.bms.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<UserDto> getUser(){
       List<User> list = userService.getUser();
       List<UserDto> dto = new ArrayList<>();
       list.forEach(i -> dto.add(modelMapper.map(i, UserDto.class)));
       return dto;
    }

    @GetMapping("/{uuid}")
    public UserDto getUser(@PathVariable("uuid") String uuid){
        return modelMapper.map(userService.getUser(uuid), UserDto.class);
    }

    @PostMapping
    public UserDto setUser(@RequestPart("user") UserDto dto){
        return modelMapper.map(userService.setUser(dto), UserDto.class);
    }

    @PostMapping("/delete/{uuid}")
    public UserDto deleteUser(@PathVariable("uuid") String uuid){
        return modelMapper.map(userService.deleteUser(uuid), UserDto.class);
    }
}
