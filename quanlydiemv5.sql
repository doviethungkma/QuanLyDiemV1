-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 09, 2017 at 06:32 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlydiemv5`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_account`
--

CREATE TABLE `tbl_account` (
  `ID` int(11) NOT NULL,
  `Username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateCreated` date NOT NULL,
  `PwdID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_account`
--

INSERT INTO `tbl_account` (`ID`, `Username`, `DateCreated`, `PwdID`) VALUES
(1, 'TrinhManhHa', '2017-09-06', 5),
(2, 'NguyenVanBinh', '2017-09-05', 2),
(3, 'NguyenTuanAnh', '2017-09-08', 3),
(4, 'DoVietHung', '2017-09-04', 4),
(5, 'NguyenCongThai', '2017-09-08', 6),
(32, 'VuThiVan', '2017-10-02', 38),
(33, 'HoangDucTho', '2017-10-02', 39),
(34, 'LaiMinhTuan', '2017-10-02', 40),
(35, 'TranAnhTu', '2017-10-02', 41),
(36, 'NguyenHoangThaiKiet', '2017-10-03', 42),
(37, 'adhjaaygjds', '2017-10-03', 43),
(38, 'adhjaaygjds', '2017-10-03', 44),
(39, 'aaaaaaaa', '2017-10-03', 45),
(40, 'fgkljhlfjghklfgj', '2017-10-03', 46);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_authorization`
--

CREATE TABLE `tbl_authorization` (
  `LoginID` int(11) NOT NULL,
  `RoleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_authorization`
--

INSERT INTO `tbl_authorization` (`LoginID`, `RoleID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 4),
(32, 3),
(34, 3),
(35, 3),
(36, 4),
(37, 4),
(39, 4),
(40, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_class`
--

CREATE TABLE `tbl_class` (
  `ID` int(11) NOT NULL,
  `ClassName` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Grade` int(11) NOT NULL,
  `Khoa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IDGVCN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_class`
--

INSERT INTO `tbl_class` (`ID`, `ClassName`, `Grade`, `Khoa`, `IDGVCN`) VALUES
(1, 'AT10A', 10, 'ATTT', 1),
(2, 'AT10C', 10, 'ATTT', 1),
(3, 'AT10B', 10, 'ATTT', 1),
(4, 'AT10D', 10, 'ATTT', 1),
(5, 'AT10E', 10, 'ATTT', 4),
(6, 'AT9C', 9, 'Công nghệ thông tin', 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_lecturer`
--

CREATE TABLE `tbl_lecturer` (
  `ID` int(11) NOT NULL,
  `LecturerName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Sex` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `Avatar` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LoginID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_lecturer`
--

INSERT INTO `tbl_lecturer` (`ID`, `LecturerName`, `DateOfBirth`, `Address`, `Sex`, `Avatar`, `LoginID`) VALUES
(1, 'Nguyễn Văn Bình', '2017-09-03', 'Chiến Thắng - Hà Nội', 'Nam', '/GVCN1', 2),
(2, 'Vũ Thị Vân', '1980-02-03', 'Hà Nội', 'Nữ', '/ac.jpg', 32),
(3, 'Trần Anh Tú', '1980-03-02', 'Hà Nội', 'Nam', 'sjdkajshj', 35),
(4, 'Ngủyễn Tuấn Anh', '2017-09-22', 'Hà Nội', 'Nam', 'giangvien.jpg', 3),
(5, 'Hoàng Đức Thọ', '2017-09-22', 'Hà Nội', 'Nam', 'giangvien.jpg', 33),
(6, 'Lại Minh Tuấn\r\n', '2017-09-22', 'Hà Nội', 'Nam', 'giangvien.jpg', 34);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_manager`
--

CREATE TABLE `tbl_manager` (
  `ID` int(11) NOT NULL,
  `ManagerName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Sex` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `Avatar` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LoginID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_mark`
--

CREATE TABLE `tbl_mark` (
  `ID` int(11) NOT NULL,
  `TeachID` int(11) NOT NULL,
  `LecturerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_mark`
--

INSERT INTO `tbl_mark` (`ID`, `TeachID`, `LecturerID`) VALUES
(12, 26, 4),
(25, 27, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_password`
--

CREATE TABLE `tbl_password` (
  `ID` int(11) NOT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateCreated` date NOT NULL,
  `SALT` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_password`
--

INSERT INTO `tbl_password` (`ID`, `Password`, `DateCreated`, `SALT`) VALUES
(1, '57FF7277B7996DD23AFA13B56A8729573C0DEC68F857BB0982ED3E64D44A515A', '2017-09-10', '17BADBDA2BA0116CCB1610A74A824E8787B643D66B34EEBF5AB2613BFA7CB5FD'),
(2, '1A7741D57E6AD45482847C134778C01BA5E48602396C447E73A8BD5267EC6CB9', '2017-09-10', 'E5C3D9904DA4A977FCC000F0FB862952D224AFFFA4A9BA8A5B1A8E1EB7AD07EB'),
(3, 'EAFAFCB5828217264842D53B5FFADB1AB9C0AB84AD50FB2C472FC69284D74CF4', '2017-09-10', '6C5B3DA48812E3E5AAB88DAE8D37A038D85F537DE44618535E4253E3BAFF3495'),
(4, '32204FE57FB5D157BF0B703A26631646C14594588505CE77A9A12BAF7FB5F606', '2017-09-10', 'DAAB135C7C6554B3328C31CADE1824E8FC453EAB715E1F700E07B788B022E6A5'),
(5, '32204FE57FB5D157BF0B703A26631646C14594588505CE77A9A12BAF7FB5F606', '2017-09-10', 'DAAB135C7C6554B3328C31CADE1824E8FC453EAB715E1F700E07B788B022E6A5'),
(6, '32204FE57FB5D157BF0B703A26631646C14594588505CE77A9A12BAF7FB5F606', '2017-09-10', 'DAAB135C7C6554B3328C31CADE1824E8FC453EAB715E1F700E07B788B022E6A5'),
(34, '2197CC8F2BA9865D77B42B179E0E6E6895F79D968F15F7C9D503A5A246E5A22B', '2017-09-23', '5D34D60E42A8FF3015D8FE671BF3922F0C0FB32E44C61E6E1795208E017C8CCA'),
(35, '427258987943854E00C6929C78120F20B127706F1058D83D9B01249C9306B18E', '2017-09-23', '695D6B8A61FCA598FB003E4BB402BB399A5AFB3452B41FBC7F6D958CC6778F0A'),
(36, '3C9B7ED28B6CD33268F20016AEB2A72835A51753909A5175F20E0156BCAE4B24', '2017-09-25', 'BC2C9C8E44092EEEEF723E352458939B5FD49D94B550438968AA1BD9666ACF01'),
(38, '57FF7277B7996DD23AFA13B56A8729573C0DEC68F857BB0982ED3E64D44A515A', '2017-09-10', '17BADBDA2BA0116CCB1610A74A824E8787B643D66B34EEBF5AB2613BFA7CB5FD'),
(39, '57FF7277B7996DD23AFA13B56A8729573C0DEC68F857BB0982ED3E64D44A515A', '2017-09-10', '17BADBDA2BA0116CCB1610A74A824E8787B643D66B34EEBF5AB2613BFA7CB5FD'),
(40, '57FF7277B7996DD23AFA13B56A8729573C0DEC68F857BB0982ED3E64D44A515A', '2017-09-10', '17BADBDA2BA0116CCB1610A74A824E8787B643D66B34EEBF5AB2613BFA7CB5FD'),
(41, '57FF7277B7996DD23AFA13B56A8729573C0DEC68F857BB0982ED3E64D44A515A', '2017-09-10', '17BADBDA2BA0116CCB1610A74A824E8787B643D66B34EEBF5AB2613BFA7CB5FD'),
(42, 'CDD581CEFE135FD0B6C0626C2F09BC9546663273F3CFAD3A0EEADAE04C410133', '2017-10-03', 'B19159436008A58F44590FEBFC1E3250244DE9A6D62D24FC978CEEFE88F50EE8'),
(43, '02B01848FF2F7907EDCE3F40D4DAC4E129035EAC491849275F62401469236F7C', '2017-10-03', '31A1B1C5146594DAA3164E51A0CA225685F6652EF35D95EDCF4FCB3F14D6FF2B'),
(44, 'E4080B01C169C40A9A2D93DA1DE839C9F964F8C5FCFCB25229613422DF9CB679', '2017-10-03', '2A592B7EBAC7D4FF72E960F42C83FC715765438EE0B5BBAA1BC361602864A442'),
(45, '03CE7D3D0CAF4664E6EAE7DD0C2BBF20047392CCCFF6A1B6EAF99E952FA41E5F', '2017-10-03', '44739D2616C4CD0CF90B47A573456E72BF6D17FEBA974E34B57EF42EA42B4F1B'),
(46, '38E70D6BECA8F1C32410E636B289070BFD4AD6A807BA634E8D4FD5BF7F0BB9B9', '2017-10-03', 'AD18428F96DC04C22FADD249C50B7BC6D2E299B9789B5F3507E11AA82683410A');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_result`
--

CREATE TABLE `tbl_result` (
  `TeachID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `Score1` int(11) NOT NULL,
  `Score2` int(11) NOT NULL,
  `Score3` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_result`
--

INSERT INTO `tbl_result` (`TeachID`, `StudentID`, `Score1`, `Score2`, `Score3`) VALUES
(26, 1, 7, 8, 8),
(26, 2, 6, 8, 6),
(30, 1, 7, 6, 9),
(34, 1, 7, 5, 7),
(35, 2, 6, 8, 6),
(38, 1, 6, 5, 7),
(42, 1, 6, 8, 6),
(43, 2, 6, 8, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_role`
--

CREATE TABLE `tbl_role` (
  `ID` int(11) NOT NULL,
  `RoleName` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_role`
--

INSERT INTO `tbl_role` (`ID`, `RoleName`) VALUES
(1, 'QuanLy'),
(2, 'GVCN'),
(3, 'GiangVien'),
(4, 'SinhVien');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_student`
--

CREATE TABLE `tbl_student` (
  `ID` int(11) NOT NULL,
  `StudentName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Sex` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `Avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ClassID` int(11) NOT NULL,
  `LoginID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_student`
--

INSERT INTO `tbl_student` (`ID`, `StudentName`, `DateOfBirth`, `Address`, `Sex`, `Avatar`, `ClassID`, `LoginID`) VALUES
(1, 'Đỗ Việt Hưng', '1995-05-18', 'TÔng Lạnh - Thuận Châu - Sơn La1', 'Nam', 'sjhd', 1, 4),
(2, 'Nguyen Cong Thai', '1995-12-12', 'Thai Binh', 'Nam', '/thai', 1, 5),
(3, 'Nguyễn Hoàng Thái Kiệt', '1994-02-12', 'Hà Nội', 'Nam', 'sjhd', 4, 36),
(6, 'Trương Ngọc Tuất', '1994-04-05', 'Thanh Hóa', 'Nam', 'sjhd', 4, 39),
(7, 'bdbdbdb', '1995-03-04', 'sdkasjdaj', 'Nam', 'sjhd', 1, 40);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_subject`
--

CREATE TABLE `tbl_subject` (
  `ID` int(11) NOT NULL,
  `SubjectName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NumOfCredit` int(11) NOT NULL,
  `Semester` int(11) NOT NULL,
  `Year` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_subject`
--

INSERT INTO `tbl_subject` (`ID`, `SubjectName`, `NumOfCredit`, `Semester`, `Year`) VALUES
(1, 'Xây dựng ứng dụng web an toàn', 3, 1, '2017-2018'),
(2, 'An toàn mạng máy tính', 3, 1, '2017-2018'),
(3, 'Mã độc', 3, 1, '2017-2018'),
(4, 'Mật mã ứng dụng trong an toàn thông tin\r\n', 3, 1, '2017-2018'),
(5, 'Kỹ thuật lập trình an toàn\r\n', 3, 1, '2017-2018'),
(6, 'Phát hiện lỗi và lỗ hổng bảo mật phần mềm\r\n\r\n', 3, 1, '2017-2018');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_teach`
--

CREATE TABLE `tbl_teach` (
  `ID` int(11) NOT NULL,
  `SubjectID` int(11) NOT NULL,
  `LecturerID` int(11) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tbl_teach`
--

INSERT INTO `tbl_teach` (`ID`, `SubjectID`, `LecturerID`, `Name`) VALUES
(26, 1, 2, 'L01'),
(27, 1, 2, 'L02'),
(28, 1, 3, 'L03'),
(29, 1, 3, 'L04'),
(30, 3, 3, 'L01'),
(31, 3, 3, 'L02'),
(32, 3, 5, 'L03'),
(33, 3, 5, 'L04'),
(34, 4, 5, 'L01'),
(35, 4, 5, 'L02'),
(36, 4, 4, 'L03'),
(37, 4, 4, 'L04'),
(38, 6, 4, 'L01'),
(39, 6, 4, 'L02'),
(40, 6, 6, 'L03'),
(41, 6, 6, 'L04'),
(42, 5, 6, 'L01'),
(43, 5, 2, 'L02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_account`
--
ALTER TABLE `tbl_account`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_account_password` (`PwdID`);

--
-- Indexes for table `tbl_authorization`
--
ALTER TABLE `tbl_authorization`
  ADD PRIMARY KEY (`LoginID`,`RoleID`),
  ADD KEY `fk_authorization_role` (`RoleID`);

--
-- Indexes for table `tbl_class`
--
ALTER TABLE `tbl_class`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_class_lecturer` (`IDGVCN`);

--
-- Indexes for table `tbl_lecturer`
--
ALTER TABLE `tbl_lecturer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_lecturer_account` (`LoginID`);

--
-- Indexes for table `tbl_manager`
--
ALTER TABLE `tbl_manager`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_manager_account` (`LoginID`);

--
-- Indexes for table `tbl_mark`
--
ALTER TABLE `tbl_mark`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_mark_teach` (`TeachID`),
  ADD KEY `fk_mark_Lecturer` (`LecturerID`);

--
-- Indexes for table `tbl_password`
--
ALTER TABLE `tbl_password`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbl_result`
--
ALTER TABLE `tbl_result`
  ADD PRIMARY KEY (`TeachID`,`StudentID`),
  ADD KEY `fk_result_student` (`StudentID`);

--
-- Indexes for table `tbl_role`
--
ALTER TABLE `tbl_role`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_student_account` (`LoginID`),
  ADD KEY `fk_student_class` (`ClassID`);

--
-- Indexes for table `tbl_subject`
--
ALTER TABLE `tbl_subject`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tbl_teach`
--
ALTER TABLE `tbl_teach`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_teach_subject` (`SubjectID`),
  ADD KEY `fk_teach_lecturer` (`LecturerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_account`
--
ALTER TABLE `tbl_account`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `tbl_class`
--
ALTER TABLE `tbl_class`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_lecturer`
--
ALTER TABLE `tbl_lecturer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_manager`
--
ALTER TABLE `tbl_manager`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbl_mark`
--
ALTER TABLE `tbl_mark`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `tbl_password`
--
ALTER TABLE `tbl_password`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT for table `tbl_role`
--
ALTER TABLE `tbl_role`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_student`
--
ALTER TABLE `tbl_student`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tbl_subject`
--
ALTER TABLE `tbl_subject`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tbl_teach`
--
ALTER TABLE `tbl_teach`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_account`
--
ALTER TABLE `tbl_account`
  ADD CONSTRAINT `fk_account_password` FOREIGN KEY (`PwdID`) REFERENCES `tbl_password` (`ID`);

--
-- Constraints for table `tbl_authorization`
--
ALTER TABLE `tbl_authorization`
  ADD CONSTRAINT `fk_authorization_account` FOREIGN KEY (`LoginID`) REFERENCES `tbl_account` (`ID`),
  ADD CONSTRAINT `fk_authorization_role` FOREIGN KEY (`RoleID`) REFERENCES `tbl_role` (`ID`);

--
-- Constraints for table `tbl_class`
--
ALTER TABLE `tbl_class`
  ADD CONSTRAINT `fk_class_lecturer` FOREIGN KEY (`IDGVCN`) REFERENCES `tbl_lecturer` (`ID`);

--
-- Constraints for table `tbl_lecturer`
--
ALTER TABLE `tbl_lecturer`
  ADD CONSTRAINT `fk_lecturer_account` FOREIGN KEY (`LoginID`) REFERENCES `tbl_account` (`ID`);

--
-- Constraints for table `tbl_manager`
--
ALTER TABLE `tbl_manager`
  ADD CONSTRAINT `fk_manager_account` FOREIGN KEY (`LoginID`) REFERENCES `tbl_account` (`ID`);

--
-- Constraints for table `tbl_mark`
--
ALTER TABLE `tbl_mark`
  ADD CONSTRAINT `fk_mark_Lecturer` FOREIGN KEY (`LecturerID`) REFERENCES `tbl_lecturer` (`ID`),
  ADD CONSTRAINT `fk_mark_teach` FOREIGN KEY (`TeachID`) REFERENCES `tbl_teach` (`ID`);

--
-- Constraints for table `tbl_result`
--
ALTER TABLE `tbl_result`
  ADD CONSTRAINT `fk_result_student` FOREIGN KEY (`StudentID`) REFERENCES `tbl_student` (`ID`),
  ADD CONSTRAINT `fk_result_teach` FOREIGN KEY (`TeachID`) REFERENCES `tbl_teach` (`ID`);

--
-- Constraints for table `tbl_student`
--
ALTER TABLE `tbl_student`
  ADD CONSTRAINT `fk_student_account` FOREIGN KEY (`LoginID`) REFERENCES `tbl_account` (`ID`),
  ADD CONSTRAINT `fk_student_class` FOREIGN KEY (`ClassID`) REFERENCES `tbl_class` (`ID`);

--
-- Constraints for table `tbl_teach`
--
ALTER TABLE `tbl_teach`
  ADD CONSTRAINT `fk_teach_lecturer` FOREIGN KEY (`LecturerID`) REFERENCES `tbl_lecturer` (`ID`),
  ADD CONSTRAINT `fk_teach_subject` FOREIGN KEY (`SubjectID`) REFERENCES `tbl_subject` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
