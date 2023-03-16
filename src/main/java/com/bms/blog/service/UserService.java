package com.bms.blog.service;

import com.bms.blog.dto.UserDto;
import com.bms.blog.entity.User;
import com.bms.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public List<User> getUser(){ return userRepository.findAll(); }

    @Transactional
    public void setUser(UserDto dto) { userRepository.save(modelMapper.map(dto, User.class)); }

    @Transactional
    public void deleteUser(Long uuid) { userRepository.delete(userRepository.findById(uuid).get()); }
}
