package com.juaracoding.pcmspringboot31.dto.validation;


import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RegisDTO {
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z ]{4,75}$", message = "Nama lengkap hanya boleh mengandung huruf dan spasi")
    private String namaLengkap;
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    private String email;

    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z ]{8,16}$", message = "Nama lengkap hanya boleh mengandung huruf dan spasi")
    private String password;
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    private String username;
    /**
     * 0812 / 62812 / +62812
     * 0813 / 62813 / +62813
     * 0815 / 62815 / +62815
     */
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^[0|62|+62]8[12|13|15|16|21|22|23|][0-9]{6}$", message = "Nama lengkap hanya boleh mengandung huruf dan spasi")
    private String otp;
}