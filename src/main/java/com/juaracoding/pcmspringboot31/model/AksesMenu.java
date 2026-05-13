package com.juaracoding.pcmspringboot31.model;

import com.juaracoding.pcmspringboot31.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "AksesMenu",schema = "projectz",
        uniqueConstraints = @UniqueConstraint(columnNames = {"IdAkses","IdMenu"}, name = "UNQ_AksesMenu_IdAkses_IdMenu"))
public class AksesMenu extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAkses",foreignKey = @ForeignKey(name = "FK_AksesMenu_Akses"), nullable = false)
    private Akses akses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMenu",foreignKey = @ForeignKey(name = "FK_AksesMenu_Menu"), nullable = false)
    private Menu menu;

    /** flag i */
    @Column(name = "CanInsert")
    private Boolean canInsert;
    /** flag u */
    @Column(name = "CanUpdate")
    private Boolean canUpdate;
    /** flag d */
    @Column(name = "CanDelete")
    private Boolean canDelete;
    /** flag v */
    @Column(name = "CanView")
    private Boolean canView;
    /** flag p */
    @Column(name = "CanPrint")
    private Boolean canPrint;
}
