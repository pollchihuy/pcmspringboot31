package com.juaracoding.pcmspringboot31.model;

import com.juaracoding.pcmspringboot31.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "MstTambahDoang",schema = "projectz")
public class TambahDoang extends BaseEntity {

    @Column(name = "ApaAja",length = 64,nullable = false)
    private String apaAja;
    @Column(name = "DeskripsiDoank",nullable = false)
    private String deskripsi;
    @Column(name = "Nominal",precision = 15,scale = 2)
    private BigDecimal nominal;
}
