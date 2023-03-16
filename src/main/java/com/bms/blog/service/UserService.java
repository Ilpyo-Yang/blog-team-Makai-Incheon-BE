package com.bms.blog.service;

import com.bms.blog.dto.UserDto;
import com.bms.blog.entity.Review;
import com.bms.blog.entity.User;
import com.bms.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public void deleteUser(Long uuid) {
        User user = userRepository.findById(uuid).get();
        user.setDeletedDate(LocalDateTime.now());
        userRepository.save(user);
    }
}
