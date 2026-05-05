DECLARE @sql [nvarchar](MAX)
SELECT @sql = N'ALTER TABLE projectz.MstDoank DROP CONSTRAINT ' + QUOTENAME([df].[name])
FROM [sys].[columns] AS [c]
         INNER JOIN [sys].[default_constraints] AS [df] ON [df].[object_id] = [c].[default_object_id]
WHERE [c].[object_id] = OBJECT_ID(N'projectz.MstDoank')
  AND [c].[name] = N'DeskripsiDoank'
EXEC sp_executesql @sql
GO

ALTER TABLE projectz.MstDoank
    DROP COLUMN DeskripsiDoank
GO