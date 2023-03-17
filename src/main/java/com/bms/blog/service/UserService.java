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
    public List<User> getUser(){ return userRepository.getUser(); }

    @Transactional
    public User getUser(Long uuid){ return userRepository.findById(uuid).get(); }

    @Transactional
    public User setUser(UserDto dto) { return userRepository.save(modelMapper.map(dto, User.class)); }

    @Transactional
    public User deleteUser(Long uuid) {
        User user = userRepository.findById(uuid).get();
        user.setDeletedDate(LocalDateTime.now());
        return userRepository.save(user);
    }
}
