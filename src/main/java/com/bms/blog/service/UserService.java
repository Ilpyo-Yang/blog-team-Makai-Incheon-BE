package com.bms.blog.service;

import com.bms.blog.dto.TokenDto;
import com.bms.blog.entity.User;
import com.bms.blog.repository.UserRepository;
import com.bms.blog.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(new String[]{user.getRole()})
                .build();
    }
    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    public TokenDto login(String uuid, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(uuid, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = tokenProvider.generateToken(authentication);
        return tokenDto;
    }

    public List<User> getUser(){ return userRepository.getUser(); }

    public User getUser(String uuid){ return userRepository.findById(uuid).get(); }

    public User setUser(String uuid, String nickname, String password, String role) {
        User user;

        if(uuid==null){ user = new User(); }
        else{ user = userRepository.findById(uuid).orElseThrow(); }
        user.setNickname(nickname);
        user.setPassword(password);

        if(role==null) user.setRole("ROLE_USER");
        else user.setRole(role);

        return userRepository.save(user);
    }

    public User deleteUser(String uuid) {
        User user = userRepository.findById(uuid).orElseThrow();
        user.setDeleteDate(LocalDateTime.now());
        return userRepository.save(user);
    }

}
