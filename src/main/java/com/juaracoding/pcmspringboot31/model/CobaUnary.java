package com.juaracoding.pcmspringboot31.model;

import com.juaracoding.pcmspringboot31.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ConfCobaUnary",schema = "projectz")
public class CobaUnary extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdParent",foreignKey = @ForeignKey(name = "FK_CobaUnary_Parent"))
    private CobaUnary idParent;

    @Column(name = "NamaCoba",length = 55,nullable = false,unique = true)
    private String nama;
}