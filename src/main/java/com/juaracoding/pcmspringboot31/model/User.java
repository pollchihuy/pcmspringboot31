package com.juaracoding.pcmspringboot31.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "MstUser",
        uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class User {
    @Id
    @Column(name = "Id")
    private Long id;
    @Column(name = "NamaLengkap",length = 75)
    private String namaLengkap;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password",length = 64)
    private String password;
    @Column(name = "Username")
    private String username;
    @Transient
    private String umur;
    private LocalDate tanggalLahir;
    @Column(name = "Otp",length = 64)
    private String otp;

    public String getUmur() {
//        return Period.between(tanggalLahir,LocalDate.now()).getYears() + " Tahun";
        return tanggalLahir==null?"":Period.between(tanggalLahir,LocalDate.now()).getYears() + " Tahun";
    }
}
