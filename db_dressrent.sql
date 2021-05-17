-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2021 at 08:32 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_dressrent`
--

-- --------------------------------------------------------

--
-- Table structure for table `cus_reg`
--

CREATE TABLE `cus_reg` (
  `Id` varchar(15) NOT NULL,
  `Cus_id` varchar(20) NOT NULL,
  `Cus_name` varchar(50) NOT NULL,
  `Cus_add` varchar(50) NOT NULL,
  `Cus_mob` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cus_reg`
--

INSERT INTO `cus_reg` (`Id`, `Cus_id`, `Cus_name`, `Cus_add`, `Cus_mob`) VALUES
('C0001', '9778923454v', 'Saman', '34/A,Galle', '713332456'),
('C0002', '956667834v', 'Nimal', '2/A,Gampaha', '707723323'),
('C0003', '65765765v', 'sachin', '57765765', 'matara'),
('C0004', '67676778', 'kamal', 'galle', '7023454'),
('C0005', '977692367v', 'Kashu', 'Galagedra', '768992376');

-- --------------------------------------------------------

--
-- Table structure for table `dress_reg`
--

CREATE TABLE `dress_reg` (
  `Id` int(11) NOT NULL,
  `Dres_id` varchar(20) NOT NULL,
  `Dres_size` varchar(20) NOT NULL,
  `Dres_type` varchar(20) NOT NULL,
  `Dres_color` varchar(20) NOT NULL,
  `Dres_available` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dress_reg`
--

INSERT INTO `dress_reg` (`Id`, `Dres_id`, `Dres_size`, `Dres_type`, `Dres_color`, `Dres_available`) VALUES
(1, 'D0001', 'L', 'Casual Dresses', 'Red', 'No'),
(2, 'D0002', 'M', ' Floral Dresses', 'Black', 'No'),
(3, 'D0003', 'L', 'Formal Dresses', 'White', 'No'),
(4, 'D0004', 'M', 'Strapless Dresses', 'Cream', 'No'),
(5, 'D0005', 'S', 'Casual Dresses', 'f', 'No'),
(7, 'D0007', 'S', 'Casual Dresses', '2', 'Yes'),
(8, 'D0008', 'L', 'Formal Dresses', 'hgh', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `dress_rent`
--

CREATE TABLE `dress_rent` (
  `DREdres_RID` varchar(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `DREdres_id` varchar(20) NOT NULL,
  `DREcus_id` varchar(20) NOT NULL,
  `DREcus_name` varchar(50) NOT NULL,
  `DRE_fee` varchar(11) NOT NULL,
  `DRE_date` varchar(20) NOT NULL,
  `DREdue_date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dress_rent`
--

INSERT INTO `dress_rent` (`DREdres_RID`, `Id`, `DREdres_id`, `DREcus_id`, `DREcus_name`, `DRE_fee`, `DRE_date`, `DREdue_date`) VALUES
('R000001', 7, 'D0003', 'C0003', 'sachin', '34000', '2021-05-05', '2021-05-04'),
('R000002', 8, 'D0002', 'C0002', 'Nimal', '34', '2021-05-05', '2021-05-05'),
('R000003', 10, 'D0001', 'C0004', 'kamal', '2000', '2021-05-07', '2021-05-13'),
('R000004', 11, 'D0004', 'C0003', 'sachin', '300', '2021-05-06', '2021-05-19');

-- --------------------------------------------------------

--
-- Table structure for table `dress_return`
--

CREATE TABLE `dress_return` (
  `Id` int(11) NOT NULL,
  `Rdres_id` varchar(20) NOT NULL,
  `Rcus_id` varchar(20) NOT NULL,
  `Return_date` varchar(20) NOT NULL,
  `Rdays_elap` int(11) NOT NULL,
  `Rdres_fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dress_return`
--

INSERT INTO `dress_return` (`Id`, `Rdres_id`, `Rcus_id`, `Return_date`, `Rdays_elap`, `Rdres_fine`) VALUES
(1, 'D0001', 'C0001', '2021-04-12', 0, 0),
(2, 'D0002', 'C0003', '2021-02-20', 6, 600),
(3, 'D0003', 'C0002', '2021-02-28', 0, 0),
(4, 'd0001', 'C0001', '2021-05-20', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cus_reg`
--
ALTER TABLE `cus_reg`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `dress_reg`
--
ALTER TABLE `dress_reg`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `dress_rent`
--
ALTER TABLE `dress_rent`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `dress_return`
--
ALTER TABLE `dress_return`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dress_reg`
--
ALTER TABLE `dress_reg`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `dress_rent`
--
ALTER TABLE `dress_rent`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `dress_return`
--
ALTER TABLE `dress_return`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
