CREATE TABLE projectz.mst_tambah_doang
(
    id              bigint IDENTITY (1, 1) NOT NULL,
    apa_aja         varchar(64)            NOT NULL,
    deskripsi_doank varchar(255)           NOT NULL,
    nominal         decimal(15, 2),
    created_by      varchar(255)           NOT NULL,
    created_at      datetime               NOT NULL,
    updated_by      varchar(255),
    updated_at      datetime,
    deleted_by      varchar(255),
    deleted_at      datetime,
    CONSTRAINT pk_msttambahdoang PRIMARY KEY (id)
)
GO

DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE projectz.multi_data DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'projectz.multi_data')
  AND [c].[name] = N'tambah'
EXEC sp_executesql @sql
GO

ALTER TABLE projectz.multi_data
    DROP COLUMN tambah
GO

ALTER TABLE projectz.multi_data
    ADD tambah varchar(255)
GO