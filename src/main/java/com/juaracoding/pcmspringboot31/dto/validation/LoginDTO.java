package com.juaracoding.pcmspringboot31.dto.validation;

import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class LoginDTO {

    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @NotEmpty(message = ConstantMessage.NOT_EMPTY)
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Username must be a valid email address")
    private String username;
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @NotEmpty(message = ConstantMessage.NOT_EMPTY)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@_#\\-$])[\\w].{8,15}$",
            message = "Format minimal 1 angka, 1 huruf kecil, 1 huruf besar, 1 spesial karakter (_ \"Underscore\", - \"Hyphen\", # \"Hash\", atau $ \"Dollar\" atau @ \"At\") setelah 4 kondisi min 9 max 16 alfanumerik, contoh : aB4$12345")
    private String password;
}