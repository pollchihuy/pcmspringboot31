package com.juaracoding.pcmspringboot31.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "MstUser",
        uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
@Comment("Tabel ini merupakan tabel informasi user dari aplikasi ini")
public class User {
    @Id
    @Column(name = "Id")
    @Comment("Primary Key dari tabel MstUser")
    private Long id;
    @Comment("Informasi Nama Lengkap user")
    @Column(name = "NamaLengkap",length = 75)
    private String namaLengkap;
    @Comment("Informasi email user")
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

    @Column(name = "CreatedBy",nullable = false, updatable = false)
    private String createdBy;
    @Column(name = "CreatedAt",nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "UpdatedBy")
    private String updatedBy;
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;
    @Column(name = "DeletedBy",insertable = false)
    private String deletedBy;
    @Column(name = "DeletedAt",insertable = false)
    private LocalDateTime deletedAt;


    public String getUmur() {
//        return Period.between(tanggalLahir,LocalDate.now()).getYears() + " Tahun";
        return tanggalLahir==null?"":Period.between(tanggalLahir,LocalDate.now()).getYears() + " Tahun";
    }
}
