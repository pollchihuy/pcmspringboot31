-- DROP SCHEMA projectz;

-- BEB31.projectz.mst_akses definition

-- Drop table

-- DROP TABLE BEB31.projectz.mst_akses;

CREATE TABLE BEB31.projectz.mst_akses (
                                          id bigint IDENTITY(1,1) NOT NULL,
                                          nama_akses varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                          deskripsi varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                          created_at datetime2(6) NOT NULL,
                                          deleted_at datetime2(6) NULL,
                                          updated_at datetime2(6) NULL,
                                          created_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                          deleted_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                          updated_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                          CONSTRAINT PK__mst_akses PRIMARY KEY (id),
                                          CONSTRAINT UNQ_nama_akses UNIQUE (nama_akses)
);


-- BEB31.projectz.mst_menu definition

-- Drop table

-- DROP TABLE BEB31.projectz.mst_menu;

CREATE TABLE BEB31.projectz.mst_menu (
                                         id bigint IDENTITY(1,1) NOT NULL,
                                         nama_menu varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         [path] varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         deskripsi_menu varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         created_at datetime2(6) NOT NULL,
                                         deleted_at datetime2(6) NULL,
                                         updated_at datetime2(6) NULL,
                                         created_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         deleted_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                         updated_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                         CONSTRAINT PK__mst_menu PRIMARY KEY (id),
                                         CONSTRAINT UNQ_nama_menu UNIQUE (nama_menu),
                                         CONSTRAINT UNQ_path_menu UNIQUE ([path])
);


-- BEB31.projectz.akses_menu definition

-- Drop table

-- DROP TABLE BEB31.projectz.akses_menu;

CREATE TABLE BEB31.projectz.akses_menu (
                                           id_akses bigint NOT NULL,
                                           id_menu bigint NOT NULL,
                                           CONSTRAINT Unq_Akses_Menu UNIQUE (id_akses,id_menu),
                                           CONSTRAINT FK_AksesMenu_Akses FOREIGN KEY (id_akses) REFERENCES BEB31.projectz.mst_akses(id),
                                           CONSTRAINT FK_AksesMenu_Menu FOREIGN KEY (id_menu) REFERENCES BEB31.projectz.mst_menu(id)
);


-- BEB31.projectz.multi_data definition

-- Drop table

-- DROP TABLE BEB31.projectz.multi_data;

CREATE TABLE BEB31.projectz.mst_user (
                                         id bigint IDENTITY(1,1) NOT NULL,
                                         id_akses bigint NOT NULL,
                                         username varchar(16) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         no_hp varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         otp varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                         password varchar(64) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         nama_lengkap varchar(75) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         tanggal_lahir date NOT NULL,
                                         email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         created_at datetime2(6) NOT NULL,
                                         deleted_at datetime2(6) NULL,
                                         updated_at datetime2(6) NULL,
                                         created_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                         deleted_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                         updated_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                         CONSTRAINT PK__mst_user PRIMARY KEY (id),
                                         CONSTRAINT UNQ__email UNIQUE (email),
                                         CONSTRAINT UNQ__username UNIQUE (username),
                                         CONSTRAINT UNQ__no__hp UNIQUE (no_hp),
                                         CONSTRAINT FK_User_Akses FOREIGN KEY (id_akses) REFERENCES BEB31.projectz.mst_akses(id)
);

-- BEB31.projectz.mst_user definition

-- Drop table

-- DROP TABLE BEB31.projectz.mst_user;

CREATE TABLE BEB31.projectz.multi_data (
                                           id bigint IDENTITY(1,1) NOT NULL,
                                           id_user bigint NOT NULL,
                                           created_at datetime2(6) NOT NULL,
                                           deleted_at datetime2(6) NULL,
                                           [data] varchar(20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                           deskripsi varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                           updated_at datetime2(6) NULL,
                                           created_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
                                           deleted_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                           updated_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
                                           CONSTRAINT PK__multi_data PRIMARY KEY (id),
                                           CONSTRAINT FK_MultiData_User FOREIGN KEY (id_user) REFERENCES BEB31.projectz.mst_user(id)
);