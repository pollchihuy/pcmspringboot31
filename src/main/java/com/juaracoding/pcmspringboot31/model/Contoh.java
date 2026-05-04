//package com.juaracoding.pcmspringboot31.model;
//
//import jakarta.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//@Table(schema = "coba",uniqueConstraints = @UniqueConstraint(columnNames = {"contohShort","contohDouble"},name = "unq_short_double"),
//indexes = @Index(name = "idx_contoh_float", columnList = "contohFloat"),name = "MstContoh")
//public class Contoh {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id")
//    private Long id;
//    private Boolean status;
//    private Short contohShort;
//    private Integer contohInteger;
//    private Double contohDouble;
//    private Float contohFloat;
//    @Column(name = "ContohBigDecimal",precision = 3,scale = 2,columnDefinition = "default fungsiValidasi() ")
//    private BigDecimal contohBigDecimal;
//    private Byte contohByte;
//    private Character contohCharacter;
//
//}
