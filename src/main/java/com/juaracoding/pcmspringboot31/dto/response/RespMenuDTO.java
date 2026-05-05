package com.juaracoding.pcmspringboot31.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RespMenuDTO {
    private Long id;
    private String nama;
    private String path;
    private String deskripsi;
}