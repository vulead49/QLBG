CREATE DATABASE QLBANGIAY;
GO
USE QLBANGIAY;
GO
ALTER DATABASE [QLBANGIAY] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLBANGIAY] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLBANGIAY] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLBANGIAY] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLBANGIAY] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLBANGIAY] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLBANGIAY] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLBANGIAY] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLBANGIAY] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLBANGIAY] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLBANGIAY] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLBANGIAY] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLBANGIAY] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLBANGIAY] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLBANGIAY] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLBANGIAY] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLBANGIAY] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLBANGIAY] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLBANGIAY] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLBANGIAY] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLBANGIAY] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLBANGIAY] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLBANGIAY] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLBANGIAY] SET  MULTI_USER 
GO
ALTER DATABASE [QLBANGIAY] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLBANGIAY] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLBANGIAY] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLBANGIAY] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLBANGIAY] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLBANGIAY] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLBANGIAY] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLBANGIAY] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLBANGIAY]
GO
/****** Object:  Table [dbo].[BangLuong]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangLuong](
	[STT] [int] NOT NULL,
	[MaNV] [int] NOT NULL,
	[Thang] [int] NOT NULL,
	[Nam] [int] NOT NULL,
	[SoNgayNghi] [int] NULL,
	[Luong] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CapBac]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CapBac](
	[MaCapBac] [int] NOT NULL,
	[TenCapBac] [nvarchar](5) NULL,
	[LuongCoBan] [decimal](18, 2) NULL,
	[MucLuongGio] [decimal](10, 2) NULL,
 CONSTRAINT [PK_CB] PRIMARY KEY CLUSTERED 
(
	[MaCapBac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTDH]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTDH](
	[MaDH] [int] NOT NULL,
	[MaSP] [int] NOT NULL,
	[SoLuong] [int] NULL,
	[GiaBan] [int] NULL,
	[MaCTDH] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPhieuNhap]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPhieuNhap](
	[MaPN] [int] NOT NULL,
	[MaSP] [int] NOT NULL,
	[SoLuong] [int] NULL,
	[Hang] [nvarchar](50) NULL,
	[Size] [int] NULL,
	[GiaNhap] [int] NULL,
	[TenSP] [nvarchar](50) NULL,
	[PhanLoai] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[MaDH] [int] NOT NULL,
	[TenKH] [nvarchar](50) NULL,
	[NgayLap] [date] NULL,
	[ThanhTien] [int] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_DH] PRIMARY KEY CLUSTERED 
(
	[MaDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kho]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kho](
	[MaSP] [int] NOT NULL,
	[TenSP] [nvarchar](50) NULL,
	[Hang] [nvarchar](50) NULL,
	[PhanLoai] [nvarchar](50) NULL,
	[Size] [int] NULL,
	[SoLuong] [int] NULL,
	[GiaBan] [int] NULL,
 CONSTRAINT [PK_SP] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichLam]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichLam](
	[STT] [int] NOT NULL,
	[MaNV] [int] NOT NULL,
	[TenNV] [nvarchar](50) NULL,
	[Ngay] [date] NULL,
	[GioBatDau] [time](7) NOT NULL,
	[GioKetThuc] [time](7) NOT NULL,
	[DuyetCong] [bit] NULL,
 CONSTRAINT [PK_LL] PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NgayNghi]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NgayNghi](
	[STT] [int] NOT NULL,
	[NgayNghi] [date] NOT NULL,
	[MaNV] [int] NOT NULL,
	[LyDo] [nvarchar](255) NULL,
	[Duyet] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[STT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [int] NOT NULL,
	[TenNCC] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [int] NULL,
 CONSTRAINT [PK_NCC] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [int] NOT NULL,
	[MaCapBac] [int] NOT NULL,
	[HoTen] [nvarchar](100) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[SDT] [nvarchar](50) NULL,
 CONSTRAINT [PK_NV] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanQuyen]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanQuyen](
	[MaQuyen] [int] NOT NULL,
	[TenQuyen] [varchar](50) NULL,
	[MoTa] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaQuyen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPN] [int] NOT NULL,
	[MaNCC] [int] NOT NULL,
	[NgayNhap] [date] NOT NULL,
 CONSTRAINT [PK_PN] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TaiKhoanID] [int] NOT NULL,
	[MaNV] [int] NULL,
	[TenDangNhap] [varchar](50) NULL,
	[MatKhau] [varchar](100) NULL,
	[MaQuyen] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[TaiKhoanID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhToan]    Script Date: 08/04/2025 7:37:54 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhToan](
	[MaTT] [int] NOT NULL,
	[MaDH] [int] NOT NULL,
	[HinhThucTT] [nvarchar](50) NULL,
	[ThoiGian] [time](7) NULL,
 CONSTRAINT [PK_TT] PRIMARY KEY CLUSTERED 
(
	[MaTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (1, 1, 3, 2025, 0, CAST(50000000.00 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (3, 10, 3, 2025, 0, CAST(40000000.00 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (4, 16, 3, 2025, 0, CAST(2640000.00 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (5, 8, 3, 2025, 0, CAST(18000000.00 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (6, 16, 4, 2025, 0, CAST(3300000.00 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (7, 13, 3, 2025, 0, CAST(50000000.00 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (8, 6, 3, 2025, 0, CAST(1333333.33 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (9, 1, 1, 2025, 0, CAST(3333333.34 AS Decimal(10, 2)))
INSERT [dbo].[BangLuong] ([STT], [MaNV], [Thang], [Nam], [SoNgayNghi], [Luong]) VALUES (10, 3, 4, 2025, 1, CAST(1000000.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[CapBac] ([MaCapBac], [TenCapBac], [LuongCoBan], [MucLuongGio]) VALUES (1, N'HMNG', CAST(50000000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(10, 2)))
INSERT [dbo].[CapBac] ([MaCapBac], [TenCapBac], [LuongCoBan], [MucLuongGio]) VALUES (2, N'MNG', CAST(40000000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(10, 2)))
INSERT [dbo].[CapBac] ([MaCapBac], [TenCapBac], [LuongCoBan], [MucLuongGio]) VALUES (3, N'FT1', CAST(15000000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(10, 2)))
INSERT [dbo].[CapBac] ([MaCapBac], [TenCapBac], [LuongCoBan], [MucLuongGio]) VALUES (4, N'FT2', CAST(18000000.00 AS Decimal(18, 2)), CAST(0.00 AS Decimal(10, 2)))
INSERT [dbo].[CapBac] ([MaCapBac], [TenCapBac], [LuongCoBan], [MucLuongGio]) VALUES (5, N'PT1', CAST(0.00 AS Decimal(18, 2)), CAST(50000.00 AS Decimal(10, 2)))
INSERT [dbo].[CapBac] ([MaCapBac], [TenCapBac], [LuongCoBan], [MucLuongGio]) VALUES (6, N'PT2', CAST(0.00 AS Decimal(18, 2)), CAST(60000.00 AS Decimal(10, 2)))
GO
SET IDENTITY_INSERT [dbo].[CTDH] ON 

INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (1, 1, 2, 2000000, 1)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (2, 2, 1, 2500000, 2)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (3, 3, 1, 2200000, 3)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (4, 4, 2, 2300000, 4)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (5, 5, 1, 2400000, 5)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (6, 6, 2, 2100000, 6)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (7, 7, 4, 8800000, 7)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (8, 8, 1, 2300000, 8)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (9, 9, 2, 2500000, 9)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (10, 10, 1, 2600000, 10)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (11, 11, 2, 2700000, 11)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (12, 12, 1, 1900000, 12)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (13, 13, 1, 1800000, 13)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (14, 14, 2, 1700000, 14)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (15, 15, 1, 1600000, 15)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (1, 1, 1, 2000000, 16)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (16, 9, 4, 10400000, 17)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (16, 11, 2, 5040000, 19)
INSERT [dbo].[CTDH] ([MaDH], [MaSP], [SoLuong], [GiaBan], [MaCTDH]) VALUES (16, 8, 4, 8400000, 20)
SET IDENTITY_INSERT [dbo].[CTDH] OFF
GO
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (1, 1, 100, N'Adidas', 42, 1500000, N'Adidas Superstar', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (2, 2, 120, N'Nike', 43, 1800000, N'Nike Air Max', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (3, 3, 90, N'Puma', 41, 1700000, N'Puma Suede', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (4, 4, 80, N'Reebok', 40, 1600000, N'Reebok Classic', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (5, 5, 70, N'Adidas', 42, 1900000, N'Adidas Ultraboost', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (6, 6, 110, N'Nike', 43, 2000000, N'Nike React', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (7, 7, 60, N'Puma', 41, 1800000, N'Puma RS-X', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (8, 8, 50, N'Reebok', 40, 1700000, N'Adidas NMD', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (9, 9, 90, N'Adidas', 42, 2200000, N'Nike Air Zoom', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (10, 10, 100, N'Nike', 43, 2300000, N'Reebok Zig', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (11, 11, 110, N'Puma', 41, 2100000, N'Adidas AlphaBounce', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (12, 12, 120, N'Reebok', 40, 2000000, N'Nike Zoom Fly', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (13, 13, 130, N'Adidas', 42, 1400000, N'Puma Future Rider', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (14, 14, 140, N'Nike', 43, 1500000, N'Adidas Gazelle', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (15, 15, 150, N'Puma', 41, 1300000, N'Puma Cali', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (11, 11, 110, N'Adidas', 41, 2100000, N'Adidas AlphaBounce', N'Nam')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (17, 2, 10, N'Adidas', 43, 1800000, N'Nike Air Max', N'Nữ')
INSERT [dbo].[CTPhieuNhap] ([MaPN], [MaSP], [SoLuong], [Hang], [Size], [GiaNhap], [TenSP], [PhanLoai]) VALUES (18, 1, 500, N'Reebok', 42, 1500000, N'Adidas Superstar', N'Nam')
GO
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (1, N'Nguyễn Văn B', CAST(N'2025-01-01' AS Date), 2000000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (2, N'Nguyễn Thị C', CAST(N'2025-01-02' AS Date), 2500000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (3, N'Lê Văn D', CAST(N'2025-01-03' AS Date), 2200000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (4, N'Trần Thị E', CAST(N'2025-01-04' AS Date), 2300000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (5, N'Hoàng Văn F', CAST(N'2025-01-05' AS Date), 2400000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (6, N'Vũ Thị G', CAST(N'2025-01-06' AS Date), 2100000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (7, N'Phạm Văn H', CAST(N'2025-01-07' AS Date), 2200000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (8, N'Bùi Thị I', CAST(N'2025-01-08' AS Date), 2300000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (9, N'Nguyễn Văn K', CAST(N'2025-01-09' AS Date), 2500000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (10, N'Lê Thị L', CAST(N'2025-01-10' AS Date), 2600000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (11, N'Trần Văn M', CAST(N'2025-01-11' AS Date), 2700000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (12, N'Ngô Thị N', CAST(N'2025-01-12' AS Date), 1900000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (13, N'Phạm Văn O', CAST(N'2025-01-13' AS Date), 1800000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (14, N'Nguyễn Thị P', CAST(N'2025-01-14' AS Date), 1700000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (15, N'Lê Văn Q', CAST(N'2025-01-15' AS Date), 1600000, 0)
INSERT [dbo].[DonHang] ([MaDH], [TenKH], [NgayLap], [ThanhTien], [TrangThai]) VALUES (16, N'Nguyễn Văn B', CAST(N'2025-03-28' AS Date), 23840000, 0)
GO
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (1, N'Adidas Superstar', N'Adidas', N'Nam', 42, 599, 1800000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (2, N'Nike Air Max', N'Nike', N'Nữ', 43, 128, 2160000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (3, N'Puma Suede', N'Puma', N'Nam', 41, 89, 2200000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (4, N'Reebok Classic', N'Reebok', N'Nữ', 40, 79, 2100000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (5, N'Adidas Ultraboost', N'Adidas', N'Nam', 42, 70, 2400000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (6, N'Nike React', N'Nike', N'Nữ', 43, 110, 2300000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (7, N'Puma RS-X', N'Puma', N'Nam', 41, 60, 2200000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (8, N'Adidas NMD', N'Reebok', N'Nữ', 40, 46, 2100000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (9, N'Nike Air Zoom', N'Adidas', N'Nam', 42, 90, 2600000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (10, N'Reebok Zig', N'Nike', N'Nữ', 43, 100, 2700000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (11, N'Adidas AlphaBounce', N'Puma', N'Nam', 41, 218, 2520000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (12, N'Nike Zoom Fly', N'Reebok', N'Nữ', 40, 120, 2500000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (13, N'Puma Future Rider', N'Adidas', N'Nam', 42, 130, 1900000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (14, N'Adidas Gazelle', N'Nike', N'Nữ', 43, 140, 1800000)
INSERT [dbo].[Kho] ([MaSP], [TenSP], [Hang], [PhanLoai], [Size], [SoLuong], [GiaBan]) VALUES (15, N'Puma Cali', N'Puma', N'Nam', 41, 150, 1700000)
GO
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (1, 1, N'Nguyễn Văn A', CAST(N'2025-01-01' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (2, 2, N'Trần Thị B', CAST(N'2025-01-02' AS Date), CAST(N'09:00:00' AS Time), CAST(N'18:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (3, 3, N'Lê Văn C', CAST(N'2025-01-03' AS Date), CAST(N'08:30:00' AS Time), CAST(N'17:30:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (4, 4, N'Phạm Thị D', CAST(N'2025-01-04' AS Date), CAST(N'09:00:00' AS Time), CAST(N'18:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (5, 5, N'Hoàng Văn E', CAST(N'2025-01-05' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (6, 6, N'Vũ Thị F', CAST(N'2025-01-06' AS Date), CAST(N'09:00:00' AS Time), CAST(N'18:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (7, 7, N'Bùi Văn G', CAST(N'2025-01-07' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (8, 8, N'Trịnh Thị H', CAST(N'2025-01-08' AS Date), CAST(N'09:00:00' AS Time), CAST(N'18:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (9, 9, N'Đỗ Văn I', CAST(N'2025-01-09' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (10, 10, N'Vũ Thị J', CAST(N'2025-01-10' AS Date), CAST(N'09:00:00' AS Time), CAST(N'18:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (11, 11, N'Nguyễn Văn K', CAST(N'2025-01-11' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (12, 12, N'Trần Thị L', CAST(N'2025-01-12' AS Date), CAST(N'09:00:00' AS Time), CAST(N'18:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (13, 13, N'Lê Văn M', CAST(N'2025-01-13' AS Date), CAST(N'08:30:00' AS Time), CAST(N'17:30:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (14, 14, N'Phạm Thị N', CAST(N'2025-01-14' AS Date), CAST(N'09:00:00' AS Time), CAST(N'18:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (15, 15, N'Ngô Văn O', CAST(N'2025-01-15' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (20, 8, NULL, CAST(N'2025-01-09' AS Date), CAST(N'09:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (21, 13, NULL, CAST(N'2025-03-22' AS Date), CAST(N'08:00:00' AS Time), CAST(N'18:30:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (22, 1, NULL, CAST(N'2025-03-19' AS Date), CAST(N'08:00:00' AS Time), CAST(N'12:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (23, 8, NULL, CAST(N'2025-03-19' AS Date), CAST(N'08:00:00' AS Time), CAST(N'14:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (24, 16, NULL, CAST(N'2025-03-22' AS Date), CAST(N'09:00:00' AS Time), CAST(N'15:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (25, 16, NULL, CAST(N'2025-03-20' AS Date), CAST(N'08:00:00' AS Time), CAST(N'15:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (26, 16, NULL, CAST(N'2025-03-23' AS Date), CAST(N'09:00:00' AS Time), CAST(N'22:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (27, 16, NULL, CAST(N'2025-03-25' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (28, 16, NULL, CAST(N'2025-03-29' AS Date), CAST(N'10:00:00' AS Time), CAST(N'19:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (29, 16, NULL, CAST(N'2025-04-01' AS Date), CAST(N'08:00:00' AS Time), CAST(N'14:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (30, 16, NULL, CAST(N'2025-04-02' AS Date), CAST(N'16:00:00' AS Time), CAST(N'23:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (31, 16, NULL, CAST(N'2025-04-03' AS Date), CAST(N'09:00:00' AS Time), CAST(N'16:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (32, 16, NULL, CAST(N'2025-04-04' AS Date), CAST(N'14:00:00' AS Time), CAST(N'23:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (33, 16, NULL, CAST(N'2025-04-04' AS Date), CAST(N'09:00:00' AS Time), CAST(N'15:30:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (34, 16, NULL, CAST(N'2025-04-06' AS Date), CAST(N'13:00:00' AS Time), CAST(N'18:30:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (35, 16, NULL, CAST(N'2025-04-09' AS Date), CAST(N'09:00:00' AS Time), CAST(N'15:30:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (36, 16, NULL, CAST(N'2025-04-11' AS Date), CAST(N'16:00:00' AS Time), CAST(N'23:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (37, 16, NULL, CAST(N'2025-04-06' AS Date), CAST(N'14:00:00' AS Time), CAST(N'15:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (38, 6, NULL, CAST(N'2025-03-25' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (39, 1, NULL, CAST(N'2025-01-01' AS Date), CAST(N'09:00:00' AS Time), CAST(N'17:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (40, 3, NULL, CAST(N'2025-04-11' AS Date), CAST(N'13:00:00' AS Time), CAST(N'21:00:00' AS Time), 1)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (41, 1, NULL, CAST(N'2025-01-02' AS Date), CAST(N'08:00:00' AS Time), CAST(N'17:00:00' AS Time), 0)
INSERT [dbo].[LichLam] ([STT], [MaNV], [TenNV], [Ngay], [GioBatDau], [GioKetThuc], [DuyetCong]) VALUES (42, 16, NULL, CAST(N'2025-04-08' AS Date), CAST(N'13:00:00' AS Time), CAST(N'18:30:00' AS Time), 0)
GO
INSERT [dbo].[NgayNghi] ([STT], [NgayNghi], [MaNV], [LyDo], [Duyet]) VALUES (1, CAST(N'2025-03-27' AS Date), 16, N'Tui bị ốm nhiều', 1)
INSERT [dbo].[NgayNghi] ([STT], [NgayNghi], [MaNV], [LyDo], [Duyet]) VALUES (2, CAST(N'2025-03-07' AS Date), 3, N'asdasdad', 1)
INSERT [dbo].[NgayNghi] ([STT], [NgayNghi], [MaNV], [LyDo], [Duyet]) VALUES (3, CAST(N'2025-03-30' AS Date), 3, N'sdadas', 1)
INSERT [dbo].[NgayNghi] ([STT], [NgayNghi], [MaNV], [LyDo], [Duyet]) VALUES (4, CAST(N'2025-04-10' AS Date), 3, N'sdadas', 1)
INSERT [dbo].[NgayNghi] ([STT], [NgayNghi], [MaNV], [LyDo], [Duyet]) VALUES (5, CAST(N'2025-04-02' AS Date), 16, N'Tui thich nghi do thi sao', 1)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (1, N'Công ty ABC', N'Hà Nội', 987123456)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (2, N'Công ty XYZ', N'TP HCM', 987654321)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (3, N'Công ty DEF', N'Đà Nẵng', 987654322)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (4, N'Công ty MNO', N'Hải Phòng', 987654323)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (5, N'Công ty PQR', N'Bình Dương', 987654324)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (6, N'Công ty STU', N'Quảng Ninh', 987654325)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (7, N'Công ty VWX', N'Nha Trang', 987654326)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (8, N'Công ty YZ', N'Cần Thơ', 987654327)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (9, N'Công ty JKL', N'Hà Nội', 987654328)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (10, N'Công ty GHI', N'TP HCM', 987654329)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (11, N'Công ty BNM', N'Bình Dương', 987654330)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (12, N'Công ty ZYX', N'Nha Trang', 987654331)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (13, N'Công ty TUV', N'Cần Thơ', 987654332)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (14, N'Công ty EFG', N'Hà Nội', 987654333)
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [DiaChi], [SDT]) VALUES (15, N'Công ty HIJ', N'TP HCM', 987654334)
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (1, 1, N'Nguyễn Văn A', CAST(N'1990-05-15' AS Date), N'Nam', N'912345678')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (2, 2, N'Trần Thị B', CAST(N'1992-08-20' AS Date), N'Nữ', N'913456789')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (3, 3, N'Phạm Văn C', CAST(N'1988-12-10' AS Date), N'Nam', N'914567890')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (4, 4, N'Vũ Thị D', CAST(N'1995-03-22' AS Date), N'Nữ', N'915678901')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (5, 1, N'Lê Văn E', CAST(N'1991-07-05' AS Date), N'Nam', N'916789012')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (6, 2, N'Hoàng Thị F', CAST(N'1993-11-18' AS Date), N'Nữ', N'917890123')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (7, 3, N'Đinh Văn G', CAST(N'1987-04-12' AS Date), N'Nữ', N'918901234')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (8, 4, N'Bùi Thị H', CAST(N'1994-09-27' AS Date), N'Nữ', N'919012345')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (9, 1, N'Ngô Văn I', CAST(N'1989-06-30' AS Date), N'Nam', N'920123456')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (10, 2, N'Phan Thị J', CAST(N'1991-02-16' AS Date), N'Nữ', N'921234567')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (11, 3, N'Tạ Văn K', CAST(N'1990-10-08' AS Date), N'Nam', N'922345678')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (12, 4, N'Lý Thị L', CAST(N'1995-01-25' AS Date), N'Nữ', N'923456789')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (13, 1, N'Đoàn Văn M', CAST(N'1988-11-03' AS Date), N'Nam', N'924567890')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (14, 2, N'Đặng Thị N', CAST(N'1993-05-19' AS Date), N'Nữ', N'925678901')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (15, 3, N'Vương Văn O', CAST(N'1992-07-22' AS Date), N'Nam', N'926789012')
INSERT [dbo].[NhanVien] ([MaNV], [MaCapBac], [HoTen], [NgaySinh], [GioiTinh], [SDT]) VALUES (16, 6, N'Mai cute', CAST(N'2004-10-09' AS Date), N'Nữ', N'0999888777')
GO
INSERT [dbo].[PhanQuyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (1, N'Qu?n lý', N'Quy?n qu?n lý h? th?ng')
INSERT [dbo].[PhanQuyen] ([MaQuyen], [TenQuyen], [MoTa]) VALUES (2, N'Nhân viên', N'Quy?n nhân viên bán hàng')
GO
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (1, 1, CAST(N'2025-01-01' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (2, 2, CAST(N'2025-01-02' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (3, 3, CAST(N'2025-01-03' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (4, 4, CAST(N'2025-01-04' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (5, 5, CAST(N'2025-01-05' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (6, 6, CAST(N'2025-01-06' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (7, 7, CAST(N'2025-01-07' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (8, 8, CAST(N'2025-01-08' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (9, 9, CAST(N'2025-01-09' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (10, 10, CAST(N'2025-01-10' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (11, 11, CAST(N'2025-01-11' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (12, 12, CAST(N'2025-01-12' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (13, 13, CAST(N'2025-01-13' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (14, 14, CAST(N'2025-01-14' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (15, 15, CAST(N'2025-01-15' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (16, 9, CAST(N'2025-01-04' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (17, 1, CAST(N'2025-03-25' AS Date))
INSERT [dbo].[PhieuNhap] ([MaPN], [MaNCC], [NgayNhap]) VALUES (18, 10, CAST(N'2025-01-06' AS Date))
GO
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (1, 1, N'admin', N'password123', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (2, 2, N'manager1', N'pass456', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (3, 3, N'staff1', N'staffpass', 2)
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (4, 4, N'staff3', N'staffpass', 2)
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (5, 5, N'staff2', N'staffpass', 2)
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (6, 6, N'hoangnguvkl', N'123', 2)
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (7, 8, N'hihi', N'123', 2)
INSERT [dbo].[TaiKhoan] ([TaiKhoanID], [MaNV], [TenDangNhap], [MatKhau], [MaQuyen]) VALUES (8, 16, N'maicute', N'maicute', 2)
GO
INSERT [dbo].[ThanhToan] ([MaTT], [MaDH], [HinhThucTT], [ThoiGian]) VALUES (1, 16, N'Ví điện tử', NULL)
GO
ALTER TABLE [dbo].[BangLuong]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[CTDH]  WITH CHECK ADD  CONSTRAINT [FK_CTDH_DonHang] FOREIGN KEY([MaDH])
REFERENCES [dbo].[DonHang] ([MaDH])
GO
ALTER TABLE [dbo].[CTDH] CHECK CONSTRAINT [FK_CTDH_DonHang]
GO
ALTER TABLE [dbo].[CTDH]  WITH CHECK ADD  CONSTRAINT [FK_CTDH_Kho] FOREIGN KEY([MaSP])
REFERENCES [dbo].[Kho] ([MaSP])
GO
ALTER TABLE [dbo].[CTDH] CHECK CONSTRAINT [FK_CTDH_Kho]
GO
ALTER TABLE [dbo].[CTPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuNhap_Kho] FOREIGN KEY([MaSP])
REFERENCES [dbo].[Kho] ([MaSP])
GO
ALTER TABLE [dbo].[CTPhieuNhap] CHECK CONSTRAINT [FK_CTPhieuNhap_Kho]
GO
ALTER TABLE [dbo].[CTPhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_CTPhieuNhap_PhieuNhap] FOREIGN KEY([MaPN])
REFERENCES [dbo].[PhieuNhap] ([MaPN])
GO
ALTER TABLE [dbo].[CTPhieuNhap] CHECK CONSTRAINT [FK_CTPhieuNhap_PhieuNhap]
GO
ALTER TABLE [dbo].[NgayNghi]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_CapBac] FOREIGN KEY([MaCapBac])
REFERENCES [dbo].[CapBac] ([MaCapBac])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_CapBac]
GO
ALTER TABLE [dbo].[PhieuNhap]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhap_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[PhieuNhap] CHECK CONSTRAINT [FK_PhieuNhap_NhaCungCap]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([MaQuyen])
REFERENCES [dbo].[PhanQuyen] ([MaQuyen])
GO
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhToan_DonHang] FOREIGN KEY([MaDH])
REFERENCES [dbo].[DonHang] ([MaDH])
GO
ALTER TABLE [dbo].[ThanhToan] CHECK CONSTRAINT [FK_ThanhToan_DonHang]
GO
USE [master]
GO
ALTER DATABASE [QLBANGIAY] SET  READ_WRITE 
GO
