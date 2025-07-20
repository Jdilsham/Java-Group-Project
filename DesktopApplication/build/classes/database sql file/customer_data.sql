-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2025 at 03:21 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customer_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `package` varchar(20) NOT NULL,
  `persons` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`first_name`, `last_name`, `nic`, `contact_number`, `package`, `persons`) VALUES
('asd', 'ss', '1234', '11111111', 'Silver Package', '2'),
('qqq', 'qwe', '111', '111111', 'Bronze Package', '2'),
('aa', 'dfhxh', '123', '123467', 'Silver Package', '3');

-- --------------------------------------------------------

--
-- Table structure for table `book_destination`
--

CREATE TABLE `book_destination` (
  `id` int(11) NOT NULL,
  `destinationName` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `count` int(11) NOT NULL,
  `note` char(80) NOT NULL,
  `guide` varchar(20) NOT NULL,
  `nationality` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `personal_data`
--

CREATE TABLE `personal_data` (
  `user_id` int(10) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `country` varchar(20) NOT NULL,
  `address` varchar(150) NOT NULL,
  `phone_number` int(10) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `personal_data`
--

INSERT INTO `personal_data` (`user_id`, `nic`, `first_name`, `last_name`, `gender`, `country`, `address`, `phone_number`, `email`) VALUES
(23, '1111111111', 'adsasd', 'asdasd', 'Male', 'Mexico', 'sadasd\ndasdasdasd', 1111111111, 'asdasd@gmail.com'),
(24, '11111111', 'sdasd', 'fsdfs', 'Male', 'Mexico', 'asd\nas\ndasdadasd', 1111111111, 'asdad@gmail.com'),
(25, '11111', 'sdasd', 'asdasd', 'Male', 'Mexico', 'asdasdasd\nasd\nasdasdasd', 1234567890, 'adsad@gmail.com'),
(26, '11112121212', 'werwer', 'rweqq', 'Male', 'Mexico', 'asdasddsa\nsdasdasd\nsadas', 1234567890, 'sdasda@gmail.com'),
(27, '1234567890', 'shehara', 'fer', 'Male', 'Brazil', 'asds\nd\ndasdasd', 1234567890, 'addsasd@gmail.com'),
(28, '1234567890', 'kamal', 'bandara', 'Male', 'Sri Lanka', 'asdasda\nsd\nas\ndasdasdasd', 712345123, 'kamal@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_data`
--

CREATE TABLE `user_data` (
  `Email` varchar(20) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_data`
--

INSERT INTO `user_data` (`Email`, `userName`, `password`) VALUES
('asd@gmail.com', 'aaa', '123'),
('asd@gmail.com', 'cc', '12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `personal_data`
--
ALTER TABLE `personal_data`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `personal_data`
--
ALTER TABLE `personal_data`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
