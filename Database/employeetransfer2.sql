-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 26, 2024 at 06:01 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employeetransfer2`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, 'Department 1'),
(2, 'Department 2'),
(3, 'Department 3');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `roleId` int(11) NOT NULL,
  `securityCode` int(11) NOT NULL,
  `currentProject` int(11) NOT NULL,
  `currentDepartment` int(11) NOT NULL,
  `currentLocation` int(11) NOT NULL,
  `joiningDate` date NOT NULL,
  `managerId` int(11) DEFAULT NULL,
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `email`, `username`, `password`, `roleId`, `securityCode`, `currentProject`, `currentDepartment`, `currentLocation`, `joiningDate`, `managerId`, `status`) VALUES
(32, 'Huy Minh Ly', 'huyminh1593572846@gmail.com', 'huyminh2001', '$2a$10$SNxBTjtNVQKCVrGNe28YVe7JAy4RJzb2NPB3tuu4jkF1NWX/TQXy.', 1, 8815, 3, 3, 7, '2024-09-28', NULL, 1),
(39, 'Huy Man', 'huyman159@gmail.com', 'huyman1204', '$2a$10$aNjVetK7gs6Gjubx4st26eXcqprPUktq0D3WKfZ6nN22uj5.UNGeW', 2, 5380, 3, 3, 8, '2024-09-07', 42, 1),
(41, 'Huy Tran', 'bzdfzbdfz@gmail.com', 'bgfbdf', '1225262', 2, 5634, 2, 1, 7, '2024-08-16', 32, 1),
(42, 'Hoang Mi', 'hoangmi123@gmail.com', 'hoangmi123', '$2a$10$uFbVhpBpQlam3kyWKFrXD.xIx22.R56YUaIJHOsG5jZEx.tdH9sOS', 2, 5538, 1, 2, 5, '2024-09-07', 32, 1),
(43, 'Huy Loc', 'huyloc123@gmail.com', 'huyloc123', '$2a$10$iHnMCDw.PZbTj5RaQ80Xcuj4otkmqoS5gfm2ouLWgtxHZdGrDMzEW', 2, 4819, 2, 2, 5, '2024-09-15', 42, 1),
(44, 'huy', 'huy123@gmail.com', 'huy123', '$2a$10$t6fjnWFVSzeC42QvN/V8EeQxN5V5ZRY3ezcTwSVqcmcwex.1V4IMq', 2, 4534, 3, 1, 4, '2024-09-06', 32, 1),
(45, 'Hoang Thu', 'thuhoang123@gmail.com', 'thuhoang123', '$2a$10$G6BC6i1TKSC6SvijhekhzeQFBYoZx1FunEkKmYD77SKBvVsVoKcZy', 2, 7535, 1, 1, 4, '2024-09-18', 32, 1),
(46, 'Huy Toan', 'toanhuy123@gmail.com', 'huytoan123', '$2a$10$7VhPub0eX8aLQQhvc75jY.7syB2qB1XtKUJyTgKvUH6L8ZIczQcxG', 2, 9081, 1, 1, 4, '2024-09-19', 32, 1),
(47, 'Quoc Toan', 'toanquoc123@gmail.com', 'quoctoan123', '$2a$10$wHBfKmht2j5Wtdz1asX1G.bGYDdJlWhyIB1rLYBKgC6af1fQIdZOm', 2, 2424, 1, 1, 4, '2024-09-19', 32, 1),
(48, 'Lin Lin', 'linlin123@gmail.com', 'linlin123', '$2a$10$fKGdx6ppFbGDevLW/mzq.Ow6vojm0poOY2L8aLsuMkjVFdXg3h46y', 1, 5264, 1, 1, 4, '2024-09-19', 42, 1),
(49, 'Mei Mei', 'meimei123@gmail.com', 'meimei123', '$2a$10$eUmvu7T7ZLYB2jFybBpT2uit2xercppuQDvffRRVnkw8h/AwC1egq', 1, 2226, 1, 1, 4, '2024-09-19', 42, 1),
(50, 'Joseph Karkroski', 'joseph123@gmail.com', 'joseph123', '$2a$10$9JsviyX/RxbDFm0nlCBJo.FvtSUO31WDzn/GUOnUxeX9v7CqqwvsG', 1, 2791, 1, 1, 4, '2024-09-19', 32, 1),
(51, 'Thuy Linh', 'thuylinh123@gmail.com', 'thuylinh123', '$2a$10$PWi77Uaf5K6/KSf.3pykjeEh/p1ZsMq.xbKYX28/cCmfkiIZl0Af2', 1, 1528, 1, 1, 6, '2024-09-19', 42, 1),
(52, 'jki', 'jki@gmail.com', 'jki123', '$2a$10$3dgSbVC91yPsIPo2cskDm.XwAxpdAu7nlRNFsm4iyPWr6kDvwLxYq', 2, 3624, 1, 1, 4, '2024-09-22', NULL, 1),
(54, 'Kan Chou', 'kanchou123@gmail.com', 'kanchou123', '$2a$10$43pXyTlfBdZfzohAGZb70.uL6r/MACdJtrlD1BTqFcrcmMP7Lt0z2', 1, 6737, 1, 1, 4, '2024-09-26', 32, 1);

-- --------------------------------------------------------

--
-- Table structure for table `letter`
--

CREATE TABLE `letter` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `recordId` int(11) NOT NULL,
  `content` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `allowances` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `name`, `allowances`) VALUES
(4, 'Location 1', 0.1),
(5, 'Location 2', 0.2),
(6, 'Location 3', 0.3),
(7, 'Location 4', 0.2),
(8, 'Location 5 ', 0.3),
(9, 'Location 6', 0.1);

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id`, `name`) VALUES
(1, 'Project 1'),
(2, 'Project 2'),
(3, 'Project 3');

