package com.juaracoding.pcmspringboot31.dto.query;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class SearchMenuDTO {
    private String nama;
    private String path;
    private String deskripsi;
    private LocalDate start;
    private LocalDate end;
}