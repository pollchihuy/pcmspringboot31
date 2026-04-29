package com.juaracoding.pcmspringboot31.dto.validation;


import jakarta.validation.constraints.Pattern;

public class RegisDTO {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z ]{4,75}$", message = "Nama lengkap hanya boleh mengandung huruf dan spasi")
    private String namaLengkap;
    private String email;
    @Pattern(regexp = "^[a-zA-Z ]{8,16}$", message = "Nama lengkap hanya boleh mengandung huruf dan spasi")
    private String password;
    private String username;
    @Pattern(regexp = "^[0-9]{6}$", message = "Nama lengkap hanya boleh mengandung huruf dan spasi")
    private String otp;
}
