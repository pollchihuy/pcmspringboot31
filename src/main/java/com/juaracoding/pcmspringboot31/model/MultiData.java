package com.juaracoding.pcmspringboot31.model;


import com.juaracoding.pcmspringboot31.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "MultiData",schema = "projectz")
public class MultiData extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUser", nullable = false,foreignKey = @ForeignKey(name = "FK_MultiData_User"))
    private User userx;
    @Column(name = "Data", nullable = false, length = 20)
    private String data;
    @Column(name = "Deskripsi", nullable = false)
    private String deskripsi;
    @Column(name = "Tambah")
    private String tambah;
}
