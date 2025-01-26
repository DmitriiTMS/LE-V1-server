package com.example.le_v1_server.controller;


import com.example.le_v1_server.dto.RegisterRequestDTO;
import com.example.le_v1_server.dto.UserResponseDTO;
import com.example.le_v1_server.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
