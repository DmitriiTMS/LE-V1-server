package com.example.le_v1_server.dto;


import com.example.le_v1_server.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    @NotBlank(message = "Имя обязательно к заполнению")
    @Size(max = 50, message = "Имя не должно превышать 50 символов")
    private String name;

    @NotBlank(message = "Email обязателен к заполнению")
    @Email(message = "Некорректный формат email")
    private String email;

    @NotBlank(message = "Пароль обязателен к заполнению")
    @Size(min = 6, message = "Пароль не может быть меньше 6 символов")
    private String password;

    @NotBlank(message = "Имя аккаунта Instagram обязательно к заполнению")
    private String instagramName;

    @NotNull(message = "Статус участника обязателен к заполнению")
    private UserRole role;
}
