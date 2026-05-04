package com.juaracoding.pcmspringboot31.util;//package com.ptdika.hris.util;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // Menandakan ini parent class untuk Entity, bukan tabel database
public abstract class AuditTzEntity {
    /**
     * Asia/Jakarta WIB
     * Asia/Makasar WITA
     * Asia/Jayapura WIT
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CreatedBy",nullable = false, updatable = false)
    private String createdBy;
    @CreationTimestamp
    @Column(name = "CreatedAt",nullable = false, updatable = false)
    private Instant createdAt;
    @Column(name = "CreatedTz",nullable = false, updatable = false,length = 50)
    private String createdTz;
    @Column(name = "UpdatedBy")
    private String updatedBy;
    @UpdateTimestamp
    @Column(name = "UpdatedAt")
    private Instant updatedAt;
    @Column(name = "UpdatedTz",nullable = false,length = 50)
    private String updatedTz;
    @Column(name = "DeletedBy",insertable = false)
    private String deletedBy;
    @Column(name = "DeletedAt",insertable = false)
    private Instant deletedAt;
    @Column(name = "DeletedTz",nullable = false,length = 50)
    private String deletedTz;
}