-- --------------------------------------------------------

--
-- Table structure for table `record`
--

CREATE TABLE `record` (
  `id` int(11) NOT NULL,
  `employeeId` int(11) NOT NULL,
  `requestFor` int(11) NOT NULL,
  `locationFrom` int(11) DEFAULT NULL,
  `locationTo` int(11) DEFAULT NULL,
  `projectFrom` int(11) DEFAULT NULL,
  `projectTo` int(11) DEFAULT NULL,
  `departmentFrom` int(11) DEFAULT NULL,
  `departmentTo` int(11) DEFAULT NULL,
  `transferRelievingDate` date DEFAULT NULL,
  `transferJoiningDate` date NOT NULL,
  `createdDate` date NOT NULL,
  `status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `record`
--

INSERT INTO `record` (`id`, `employeeId`, `requestFor`, `locationFrom`, `locationTo`, `projectFrom`, `projectTo`, `departmentFrom`, `departmentTo`, `transferRelievingDate`, `transferJoiningDate`, `createdDate`, `status`) VALUES
(3, 42, 42, NULL, NULL, 1, 3, NULL, NULL, '2024-09-05', '2024-09-07', '2024-09-13', 1),
(4, 42, 42, NULL, NULL, NULL, NULL, 1, 3, '2024-09-05', '2024-09-08', '2024-09-13', 1),
(5, 42, 42, 4, 7, NULL, NULL, NULL, NULL, '2024-09-05', '2024-09-08', '2024-09-14', 2),
(6, 42, 43, NULL, NULL, 1, 2, NULL, NULL, '2024-09-05', '2024-09-15', '2024-09-24', 1),
(7, 44, 44, NULL, NULL, 1, 3, NULL, NULL, '2024-09-03', '2024-09-06', '2024-09-19', 2),
(8, 32, 42, NULL, NULL, 2, 1, NULL, NULL, '2024-09-04', '2024-09-07', '2024-09-25', 1),
(9, 32, 39, NULL, NULL, NULL, NULL, 1, 3, '2024-09-19', '2024-09-15', '2024-09-21', 1),
(10, 32, 39, 4, 6, NULL, NULL, NULL, NULL, '2024-09-04', '2024-09-07', '2024-09-24', 1),
(11, 32, 44, NULL, NULL, 2, 2, NULL, NULL, '2024-09-06', '2024-09-08', '2024-09-13', 0),
(12, 32, 32, NULL, NULL, NULL, NULL, 1, 3, '2024-09-07', '2024-09-08', '2024-09-22', 1),
(13, 32, 32, NULL, NULL, NULL, NULL, 1, 3, '2024-09-06', '2024-09-08', '2024-09-22', 2),
(14, 32, 39, 4, 9, NULL, NULL, NULL, NULL, '2024-09-11', '2024-09-15', '2024-09-22', 1),
(16, 32, 51, NULL, 6, NULL, 1, NULL, 1, NULL, '2024-09-19', '2024-09-19', 1),
(17, 32, 32, NULL, NULL, 2, 1, NULL, NULL, '2024-09-22', '2024-09-24', '2024-09-22', 1),
(18, 32, 52, NULL, 4, NULL, 1, NULL, 1, NULL, '2024-09-22', '2024-09-22', 1),
(21, 32, 32, NULL, NULL, 2, 3, NULL, NULL, '2024-09-23', '2024-09-24', '2024-09-22', 1),
(22, 32, 32, NULL, NULL, 3, 2, NULL, NULL, '2024-09-25', '2024-09-26', '2024-09-26', 1),
(23, 32, 32, NULL, NULL, NULL, NULL, 3, 1, '2024-09-25', '2024-09-26', '2024-09-26', 2),
(24, 32, 32, 4, 5, NULL, NULL, NULL, NULL, '2024-09-24', '2024-09-26', '2024-09-24', 1),
(25, 32, 32, 4, 5, NULL, NULL, NULL, NULL, '2024-09-25', '2024-09-27', '2024-09-26', 1),
(26, 42, 42, NULL, NULL, 1, 2, NULL, NULL, '2024-09-26', '2024-09-27', '2024-09-25', 0),
(27, 32, 32, NULL, NULL, NULL, NULL, 3, 2, '2024-09-26', '2024-09-28', '2024-09-26', 1),
(28, 32, 32, NULL, NULL, 2, 1, NULL, NULL, '2024-09-30', '2024-10-01', '2024-09-26', 1),
(29, 32, 32, NULL, NULL, NULL, NULL, 2, 1, '2024-09-27', '2024-09-30', '2024-09-26', 1),
(30, 32, 32, NULL, NULL, NULL, NULL, 1, 3, '2024-09-30', '2024-09-30', '2024-09-26', 1),
(31, 32, 32, NULL, NULL, 1, 3, NULL, NULL, '2024-09-28', '2024-09-28', '2024-09-26', 1),
(32, 32, 32, 4, 8, NULL, NULL, NULL, NULL, '2024-09-27', '2024-09-28', '2024-09-26', 1),
(33, 32, 32, 8, 7, NULL, NULL, NULL, NULL, '2024-09-27', '2024-09-28', '2024-09-26', 1),
(34, 44, 44, NULL, NULL, NULL, NULL, 1, 3, '2024-09-27', '2024-09-28', '2024-09-26', 0),
(35, 42, 39, NULL, NULL, 1, 2, NULL, NULL, '2024-09-27', '2024-09-28', '2024-09-26', 0),
(36, 32, 32, 7, 9, NULL, NULL, NULL, NULL, '2024-10-01', '2024-10-04', '2024-09-26', 2),
(37, 32, 32, 7, 4, NULL, NULL, NULL, NULL, '2024-09-28', '2024-09-30', '2024-09-26', 2),
(38, 32, 32, 7, 4, NULL, NULL, NULL, NULL, '2024-09-28', '2024-09-30', '2024-09-26', 2),
(40, 32, 54, NULL, 4, NULL, 1, NULL, 1, NULL, '2024-09-26', '2024-09-26', 1),
(41, 32, 32, 7, 4, NULL, NULL, NULL, NULL, '2024-09-26', '2024-09-29', '2024-09-26', 2),
(42, 32, 32, 7, 4, NULL, NULL, NULL, NULL, '2024-09-26', '2024-09-29', '2024-09-26', 2),
(43, 32, 32, 7, 4, NULL, NULL, NULL, NULL, '2024-09-26', '2024-09-29', '2024-09-26', 2),
(44, 32, 32, 7, 4, NULL, NULL, NULL, NULL, '2024-09-27', '2024-09-28', '2024-09-26', 0);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `employeeId` int(11) NOT NULL,
  `recordId` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  `reportDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'Admin'),
