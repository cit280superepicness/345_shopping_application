-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2016 at 11:50 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `craft_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cat_id` int(11) NOT NULL,
  `cat_name` varchar(16) NOT NULL,
  `cat_description` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `cat_name`, `cat_description`) VALUES
(1, 'Posters', 'Screen printed posters'),
(2, 'Art', 'Unique pieces of art'),
(3, 'Clothing', 'Wearable fabric');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `inv_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inv_id`, `user_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `inventory_line`
--

CREATE TABLE `inventory_line` (
  `inv_id` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `inv_line_num` int(11) NOT NULL,
  `inv_line_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory_line`
--

INSERT INTO `inventory_line` (`inv_id`, `prod_id`, `inv_line_num`, `inv_line_qty`) VALUES
(2, 4, 1, 1),
(2, 7, 2, 3),
(2, 1, 5, 7),
(3, 5, 3, 1),
(3, 8, 4, 13),
(3, 6, 6, 20),
(3, 2, 7, 1),
(3, 5, 8, 0);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `invoice_time` time NOT NULL,
  `invoice_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_id`, `user_id`, `invoice_time`, `invoice_date`) VALUES
(1, 4, '00:27:44', '2016-03-08'),
(2, 1, '00:27:57', '2016-03-08'),
(3, 5, '00:28:34', '2016-03-08'),
(4, 2, '00:28:42', '2016-03-08'),
(5, 4, '00:29:34', '2016-03-08'),
(6, 3, '00:29:45', '2016-03-08'),
(7, 3, '00:29:53', '2016-03-08'),
(8, 4, '00:44:57', '2016-04-06');

-- --------------------------------------------------------

--
-- Table structure for table `invoice_line`
--

CREATE TABLE `invoice_line` (
  `invoice_id` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `invoice_line_num` int(11) NOT NULL,
  `invoice_line_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice_line`
--

INSERT INTO `invoice_line` (`invoice_id`, `prod_id`, `invoice_line_num`, `invoice_line_qty`) VALUES
(1, 6, 2, 2),
(2, 7, 3, 3),
(3, 5, 4, 2),
(4, 3, 5, 8),
(5, 4, 6, 8),
(6, 1, 7, 1),
(7, 7, 8, 7),
(8, 7, 9, 2),
(9, 1, 10, 10),
(10, 4, 11, 11),
(10, 5, 12, 12);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `prod_id` int(11) NOT NULL,
  `cat_id` int(11) NOT NULL,
  `prod_name` varchar(16) NOT NULL,
  `prod_price` int(11) NOT NULL,
  `prod_description` varchar(99) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`prod_id`, `cat_id`, `prod_name`, `prod_price`, `prod_description`) VALUES
(1, 1, 'Top Gun Poster', 10, 'Poster from the film Top Gun'),
(2, 2, 'Tree Painting', 25, 'Painting of a tree'),
(3, 3, 'Smoking Jacket', 99, 'A gentleman''s jacket'),
(4, 1, 'Skyfall Poster', 15, 'Poster from the film Skyfall'),
(5, 3, 'Green Socks', 20, 'Socks that are colored green'),
(6, 1, 'Star Wars Poster', 23, 'Poster of the movie Star Wars'),
(7, 3, 'Large Hat', 75, 'A very nice hat that is large'),
(8, 2, 'Bird Sculpture', 499, 'A sculpture of a bird');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `fname` varchar(16) NOT NULL,
  `lname` varchar(16) NOT NULL,
  `initial` varchar(16) DEFAULT NULL,
  `dob` varchar(16) NOT NULL,
  `address` varchar(16) NOT NULL,
  `city` varchar(16) NOT NULL,
  `state_province` varchar(16) NOT NULL,
  `country` varchar(16) NOT NULL,
  `zip` varchar(16) NOT NULL,
  `area_code` varchar(16) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `card_number` varchar(16) NOT NULL,
  `is_vendor` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `fname`, `lname`, `initial`, `dob`, `address`, `city`, `state_province`, `country`, `zip`, `area_code`, `phone`, `card_number`, `is_vendor`) VALUES
(1, 'andy', 'andypass', 'Andy', 'Anderson', 'A', '1976-09-16', '123 Axel Ave', 'Auburn', 'AL', 'United States', '12345', '321', '5865551929', '1234123412341234', 0),
(2, 'bobby', 'bobbypass', 'Bobby', 'Bottles', NULL, '1992-07-03', '456 Brooklyn', 'Boise', 'ID', 'Bulgaria', '56789', '456', '3135559801', '4321567834560789', 1),
(3, 'cody', 'codypass', 'Cody', 'Cottons', NULL, '1923-11-20', '678 Cranbrook', 'Charleston', 'CA', 'United States', '45643', '982', '3236720089', '7391048283704728', 1),
(4, 'donald', 'donaldpass', 'Donald', 'Duster', 'D', '1985-12-01', '495 Disco', 'Dearborn', 'MI', 'United States', '69363', '545', '8490218888', '7777666655554444', 0),
(5, 'edgar', 'edgarpass', 'Edgar', 'Eaton', NULL, '1990-06-30', '6753 Eastern St', 'Eerie', 'PA', 'Estonia', '45451', '329', '9798687474', '1010292938384747', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cat_id`),
  ADD UNIQUE KEY `cat_id` (`cat_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inv_id`),
  ADD UNIQUE KEY `inv_id` (`inv_id`),
  ADD KEY `inventory_ibfk_1` (`user_id`);

--
-- Indexes for table `inventory_line`
--
ALTER TABLE `inventory_line`
  ADD PRIMARY KEY (`inv_id`,`inv_line_num`),
  ADD UNIQUE KEY `inv_line_num` (`inv_line_num`),
  ADD UNIQUE KEY `inv_id` (`inv_id`,`inv_line_num`),
  ADD UNIQUE KEY `inv_id_2` (`inv_id`,`inv_line_num`),
  ADD UNIQUE KEY `inv_line_num_2` (`inv_line_num`),
  ADD UNIQUE KEY `inv_id_4` (`inv_id`,`inv_line_num`),
  ADD UNIQUE KEY `inv_line_num_3` (`inv_line_num`),
  ADD KEY `inv_id_3` (`inv_id`,`inv_line_num`),
  ADD KEY `inventory_line_ibfk_2` (`prod_id`),
  ADD KEY `prod_id` (`prod_id`),
  ADD KEY `inv_id_5` (`inv_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`),
  ADD UNIQUE KEY `invoice_id` (`invoice_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `user_id_2` (`user_id`);

--
-- Indexes for table `invoice_line`
--
ALTER TABLE `invoice_line`
  ADD PRIMARY KEY (`invoice_id`,`invoice_line_num`),
  ADD KEY `prod_id` (`prod_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`prod_id`),
  ADD UNIQUE KEY `prod_id` (`prod_id`),
  ADD KEY `cat_id` (`cat_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `inventory_line`
--
ALTER TABLE `inventory_line`
  MODIFY `inv_line_num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `inventory_line`
--
ALTER TABLE `inventory_line`
  ADD CONSTRAINT `inventory_line_ibfk_1` FOREIGN KEY (`inv_id`) REFERENCES `inventory` (`inv_id`),
  ADD CONSTRAINT `inventory_line_ibfk_2` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `invoice_line`
--
ALTER TABLE `invoice_line`
  ADD CONSTRAINT `invoice_line_ibfk_1` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
