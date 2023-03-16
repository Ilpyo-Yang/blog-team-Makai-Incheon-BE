package com.bms.blog.service;

import com.bms.blog.entity.User;
import com.bms.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public List<User> getUser(){
        return userRepository.findAll();
    }

}