(2, 'Employee');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `currentProject` (`currentProject`),
  ADD KEY `currentDepartment` (`currentDepartment`),
  ADD KEY `currentLocation` (`currentLocation`),
  ADD KEY `roleId` (`roleId`),
  ADD KEY `employee_ibfk_7` (`managerId`);

--
-- Indexes for table `letter`
--
ALTER TABLE `letter`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `transferRecordId` (`recordId`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employeeId` (`employeeId`),
  ADD KEY `locationFrom` (`locationFrom`),
  ADD KEY `locationTo` (`locationTo`),
  ADD KEY `departmentFrom` (`departmentFrom`),
  ADD KEY `departmentTo` (`departmentTo`),
  ADD KEY `projectFrom` (`projectFrom`),
  ADD KEY `projectTo` (`projectTo`),
  ADD KEY `requestFor` (`requestFor`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employeeId` (`employeeId`),
  ADD KEY `transferRecordId` (`recordId`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `letter`
--
ALTER TABLE `letter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `record`
--
ALTER TABLE `record`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_4` FOREIGN KEY (`currentProject`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `employee_ibfk_5` FOREIGN KEY (`currentDepartment`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `employee_ibfk_6` FOREIGN KEY (`currentLocation`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `employee_ibfk_7` FOREIGN KEY (`managerId`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `employee_ibfk_8` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`);

--
-- Constraints for table `letter`
--
ALTER TABLE `letter`
  ADD CONSTRAINT `letter_ibfk_1` FOREIGN KEY (`recordId`) REFERENCES `record` (`id`);

--
-- Constraints for table `record`
--
ALTER TABLE `record`
  ADD CONSTRAINT `record_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `record_ibfk_2` FOREIGN KEY (`locationFrom`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `record_ibfk_3` FOREIGN KEY (`locationTo`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `record_ibfk_4` FOREIGN KEY (`departmentFrom`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `record_ibfk_5` FOREIGN KEY (`departmentTo`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `record_ibfk_6` FOREIGN KEY (`projectFrom`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `record_ibfk_7` FOREIGN KEY (`projectTo`) REFERENCES `projects` (`id`),
  ADD CONSTRAINT `record_ibfk_8` FOREIGN KEY (`requestFor`) REFERENCES `employee` (`id`);

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`recordId`) REFERENCES `record` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
