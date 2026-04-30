package com.juaracoding.pcmspringboot31.dto.validation;

import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginDTO {

    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @NotEmpty(message = ConstantMessage.NOT_EMPTY)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Username must be a valid email address")
    private String username;
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @NotEmpty(message = ConstantMessage.NOT_EMPTY)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be at least 8 characters long and contain both letters and numbers")
    private String password;
}