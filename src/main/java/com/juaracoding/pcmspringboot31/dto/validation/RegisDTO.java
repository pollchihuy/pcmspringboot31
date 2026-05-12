package com.juaracoding.pcmspringboot31.dto.validation;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class RegisDTO {
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^[a-zA-Z\\s]{4,75}$",message = "Hanya Alfabet dan spasi Minimal 4 Maksimal 70")
    @JsonProperty("nama_lengkap")
    private String namaLengkap;

    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^(?=.{1,256})(?=.{1,64}@.{1,255}$)(?:(?![.])[a-zA-Z0-9._%+-]+(?:(?<!\\\\)[.][a-zA-Z0-9-]+)*?)@[a-zA-Z0-9.-]+(?:\\.[a-zA-Z]{2,50})+$",
            message = "Format tidak valid ex : user_name123@sub.domain.com")
    private String email;

    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@_#\\-$])[\\w].{8,15}$",
            message = "Format minimal 1 angka, 1 huruf kecil, 1 huruf besar, 1 spesial karakter (_ \"Underscore\", - \"Hyphen\", # \"Hash\", atau $ \"Dollar\" atau @ \"At\") setelah 4 kondisi min 9 max 16 alfanumerik, contoh : aB4$12345")
    private String password;

    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^([a-z0-9\\.]{8,16})$",
            message = "Format Huruf kecil ,numeric dan titik saja min 8 max 16 karakter, ex : paulch.1234")
    private String username;
    /**
     * 0812 / 62812 / +62812
     * 0813 / 62813 / +62813
     * 0815 / 62815 / +62815
     */
    @NotNull(message = ConstantMessage.NOT_NULL)
    @NotBlank(message = ConstantMessage.NOT_BLANK)
    @Pattern(regexp = "^(62|\\+62|0)8[0-9]{9,16}$",
            message = "Format No HP Tidak Valid , min 9 max 16 setelah angka 8, contoh : (0/62/+62)81111111")
    @JsonProperty("no_hp")
    private String noHp;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = ConstantMessage.NOT_NULL)
    @JsonProperty("tanggal_lahir")
    private LocalDate tanggalLahir;
}