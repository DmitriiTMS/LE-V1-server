package com.example.le_v1_server.dto;


import com.example.le_v1_server.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDTO {

    private int status;
    private String message;
    private Map<String, String> errors;

    private Long id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;

    private String phoneNumber;
    private UserRole role;
    private String token;

}
