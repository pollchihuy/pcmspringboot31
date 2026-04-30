package com.juaracoding.pcmspringboot31.dto.validation;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class ContohDTO {

    private Long id;
    private Boolean status;
    private Short contohShort;
    @Min(20)
    @Max(100)
    private Integer contohInteger;
    private Double contohDouble;
    private Float contohFloat;
    @Pattern(regexp = "^[1-4]+(\\.[0-9]{1,2})?$",message = "Harus berupa angka dengan maksimal 2 angka di belakang koma")
    private BigDecimal contohBigDecimal;
    private Byte contohByte;
    private Character contohCharacter;
}
