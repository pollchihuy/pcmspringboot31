-- ----------------------------
-- Records of MstMenu
-- ----------------------------
SET IDENTITY_INSERT [projectz].[MstMenu] ON
GO

INSERT INTO [projectz].[MstMenu] ([Id], [NamaMenu], [Path], [DeskripsiMenu], [CreatedBy], [CreatedAt], [UpdatedBy], [UpdatedAt], [DeletedBy], [DeletedAt]) VALUES (N'1', N'Menu', N'/menu', N'Informasi Untuk Menu di Aplikasi', N'{"id":"1","nama":"System"}', N'2026-05-12 15:35:35.000', NULL, NULL, NULL, NULL)
GO

INSERT INTO [projectz].[MstMenu] ([Id], [NamaMenu], [Path], [DeskripsiMenu], [CreatedBy], [CreatedAt], [UpdatedBy], [UpdatedAt], [DeletedBy], [DeletedAt]) VALUES (N'2', N'Akses', N'/akses', N'Informasi Untuk Akses di Aplikasi', N'{"id":"1","nama":"System"}', N'2026-05-12 15:35:59.000', NULL, NULL, NULL, NULL)
GO

INSERT INTO [projectz].[MstMenu] ([Id], [NamaMenu], [Path], [DeskripsiMenu], [CreatedBy], [CreatedAt], [UpdatedBy], [UpdatedAt], [DeletedBy], [DeletedAt]) VALUES (N'3', N'User', N'/user', N'Informasi Untuk User di Aplikasi', N'{"id":"1","nama":"System"}', N'2026-05-12 15:36:18.000', NULL, NULL, NULL, NULL)
GO

SET IDENTITY_INSERT [projectz].[MstMenu] OFF
GO


-- ----------------------------
-- Records of MstAkses
-- ----------------------------
SET IDENTITY_INSERT [projectz].[MstAkses] ON
GO

INSERT INTO [projectz].[MstAkses] ([Id], [NamaAkses], [Deskripsi], [CreatedBy], [CreatedAt], [UpdatedBy], [UpdatedAt], [DeletedBy], [DeletedAt]) VALUES (N'1', N'Admin', N'Super User', N'{"id":"1","nama":"System"}', N'2026-05-12 18:39:15.000', NULL, NULL, NULL, NULL)
GO

INSERT INTO [projectz].[MstAkses] ([Id], [NamaAkses], [Deskripsi], [CreatedBy], [CreatedAt], [UpdatedBy], [UpdatedAt], [DeletedBy], [DeletedAt]) VALUES (N'2', N'Member', N'Default User', N'{"id":"1","nama":"System"}', N'2026-05-12 18:39:57.000', NULL, NULL, NULL, NULL)
GO

SET IDENTITY_INSERT [projectz].[MstAkses] OFF
GO

-- ----------------------------
-- Records of MstUser
-- ----------------------------
SET IDENTITY_INSERT [projectz].[MstUser] ON
GO

INSERT INTO [projectz].[MstUser] ([Id], [IdAkses], [Password], [Username], [NoHp], [Email], [NamaLengkap], [TanggalLahir], [Otp], [CreatedBy], [CreatedAt], [UpdatedBy], [UpdatedAt], [DeletedBy], [DeletedAt], [IsRegistered]) VALUES (N'1', N'1', N'$2a$11$4XieocXCBC8hqA3L76sMa.Juaz0A08iVwwEVFXWOVX2p4XqJNw7IK', N'admin.123', N'+62813121415', N'admin321@gmail.com', N'Administrator Apps', N'1980-01-01', NULL, N'{"id":"1","nama":"System"}', N'2026-05-12 18:45:30.000', NULL, NULL, NULL, NULL,0)
GO

SET IDENTITY_INSERT [projectz].[MstUser] OFF
GO

-- ----------------------------
-- Records of AksesMenu
-- ----------------------------
INSERT INTO [projectz].[AksesMenu] ([IdAkses], [IdMenu]) VALUES (N'1', N'1')
GO

INSERT INTO [projectz].[AksesMenu] ([IdAkses], [IdMenu]) VALUES (N'1', N'2')
GO

INSERT INTO [projectz].[AksesMenu] ([IdAkses], [IdMenu]) VALUES (N'1', N'3')
GO

INSERT INTO [projectz].[AksesMenu] ([IdAkses], [IdMenu]) VALUES (N'2', N'3')
GO