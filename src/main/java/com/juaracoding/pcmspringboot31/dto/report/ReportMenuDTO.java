package com.juaracoding.pcmspringboot31.dto.report;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportMenuDTO {
    private String nama;
    private String path;
    @JsonIgnore
    private String deskripsi;
}