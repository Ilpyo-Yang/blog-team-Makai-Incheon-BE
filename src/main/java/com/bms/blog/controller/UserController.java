package com.bms.blog.controller;

import com.bms.blog.dto.TokenDto;
import com.bms.blog.dto.UserDto;
import com.bms.blog.entity.User;
import com.bms.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/login")
    public TokenDto login(@RequestParam("nickname") String nickname, @RequestParam("password") String password) {
        String uuid = userService.loginCheck(nickname, password);
        return userService.login(uuid, password);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUser(){
       List<User> list = userService.getUser();
       List<UserDto> dto = new ArrayList<>();
       list.forEach(i -> dto.add(modelMapper.map(i, UserDto.class)));
       return ResponseEntity.ok(dto);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDto> getUser(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(modelMapper.map(userService.getUser(uuid), UserDto.class));
    }

    @PostMapping
    public ResponseEntity<UserDto> setUser(@RequestParam(value = "uuid", required = false) String uuid,
                           @RequestParam("nickname") String nickname,
                           @RequestParam("password") String password){
        return ResponseEntity.ok(modelMapper.map(userService.setUser(uuid, nickname, password), UserDto.class));
    }

    @PostMapping("/delete/{uuid}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(modelMapper.map(userService.deleteUser(uuid), UserDto.class));
    }
}
