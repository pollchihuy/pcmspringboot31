package com.juaracoding.pcmspringboot31.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CobaDTO {

    private Long id;
    @JsonProperty("nama_lengkap")
    private String namaLengkap;
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Description must be alphanumeric ex: IniAdalahKeterangan123")
    private String description;
    private Double price;
}