CREATE TABLE projectz.ConfCobaUnary
(
    Id        bigint IDENTITY (1, 1) NOT NULL,
    IdParent  bigint,
    NamaCoba  varchar(55)            NOT NULL,
    CreatedBy varchar(255)           NOT NULL,
    CreatedAt datetime               NOT NULL,
    UpdatedBy varchar(255),
    UpdatedAt datetime,
    DeletedBy varchar(255),
    DeletedAt datetime,
    CONSTRAINT pk_confcobaunary PRIMARY KEY (Id)
)
GO

ALTER TABLE projectz.ConfCobaUnary
    ADD CONSTRAINT uc_confcobaunary_namacoba UNIQUE (NamaCoba)
GO

ALTER TABLE projectz.ConfCobaUnary
    ADD CONSTRAINT FK_COBAUNARY_PARENT FOREIGN KEY (IdParent) REFERENCES projectz.ConfCobaUnary (Id)
GO