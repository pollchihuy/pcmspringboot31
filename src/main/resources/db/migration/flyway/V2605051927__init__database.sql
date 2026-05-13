CREATE TABLE projectz.AksesMenu
(
    Id        bigint IDENTITY (1, 1) NOT NULL,
    IdAkses   bigint                 NOT NULL,
    IdMenu    bigint                 NOT NULL,
    CanInsert bit,
    CanUpdate bit,
    CanDelete bit,
    CanView   bit,
    CanPrint  bit,
    CreatedBy varchar(255)           NOT NULL,
    CreatedAt datetime               NOT NULL,
    UpdatedBy varchar(255),
    UpdatedAt datetime,
    DeletedBy varchar(255),
    DeletedAt datetime,
    CONSTRAINT pk_aksesmenu PRIMARY KEY (Id)
)
GO

CREATE TABLE projectz.MstAkses
(
    Id        bigint IDENTITY (1, 1) NOT NULL,
    NamaAkses varchar(20)            NOT NULL,
    Deskripsi varchar(255)           NOT NULL,
    CreatedBy varchar(255)           NOT NULL,
    CreatedAt datetime               NOT NULL,
    UpdatedBy varchar(255),
    UpdatedAt datetime,
    DeletedBy varchar(255),
    DeletedAt datetime,
    CONSTRAINT pk_mstakses PRIMARY KEY (Id)
)
GO

CREATE TABLE projectz.MstDoank
(
    Id             bigint IDENTITY (1, 1) NOT NULL,
    ApaAja         varchar(64)            NOT NULL,
    DeskripsiDoank varchar(255)           NOT NULL,
    Nominal        decimal(15, 2),
    CreatedBy      varchar(255)           NOT NULL,
    CreatedAt      datetime               NOT NULL,
    UpdatedBy      varchar(255),
    UpdatedAt      datetime,
    DeletedBy      varchar(255),
    DeletedAt      datetime,
    CONSTRAINT pk_mstdoank PRIMARY KEY (Id)
)
GO

CREATE TABLE projectz.MstMenu
(
    Id            bigint IDENTITY (1, 1) NOT NULL,
    NamaMenu      varchar(20)            NOT NULL,
    Path          varchar(50)            NOT NULL,
    DeskripsiMenu varchar(255)           NOT NULL,
    CreatedBy     varchar(255)           NOT NULL,
    CreatedAt     datetime               NOT NULL,
    UpdatedBy     varchar(255),
    UpdatedAt     datetime,
    DeletedBy     varchar(255),
    DeletedAt     datetime,
    CONSTRAINT pk_mstmenu PRIMARY KEY (Id)
)
GO

CREATE TABLE projectz.MstTambahDoang
(
    Id             bigint IDENTITY (1, 1) NOT NULL,
    ApaAja         varchar(64)            NOT NULL,
    DeskripsiDoank varchar(255)           NOT NULL,
    Nominal        decimal(15, 2),
    CreatedBy      varchar(255)           NOT NULL,
    CreatedAt      datetime               NOT NULL,
    UpdatedBy      varchar(255),
    UpdatedAt      datetime,
    DeletedBy      varchar(255),
    DeletedAt      datetime,
    CONSTRAINT pk_msttambahdoang PRIMARY KEY (Id)
)
GO

CREATE TABLE projectz.MstUser
(
    Id           bigint IDENTITY (1, 1) NOT NULL,
    IdAkses      bigint                 NOT NULL,
    Password     varchar(64)            NOT NULL,
    Username     varchar(16)            NOT NULL,
    NoHp         varchar(20)            NOT NULL,
    Email        varchar(255)           NOT NULL,
    NamaLengkap  varchar(75)            NOT NULL,
    TanggalLahir date                   NOT NULL,
    Otp          varchar(64),
    CreatedBy    varchar(255)           NOT NULL,
    CreatedAt    datetime               NOT NULL,
    UpdatedBy    varchar(255),
    UpdatedAt    datetime,
    DeletedBy    varchar(255),
    DeletedAt    datetime,
    IsRegistered bit                    NOT NULL,
    CONSTRAINT pk_mstuser PRIMARY KEY (Id)
)
GO
IF EXISTS(SELECT extended_properties.value
          FROM sys.extended_properties
          WHERE major_id = OBJECT_ID('projectz.MstUser')
            AND name = N'MS_DESCRIPTION'
            AND minor_id = 0)
    BEGIN
        EXEC sys.sp_updateextendedproperty @name = N'MS_Description',
             @value = N'Tabel ini merupakan tabel informasi user dari aplikasi ini', @level0type = N'SCHEMA',
             @level0name = N'projectz', @level1type = N'TABLE', @level1name = N'MstUser'
    END
