package com.juaracoding.pcmspringboot31.dto.validation;

import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ValMenuDTO {
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotEmpty(message = ConstantMessage.NOT_EMPTY)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]{3,20}$", message = "Alfanumeric dan spasi min 3 maks 20")
    private String nama;
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotEmpty(message = ConstantMessage.NOT_EMPTY)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^[a-z0-9\\/]{5,50}$", message = "Huruf kecil ,angka dan spasi min 20 maks 255")
    private String path;
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotEmpty(message = ConstantMessage.NOT_EMPTY)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]{20,255}$", message = "Alfanumeric dan spasi min 20 maks 255")
    private String deskripsi;
}
