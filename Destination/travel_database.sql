-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2025 at 03:53 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `BookingId` int(11) NOT NULL,
  `Destination` varchar(100) NOT NULL,
  `Name` varchar(70) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Visit Date` date NOT NULL,
  `Number of people` int(11) NOT NULL,
  `Notes` mediumtext NOT NULL,
  `Guidance Needed` varchar(10) NOT NULL,
  `Nationality` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`BookingId`, `Destination`, `Name`, `Email`, `Visit Date`, `Number of people`, `Notes`, `Guidance Needed`, `Nationality`) VALUES
(1, 'Arugam Bay', 'John dave', 'john@gmail.com', '2025-05-16', 23, '', 'yes', 'british'),
(2, 'Nilaveli Beach', 'adithya', '@adi', '2025-05-06', 2, 'veg', 'yes', 'srilankan'),
(3, 'Arugam Bay', 'Jaya', 'jay@', '2025-05-02', 4, '', 'yes', 'lankan');

-- --------------------------------------------------------

--
-- Table structure for table `destination`
--

CREATE TABLE `destination` (
  `Id` int(11) NOT NULL,
  `Name` varchar(70) NOT NULL,
  `Region` varchar(70) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `Bookings` int(11) NOT NULL,
  `Activities` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `destination`
--

INSERT INTO `destination` (`Id`, `Name`, `Region`, `Description`, `Bookings`, `Activities`) VALUES
(1, 'Unawatuna Beach', 'Southern', 'Unawatuna is a stunning crescent-shaped beach located near Galle in southern Sri Lanka. It\'s famous for its calm, shallow waters and golden sands, making it perfect for swimming and snorkeling. The beach is surrounded by lush greenery and vibrant coral reefs. Nearby attractions include the iconic Japanese Peace Pagoda and Rumassala Hill...', 11, '- Surfing\r\n- Swimming\r\n- Sunbathing\r\n- Fishing Trips\r\n- Horseback Riding on the Beach\r\n-Boat Tours \r\n- Enjoy the local street food.\r\n-Watch the stilt fishermen fish.\r\n-Party at the end of the night at the beach. '),
(2, 'Mirissa Beach', 'Southern', 'Fringing two sandy bays separated by a rock island reachable at low tide, Mirissa feels hidden away compared to Sri Lanka’s other busier resort towns. While the quiet sands are sprinkled with bars and surf rentals, it’s Mirissa’s May-to-November whale-watching boat trips that steal the show...', 6, '- Surfing\r\n- Swimming\r\n- Whale watching\r\n- Safaris\r\n- Sunbathing\r\n- Fishing Trips'),
(3, 'Nilaveli Beach', 'Eastern', 'Nilaveli Beach, located on the northeast coast near Trincomalee, is known for its crystal-clear turquoise waters and soft white sands. It is a peaceful and less crowded beach, ideal for tranquil getaways. The area is perfect for water sports like snorkeling and diving, especially around Pigeon Island, a nearby marine national park rich in coral and marine life...', 12, '- Swim with turtles and sharks on Pigeon Island\r\n- Explore Fort Fredrick\r\n- Head to Uppuveli Beach for drinks by the water\r\n- Visit the Maritime Museum and Dutch Bay\r\n- Relax at the beautiful Marble Beach\r\n- Whale Watching Tour'),
(4, 'Arugam Bay', 'Eastern', 'Arugam Bay, situated on the southeast coast, is internationally renowned as one of the top surfing destinations in the world. This laid-back beach town draws surfers, backpackers, and nature lovers alike. The bay features consistent waves and scenic points such as Peanut Farm and Whiskey Point. Beyond surfing, it offers a relaxed village vibe, coconut palms swaying in the breeze, and nearby adventures like wildlife safaris in Kumana National Park...', 15, '- Climb up Elephant Rock\r\n- Surf & Chill at Arugam Bay Beach\r\n- Lagoon Safari\r\n- Kudumbigala Monastery\r\n- Seeing the fishermen at Puttuvil Beach\r\n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`BookingId`);

--
-- Indexes for table `destination`
--
ALTER TABLE `destination`
  ADD PRIMARY KEY (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
