package com.bms.blog.controller;

import com.bms.blog.dto.UserDto;
import com.bms.blog.entity.User;
import com.bms.blog.exception.BadRequestException;
import com.bms.blog.service.UserService;
import com.bms.blog.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenProvider tokenProvider;
    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/login")
    public String login(@RequestParam("nickname") String nickname, @RequestParam("password") String password) {
        return userService.login(userService.findByNickname(nickname).getUuid(), password);
    }

    @GetMapping("/loginCheck")
    public String login(@AuthenticationPrincipal UserDetails user) {
        return user.getUsername();
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
                                           @RequestParam("password") String password,
                                           @RequestParam(value = "role", required = false) String role,
                                           @AuthenticationPrincipal UserDetails user){
        if(uuid!=null && !user.getUsername().equals(uuid)){
            throw new BadRequestException("본인 계정이 아닌 경우, 사용자 수정");
        }else{
            return ResponseEntity.ok(modelMapper.map(userService.setUser(uuid, nickname, password, role), UserDto.class));
        }

    }

    @PostMapping("/delete/{uuid}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(modelMapper.map(userService.deleteUser(uuid), UserDto.class));
    }
}
