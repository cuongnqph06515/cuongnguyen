-- --------------------------------------------------------
-- Máy chủ:                      127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Phiên bản:           12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for emp-manager
CREATE DATABASE IF NOT EXISTS `emp-manager` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `emp-manager`;

-- Dumping structure for table emp-manager.chitietdathang
CREATE TABLE IF NOT EXISTS `chitietdathang` (
  `sohoadon` int(11) NOT NULL,
  `mahang` varchar(10) NOT NULL,
  `giaban` decimal(10,0) NOT NULL,
  `soluong` smallint(6) NOT NULL,
  `mucgiamgia` double NOT NULL,
  KEY `FK_chitietdathang_dondathang` (`sohoadon`),
  KEY `FK_chitietdathang_mathang` (`mahang`),
  CONSTRAINT `FK_chitietdathang_dondathang` FOREIGN KEY (`sohoadon`) REFERENCES `dondathang` (`sohoadon`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_chitietdathang_mathang` FOREIGN KEY (`mahang`) REFERENCES `mathang` (`mahang`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table emp-manager.chitietdathang: ~8 rows (approximately)
INSERT INTO `chitietdathang` (`sohoadon`, `mahang`, `giaban`, `soluong`, `mucgiamgia`) VALUES
	(5, '1', 8989, 121, 0),
	(4, '2', 8989, 9, 0),
	(5, '5', 8989, 9, 0),
	(3, '2', 777, 28, 30),
	(2, '2', 44, 4, 43),
	(8, '7', 44, 4, 43),
	(8, '5', 44, 4, 43),
	(9, '5', 44, 4, 43),
	(9, '1', 44, 123, 43),
	(6, '1', 44, 50, 43);

-- Dumping structure for table emp-manager.dondathang
CREATE TABLE IF NOT EXISTS `dondathang` (
  `sohoadon` int(11) NOT NULL,
  `makhachhang` varchar(10) DEFAULT NULL,
  `manhanvien` varchar(10) DEFAULT NULL,
  `ngaydathang` datetime DEFAULT NULL,
  `ngaygiaohang` datetime DEFAULT NULL,
  `ngaychuyenhang` datetime DEFAULT NULL,
  `noigiaohang` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sohoadon`),
  KEY `FK_dondathang_khachhang` (`makhachhang`),
  KEY `FK_dondathang_nhanvien` (`manhanvien`),
  CONSTRAINT `FK_dondathang_khachhang` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`makhachhang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_dondathang_nhanvien` FOREIGN KEY (`manhanvien`) REFERENCES `nhanvien` (`manhanvien`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table emp-manager.dondathang: ~9 rows (approximately)
INSERT INTO `dondathang` (`sohoadon`, `makhachhang`, `manhanvien`, `ngaydathang`, `ngaygiaohang`, `ngaychuyenhang`, `noigiaohang`) VALUES
	(1, '1', '1', '2003-12-16 15:58:47', '2022-12-16 15:58:48', '2022-12-16 15:58:48', 'ham nghi'),
	(2, '2', '1', '2003-12-16 15:58:47', '2022-12-16 15:58:48', '2022-12-16 15:58:48', 'ham nghi'),
	(3, '3', '1', '2003-12-16 15:58:47', '2022-12-16 15:58:48', '2022-12-16 15:58:48', 'ham nghi'),
	(4, '1', '2', '2003-12-16 15:58:47', '2022-12-16 15:58:48', '2022-12-16 15:58:48', 'ham nghi'),
	(5, '2', '3', '2003-12-16 15:58:47', '2022-12-16 15:58:48', '0000-00-00 00:00:00', 'ham nghi'),
	(6, '2', '3', '2003-12-18 15:07:31', '2022-12-18 15:07:33', '2022-12-18 15:07:31', ''),
	(7, '2', '5', '2003-12-18 15:20:45', '2022-12-18 15:20:46', '2022-12-18 15:20:47', 'ho tung mau'),
	(8, '4', '5', '2003-11-18 15:20:45', '2022-12-18 15:20:46', '2022-12-18 15:20:47', 'ho tung mau'),
	(9, '4', '5', '2003-11-18 15:20:45', '2022-12-18 15:20:46', '2022-12-18 15:20:47', 'ho tung mau');

-- Dumping structure for table emp-manager.khachhang
CREATE TABLE IF NOT EXISTS `khachhang` (
  `makhachhang` varchar(10) NOT NULL,
  `tencongty` varchar(50) NOT NULL,
  `tengiaodich` varchar(30) NOT NULL,
  `diachi` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `dienthoai` varchar(15) DEFAULT NULL,
  `fax` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`makhachhang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table emp-manager.khachhang: ~4 rows (approximately)
INSERT INTO `khachhang` (`makhachhang`, `tencongty`, `tengiaodich`, `diachi`, `email`, `dienthoai`, `fax`) VALUES
	('1', 'cong ty khach hang 1', 'khachhang1', 'ham nghi', 'kh@gmail.com', '0992172636', '32rtwvhvb'),
	('2', 'cong ty khach hang 2', 'khachhang2', 'ho tung mau', 'kh@gmail.com', '0992172636', '32rtwvhvb'),
	('3', 'cong ty khach hang 3', 'khachhang3', 'ham nghi', 'kh@gmail.com', '0992172636', '32rtwvhvb'),
	('4', 'cong ty khach hang 4', 'khachhang4', 'ho tung mau', 'kh@gmail.com', '0992172636', '32rtwvhvb'),
	('5', 'cong ty 4', 'khachhang5', 'ham nghi', 'cuong@gmail.com', '099833722', 'đsvsdvsdvds');

-- Dumping structure for table emp-manager.loaihang
CREATE TABLE IF NOT EXISTS `loaihang` (
  `maloaihang` int(11) NOT NULL,
  `tenloaihang` varchar(15) NOT NULL,
  PRIMARY KEY (`maloaihang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table emp-manager.loaihang: ~14 rows (approximately)
INSERT INTO `loaihang` (`maloaihang`, `tenloaihang`) VALUES
	(1, 'cuongnguyen'),
	(2, 'loai hang 2'),
	(3, 'loai hang 3'),
	(4, 'loai hang 4'),
	(6, 'cuongnguyen7'),
	(7, 'ten loai hang'),
	(34, 'csacsa '),
	(78, '78'),
	(90, 'tenloaihang'),
	(91, 'csacsa '),
	(298, 'csacsa '),
	(915, 'reveve'),
	(2398, 'csacsa ');

-- Dumping structure for table emp-manager.mathang
CREATE TABLE IF NOT EXISTS `mathang` (
  `mahang` varchar(10) NOT NULL,
  `tenhang` varchar(50) NOT NULL,
  `macongty` varchar(10) DEFAULT NULL,
  `maloaihang` int(11) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `donvitinh` varchar(20) DEFAULT NULL,
  `giahang` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`mahang`),
  KEY `FK_mathang_nhacungcap` (`macongty`),
  KEY `FK_mathang_loaihang` (`maloaihang`),
  CONSTRAINT `FK_mathang_loaihang` FOREIGN KEY (`maloaihang`) REFERENCES `loaihang` (`maloaihang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_mathang_nhacungcap` FOREIGN KEY (`macongty`) REFERENCES `nhacungcap` (`macongty`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table emp-manager.mathang: ~8 rows (approximately)
INSERT INTO `mathang` (`mahang`, `tenhang`, `macongty`, `maloaihang`, `soluong`, `donvitinh`, `giahang`) VALUES
	('1', 'san pham 1', '1', 1, 754, 'chiec', 100),
	('2', 'san pham 5', '2', 2, 14, 'chiec', 100),
	('34', 'san pham 2', '1', 1, 10, 'tập', 100000),
	('4', 'san pham 7', '2', 1, 7, 'chiec', 100),
	('5', 'san pham 8', '3', 1, 115, 'chiec', 100),
	('6', 'san pham 9', '3', 3, 67, 'chiec', 100),
	('7', 'san pham 3', '1', 1, 45, 'chiec', 100),
	('9', 'san pham 4', '1', 3, 232, 'chiec', 100);

-- Dumping structure for table emp-manager.nhacungcap
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `macongty` varchar(10) NOT NULL,
  `tencongty` varchar(40) NOT NULL,
  `tengiaodich` varchar(30) DEFAULT NULL,
  `diachi` varchar(60) DEFAULT NULL,
  `dienthoai` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`macongty`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table emp-manager.nhacungcap: ~4 rows (approximately)
INSERT INTO `nhacungcap` (`macongty`, `tencongty`, `tengiaodich`, `diachi`, `dienthoai`, `fax`, `email`) VALUES
	('1', 'cong ty 1', 'khachhang1', 'ham nghi', '099833722', 'đsvsdvsdvds', 'cuong@gmail.com'),
	('2', 'cong ty 2', 'khachhang2', 'ham nghi', '099833722', 'đsvsdvsdvds', 'cuong@gmail.com'),
	('3', 'cong ty 3', 'khachhang3', 'ham nghi', '099833722', 'đsvsdvsdvds', 'cuong@gmail.com'),
	('4', 'cong ty 4', 'khachhang5', 'ham nghi', '099833722', 'đsvsdvsdvds', 'cuong@gmail.com');

-- Dumping structure for table emp-manager.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manhanvien` varchar(10) NOT NULL,
  `ho` varchar(20) NOT NULL,
  `ten` varchar(10) NOT NULL,
  `ngaysinh` datetime DEFAULT NULL,
  `ngaylamviec` datetime DEFAULT NULL,
  `diachi` varchar(50) DEFAULT NULL,
  `dienthoai` varchar(15) DEFAULT NULL,
  `luongcoban` decimal(10,0) DEFAULT NULL,
  `phucap` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`manhanvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table emp-manager.nhanvien: ~7 rows (approximately)
INSERT INTO `nhanvien` (`manhanvien`, `ho`, `ten`, `ngaysinh`, `ngaylamviec`, `diachi`, `dienthoai`, `luongcoban`, `phucap`) VALUES
	('1', 'nguyen', 'cuong', '2022-12-16 15:51:48', '2022-12-16 15:51:50', 'ham nghi', '0938373262', 10000000, 1000),
	('2', 'nguyen', 'hoang', '2022-12-16 15:51:48', '2022-12-16 15:51:50', 'ham nghi', '0938373262', 9000000, 1000),
	('3', 'nguyen', 'hue', '2022-12-16 15:51:48', '2022-12-16 15:51:50', 'ham nghi', '0938373262', 9000000, 1000),
	('4', 'nguyen', 'nam', '2022-12-16 15:51:48', '2022-12-16 15:51:50', 'ham nghi', '0938373262', 9000000, 1000),
	('5', 'nguyen', 'thang', '2022-12-16 15:51:48', '2022-12-16 15:51:50', 'ham nghi', '0938373262', 9000000, 1000),
	('6', 'nguyen', 'kien', '2022-12-16 15:51:48', '2022-12-16 15:51:50', 'ham nghi', '0938373262', 9000000, 1000),
	('7', 'nguyen', 'ha', '2022-12-16 15:51:48', '2022-12-16 15:51:50', 'ham nghi', '0938373262', 9000000, 1000);

-- Dumping structure for procedure emp-manager.proc_cau2
DELIMITER //
CREATE PROCEDURE `proc_cau2`(IN imahang VARCHAR(10))
BEGIN
	SELECT mahang, SUM(soluong) AS tongsoban FROM chitietdathang WHERE mahang=imahang;
END//
DELIMITER ;

-- Dumping structure for procedure emp-manager.proc_insert
DELIMITER //
CREATE PROCEDURE `proc_insert`(IN imahang VARCHAR(10), 
										IN itenhang VARCHAR(50), 
										IN imacongty VARCHAR(10), 
										IN imaloaihang INT(11),
										IN isoluong INT(11), 
										IN idonvitinh VARCHAR(20), 
										IN igiahang DECIMAL(10,0),
										OUT message VARCHAR(50))
BEGIN

	DECLARE pk_mahang varchar(50) DEFAULT null;
	DECLARE fk_macongty varchar(50) DEFAULT null;
	DECLARE fk_maloaihang int(50) DEFAULT -1;
	SELECT mahang INTO pk_mahang FROM mathang WHERE mahang=imahang;
	SELECT macongty INTO fk_macongty FROM nhacungcap WHERE macongty=imacongty;
	SELECT maloaihang INTO fk_maloaihang FROM loaihang WHERE maloaihang=imaloaihang;
   
   IF(pk_mahang IS NOT NULL) THEN
   	SET message = "Ma hang da ton tai";

   ELSEIF(fk_macongty IS NULL) THEN
   	SET message = "Ma cong ty khong ton tai";

   ELSEIF(fk_maloaihang <=0) THEN
   	SET message = "Ma loai hang khong ton tai";

   ELSE
   	INSERT INTO mathang VALUES (imahang, itenhang, imacongty, imaloaihang, isoluong, idonvitinh, igiahang);
   	SET message = "Insert thanh cong";
   END if;
END//
DELIMITER ;

-- Dumping structure for trigger emp-manager.trigger_cau3_insert
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER trigger_cau3_insert
BEFORE INSERT ON chitietdathang
FOR EACH ROW
BEGIN 
	DECLARE hanghienco INT;
	SELECT soluong INTO hanghienco FROM mathang WHERE mahang = NEW.mahang;
	
	if(NEW.soluong < hanghienco AND NEW.soluong >=1) THEN
		UPDATE mathang
		SET soluong = hanghienco-NEW.soluong
		WHERE mahang = NEW.mahang;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'So luong hang ban ra khong phu hop';
	END if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger emp-manager.trigger_cau4
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER trigger_cau4
BEFORE INSERT ON chitietdathang
FOR EACH ROW
BEGIN
	DECLARE root_cost INT;
	SELECT giahang INTO root_cost FROM mathang WHERE mahang = NEW.mahang;
	IF(NEW.GIABAN <=0) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Gia ban phai lon hon 0';
	ELSEIF(NEW.giaban > root_cost) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Gia ban ra khong phu hop';
	END if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