ELSE
    BEGIN
        EXEC sys.sp_addextendedproperty @name = N'MS_Description',
             @value = N'Tabel ini merupakan tabel informasi user dari aplikasi ini', @level0type = N'SCHEMA',
             @level0name = N'projectz', @level1type = N'TABLE', @level1name = N'MstUser'
    END
GO
IF EXISTS(SELECT extended_properties.value
          FROM sys.extended_properties
          WHERE major_id = OBJECT_ID('projectz.MstUser')
            AND name = N'MS_DESCRIPTION'
            AND minor_id =
                (SELECT column_id FROM sys.columns WHERE name = 'Email' AND object_id = OBJECT_ID('projectz.MstUser')))
    BEGIN
        EXEC sys.sp_updateextendedproperty @name = N'MS_Description', @value = N'Informasi email user',
             @level0type = N'SCHEMA', @level0name = N'projectz', @level1type = N'TABLE', @level1name = N'MstUser',
             @level2type = N'COLUMN', @level2name = N'Email'
    END
ELSE
    BEGIN
        EXEC sys.sp_addextendedproperty @name = N'MS_Description', @value = N'Informasi email user',
             @level0type = N'SCHEMA', @level0name = N'projectz', @level1type = N'TABLE', @level1name = N'MstUser',
             @level2type = N'COLUMN', @level2name = N'Email'
    END
GO
IF EXISTS(SELECT extended_properties.value
          FROM sys.extended_properties
          WHERE major_id = OBJECT_ID('projectz.MstUser')
            AND name = N'MS_DESCRIPTION'
            AND minor_id = (SELECT column_id
                            FROM sys.columns
                            WHERE name = 'NamaLengkap'
                              AND object_id = OBJECT_ID('projectz.MstUser')))
    BEGIN
        EXEC sys.sp_updateextendedproperty @name = N'MS_Description', @value = N'Informasi Nama Lengkap user',
             @level0type = N'SCHEMA', @level0name = N'projectz', @level1type = N'TABLE', @level1name = N'MstUser',
             @level2type = N'COLUMN', @level2name = N'NamaLengkap'
    END
ELSE
    BEGIN
        EXEC sys.sp_addextendedproperty @name = N'MS_Description', @value = N'Informasi Nama Lengkap user',
             @level0type = N'SCHEMA', @level0name = N'projectz', @level1type = N'TABLE', @level1name = N'MstUser',
             @level2type = N'COLUMN', @level2name = N'NamaLengkap'
    END
GO

CREATE TABLE projectz.MultiData
(
    Id        bigint IDENTITY (1, 1) NOT NULL,
    CreatedBy varchar(255)           NOT NULL,
    CreatedAt datetime               NOT NULL,
    UpdatedBy varchar(255),
    UpdatedAt datetime,
    DeletedBy varchar(255),
    DeletedAt datetime,
    IdUser    bigint                 NOT NULL,
    Data      varchar(20)            NOT NULL,
    Deskripsi varchar(255)           NOT NULL,
    Tambah    varchar(255),
    CONSTRAINT pk_multidata PRIMARY KEY (Id)
)
GO

ALTER TABLE projectz.AksesMenu
    ADD CONSTRAINT UNQ_AksesMenu_IdAkses_IdMenu UNIQUE (IdAkses, IdMenu)
GO

ALTER TABLE projectz.MstAkses
    ADD CONSTRAINT uc_mstakses_namaakses UNIQUE (NamaAkses)
GO

ALTER TABLE projectz.MstMenu
    ADD CONSTRAINT uc_mstmenu_namamenu UNIQUE (NamaMenu)
GO

ALTER TABLE projectz.MstMenu
    ADD CONSTRAINT uc_mstmenu_path UNIQUE (Path)
GO

ALTER TABLE projectz.MstUser
    ADD CONSTRAINT uc_mstuser_email UNIQUE (Email)
GO

ALTER TABLE projectz.MstUser
    ADD CONSTRAINT uc_mstuser_nohp UNIQUE (NoHp)
GO

ALTER TABLE projectz.MstUser
    ADD CONSTRAINT uc_mstuser_username UNIQUE (Username)
GO

ALTER TABLE projectz.AksesMenu
    ADD CONSTRAINT FK_AKSESMENU_AKSES FOREIGN KEY (IdAkses) REFERENCES projectz.MstAkses (Id)
GO

ALTER TABLE projectz.AksesMenu
    ADD CONSTRAINT FK_AKSESMENU_MENU FOREIGN KEY (IdMenu) REFERENCES projectz.MstMenu (Id)
GO

ALTER TABLE projectz.MultiData
    ADD CONSTRAINT FK_MULTIDATA_USER FOREIGN KEY (IdUser) REFERENCES projectz.MstUser (Id)
GO

ALTER TABLE projectz.MstUser
    ADD CONSTRAINT FK_USER_AKSES FOREIGN KEY (IdAkses) REFERENCES projectz.MstAkses (Id)
GO