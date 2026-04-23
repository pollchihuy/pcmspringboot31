package com.juaracoding.pcmspringboot31.dto.validation;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginDTO {

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Username must be a valid email address")
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be at least 8 characters long and contain both letters and numbers")
    private String password;
}