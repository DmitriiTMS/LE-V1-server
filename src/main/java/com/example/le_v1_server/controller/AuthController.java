package com.example.le_v1_server.controller;

import com.example.le_v1_server.dto.LoginRequestDTO;
import com.example.le_v1_server.dto.RegisterRequestDTO;
import com.example.le_v1_server.dto.UserResponseDTO;
import com.example.le_v1_server.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(userService.registerUser(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(userService.loginUser(loginRequestDTO));
    }

}