package com.bms.blog.service;

import com.bms.blog.dto.TokenDto;
import com.bms.blog.entity.User;
import com.bms.blog.repository.UserRepository;
import com.bms.blog.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    public String loginCheck(String nickname, String password) {
        return userRepository.findByNicknameAndPassword(nickname, password).getUuid();
    }

    public TokenDto login(String uuid, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(uuid, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenInfo = tokenProvider.generateToken(authentication);
        return tokenInfo;
    }

    public List<User> getUser(){ return userRepository.getUser(); }

    public User getUser(String uuid){ return userRepository.findById(uuid).get(); }

    public User setUser(String uuid, String nickname, String password) {
        User user;
        if(uuid==null){ user = new User(); }
        else{ user = userRepository.findById(uuid).get(); }
        user.setNickname(nickname);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User deleteUser(String uuid) {
        User user = userRepository.findById(uuid).get();
        user.setDeleteDate(LocalDateTime.now());
        return userRepository.save(user);
    }

}
