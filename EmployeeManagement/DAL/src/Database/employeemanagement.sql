-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 17, 2017 lúc 02:22 AM
-- Phiên bản máy phục vụ: 10.1.28-MariaDB
-- Phiên bản PHP: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `employeemanagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

CREATE TABLE `chucvu` (
  `MACHUCVU` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TENCHUCVU` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chucvu`
--

INSERT INTO `chucvu` (`MACHUCVU`, `TENCHUCVU`) VALUES
('CV001', 'Nhân viên Kế Toán'),
('CV002', 'Nhân viên IT'),
('CV003', 'Trưởng Phòng'),
('CV004', 'Nhân viên Bảo Vệ'),
('CV005', 'Nhân viên Kinh Doanh'),
('CV006', 'Nhân viên Lao Công'),
('CV007', 'Thư Ký');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lamviec`
--

CREATE TABLE `lamviec` (
  `MANHANVIEN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `THANG` int(11) DEFAULT NULL,
  `NAM` int(11) DEFAULT NULL,
  `SONGAYNGHI` int(11) DEFAULT NULL,
  `SONGAYDITRE` int(11) DEFAULT NULL,
  `GHICHU` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lamviec`
--

INSERT INTO `lamviec` (`MANHANVIEN`, `THANG`, `NAM`, `SONGAYNGHI`, `SONGAYDITRE`, `GHICHU`) VALUES
('NV000005', 9, 2017, 2, 1, NULL),
('NV000005', 10, 2017, 1, 1, NULL),
('NV000005', 8, 2017, 0, 1, NULL),
('NV000005', 7, 2017, 3, 0, NULL),
('NV000006', 8, 2017, 0, 1, NULL),
('NV000006', 7, 2017, 1, 0, NULL),
('NV000006', 9, 2017, 0, 0, NULL),
('NV000006', 10, 2017, 1, 0, NULL),
('NV000006', 6, 2017, 0, 1, NULL),
('NV000006', 5, 2017, 0, 2, NULL),
('NV000007', 8, 2017, 0, 1, NULL),
('NV000007', 7, 2017, 1, 0, NULL),
('NV000007', 9, 2017, 0, 0, NULL),
('NV000007', 10, 2017, 1, 0, NULL),
('NV000007', 6, 2017, 0, 1, NULL),
('NV000007', 5, 2017, 0, 2, NULL),
('NV000008', 8, 2017, 0, 1, NULL),
('NV000008', 7, 2017, 1, 0, NULL),
('NV000008', 9, 2017, 0, 0, NULL),
('NV000008', 10, 2017, 1, 0, NULL),
('NV000008', 6, 2017, 0, 1, NULL),
('NV000008', 5, 2017, 0, 2, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `luong`
--

CREATE TABLE `luong` (
  `BACLUONG` int(11) NOT NULL,
  `LUONGCB` float NOT NULL,
  `HSLUONG` float NOT NULL,
  `HSPC` float NOT NULL,
  `PHUCAP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `luong`
--

INSERT INTO `luong` (`BACLUONG`, `LUONGCB`, `HSLUONG`, `HSPC`, `PHUCAP`) VALUES
(1, 300000, 2.3, 0.4, 500000),
(2, 5000000, 2, 0.2, 1000000),
(3, 10000000, 2.9, 0.7, 1000000),
(4, 20000000, 3.5, 0.8, 2000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANHANVIEN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HOTEN` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `GIOITINH` int(1) NOT NULL,
  `NGAYSINH` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHI` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `QUEQUAN` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `SOTAIKHOAN` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SODIENTHOAI` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYVAOLAM` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ISDELETE` int(1) NOT NULL,
  `GHICHU` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `MAPHONGBAN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MACHUCVU` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `BACLUONG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANHANVIEN`, `HOTEN`, `GIOITINH`, `NGAYSINH`, `CMND`, `DIACHI`, `QUEQUAN`, `SOTAIKHOAN`, `SODIENTHOAI`, `NGAYVAOLAM`, `ISDELETE`, `GHICHU`, `MAPHONGBAN`, `MACHUCVU`, `BACLUONG`) VALUES
('NV000005', 'Nguyên Phạm Hoài', 1, '17/10/1996', '221420525', '', 'Bình D??ng', '2211 3456 44562', '0988588xxx', '15/11/2017', 0, '', 'PB002', 'CV002', 4),
('NV000006', 'Nguyen Van Tai 1', 0, '30/10/2017', '221420525', '??a ch? ', 'Bình D??ng', '2211 3456 44562', '0988588xxx', '06/11/2017', 0, 'Ghi chú', 'PB001', 'CV003', 2),
('NV000007', 'Nguyen Van B', 1, '16/11/2017', '221420525', '', 'Bình D??ng', '2211 3456 44562', '0988588xxx', '16/11/2017', 0, '', 'PB002', 'CV001', 3),
('NV000008', 'Tran Van C', 0, '16/11/2017', '221420525', '', 'Bình D??ng', '2211 3456 44562', '0988588xxx', '16/11/2017', 0, '', 'PB005', 'CV007', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongban`
--

CREATE TABLE `phongban` (
  `MAPHONGBAN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TENPHONGBAN` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phongban`
--

INSERT INTO `phongban` (`MAPHONGBAN`, `TENPHONGBAN`, `SDT`) VALUES
('PB001', 'Phòng Kế Toán', '0865623613'),
('PB002', 'Phòng Nhân Sự', '0838456234'),
('PB003', 'Phòng Kinh Doanh', '083123321'),
('PB004', 'Phòng Cơ Sở Vật Chất', '083738973'),
('PB005', 'Phòng Hỗ Trợ', '0822368721');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`MACHUCVU`);

--
-- Chỉ mục cho bảng `lamviec`
--
ALTER TABLE `lamviec`
  ADD KEY `MANHANVIEN` (`MANHANVIEN`);

--
-- Chỉ mục cho bảng `luong`
--
ALTER TABLE `luong`
  ADD PRIMARY KEY (`BACLUONG`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANHANVIEN`),
  ADD KEY `BACLUONG` (`BACLUONG`),
  ADD KEY `MACHUCVU` (`MACHUCVU`),
  ADD KEY `MAPHONGBAN` (`MAPHONGBAN`);

--
-- Chỉ mục cho bảng `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`MAPHONGBAN`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `lamviec`
--
ALTER TABLE `lamviec`
  ADD CONSTRAINT `lamviec_ibfk_1` FOREIGN KEY (`MANHANVIEN`) REFERENCES `nhanvien` (`MANHANVIEN`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`BACLUONG`) REFERENCES `luong` (`BACLUONG`),
  ADD CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`MACHUCVU`) REFERENCES `chucvu` (`MACHUCVU`),
  ADD CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`MAPHONGBAN`) REFERENCES `phongban` (`MAPHONGBAN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
