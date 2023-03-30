package com.bms.blog.controller;

import com.bms.blog.dto.ResponseDto;
import com.bms.blog.dto.UserDto;
import com.bms.blog.entity.User;
import com.bms.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
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

    // 논의 필요
    @PostMapping("/{login}")
    public ResponseEntity<ResponseDto> login(@RequestParam("nickname") String nickname, @RequestParam("password") String password, HttpSession session){
        if(nickname.isEmpty() || password.isEmpty()){
            return ResponseEntity.badRequest().body(new ResponseDto(false, "로그인 정보가 입력되지 않았습니다."));
        }
        if(session.getAttribute("nickname")==null){ // token 처리 예정? 아니면 걍 세션 nickname?
            if(userService.login(nickname, password)!=null){
                session.setAttribute("nickname", nickname);
                // todo token or userInfo?
                return ResponseEntity.ok(new ResponseDto(true, modelMapper.map(userService.login(nickname, password), UserDto.class)));
            }
            else{
                session.removeAttribute("nickname");
                return ResponseEntity.badRequest().body(new ResponseDto(false, "사용자 정보가 없습니다."));
            }
        }
        else{
            return ResponseEntity.badRequest().body(new ResponseDto(false, "이미 로그인한 사용자입니다."));
        }
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
