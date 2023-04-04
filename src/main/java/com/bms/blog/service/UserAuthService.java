package com.bms.blog.service;

import com.bms.blog.entity.UserAuth;
import com.bms.blog.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthRepository.findById(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(UserAuth userAuth) {
        return User.builder()
                .username(userAuth.getUsername())
                .password(passwordEncoder.encode(userAuth.getPassword()))
                .roles(userAuth.getRoles().toArray(new String[0]))
                .build();
    }
}
