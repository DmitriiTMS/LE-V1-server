package com.example.le_v1_server.mapper;


import com.example.le_v1_server.dto.UserResponseDTO;
import com.example.le_v1_server.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toUserDTO(User user);
}
