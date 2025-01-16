package com.example.le_v1_server.service;

import com.example.le_v1_server.dto.LoginRequestDTO;
import com.example.le_v1_server.dto.RegisterRequestDTO;
import com.example.le_v1_server.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser(RegisterRequestDTO registerRequestDTO);

    UserResponseDTO loginUser(LoginRequestDTO loginRequestDTO);

//    Response getAllUsers();
//
//    User getCurrentLoggedInUser();
//
//    Response getUserById(Long id);
//
//    Response updateUser(Long id, UserDTO userDTO);
//
//    Response deleteUser(Long id);
//
//    Response getUserTransactions(Long id);
}
