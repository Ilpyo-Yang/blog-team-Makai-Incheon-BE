package com.bms.blog.controller;

import com.bms.blog.dto.UserDto;
import com.bms.blog.entity.User;
import com.bms.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
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

    @PostMapping("/{uuid}")
    public void setUser(@PathVariable(value = "uuid", required = false) Long uuid, @RequestParam("user") UserDto dto){
        userService.setUser(dto);
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestParam(value = "uuid") Long uuid){
        userService.deleteUser(uuid);
    }
}
