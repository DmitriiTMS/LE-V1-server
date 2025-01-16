package com.example.le_v1_server.service.impl;

import com.example.le_v1_server.dto.LoginRequestDTO;
import com.example.le_v1_server.dto.RegisterRequestDTO;
import com.example.le_v1_server.dto.UserResponseDTO;
import com.example.le_v1_server.entity.User;
import com.example.le_v1_server.exceptions.InvalidCredentialsException;
import com.example.le_v1_server.exceptions.NotFoundException;
import com.example.le_v1_server.exceptions.UserAlreadyExistsException;
import com.example.le_v1_server.repository.UserRepository;
import com.example.le_v1_server.security.JwtUtils;
import com.example.le_v1_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

//    private final UserMapper userMapper;

    @Override
    public UserResponseDTO registerUser(RegisterRequestDTO registerRequestDTO) {
        if (userRepository.findByEmail(registerRequestDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Пользователь с email " + registerRequestDTO.getEmail()
                    + " уже зарегистрирован");
        }

        String token = jwtUtils.generateToken(registerRequestDTO.getEmail(), registerRequestDTO.getRole().name());

        User userToSave = User.builder()
                .name(registerRequestDTO.getName())
                .email(registerRequestDTO.getEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .instagramName(registerRequestDTO.getInstagramName())
                .role(registerRequestDTO.getRole())
                .build();

        userRepository.save(userToSave);

        return UserResponseDTO.builder()
                .status(200)
                .role(registerRequestDTO.getRole())
                .token(token)
                .message("Пользователь успешно зарегистрирован")
                .build();
    }

    @Override
    public UserResponseDTO loginUser(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new NotFoundException("Пользователь с email "
                            + loginRequestDTO.getEmail() + " не найден"));

        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Пароли не совпадают");
        }
        String token = jwtUtils.generateToken(user.getEmail(), user.getRole().name());

        return UserResponseDTO.builder()
                .status(200)
                .message("Пользователь вошёл в систему")
                .role(user.getRole())
                .token(token)
                .build();
    }
}
