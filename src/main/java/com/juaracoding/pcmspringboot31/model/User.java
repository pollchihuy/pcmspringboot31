package com.juaracoding.pcmspringboot31.model;

import com.juaracoding.pcmspringboot31.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "MstUser",schema = "projectz")
@Comment("Tabel ini merupakan tabel informasi user dari aplikasi ini")
public class User extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAkses",nullable = false,foreignKey = @ForeignKey(name = "FK_User_Akses"))
    private Akses akses;
    @Column(name = "Password",length = 64,nullable = false)
    private String password;
    @Column(name = "Username",length = 16,nullable = false,unique = true)
    private String username;
    @Column(name = "NoHp",length = 20,nullable = false,unique = true)
    private String noHp;
    @Comment("Informasi email user")
    @Column(name = "Email",nullable = false, unique = true)
    private String email;
    @Comment("Informasi Nama Lengkap user")
    @Column(name = "NamaLengkap",length = 75,nullable = false)
    private String namaLengkap;
    @Column(name = "TanggalLahir",nullable = false)
    private LocalDate tanggalLahir;
    @Column(name = "Otp",length = 64)
    private String otp;
    @Transient
    private String umur;
    @OneToMany(mappedBy = "userx")
    private List<MultiData> multiData;

    public String getUmur() {
//        return Period.between(tanggalLahir,LocalDate.now()).getYears() + " Tahun";
        return tanggalLahir==null?"":Period.between(tanggalLahir,LocalDate.now()).getYears() + " Tahun";
    }
}
