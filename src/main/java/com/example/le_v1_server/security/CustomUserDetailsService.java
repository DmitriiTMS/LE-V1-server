package com.example.le_v1_server.security;

import com.example.le_v1_server.entity.User;
import com.example.le_v1_server.exceptions.NotFoundException;
import com.example.le_v1_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundException("Пользователь по email не найден"));

        return AuthUser.builder()
                .user(user)
                .build();
    }
}
