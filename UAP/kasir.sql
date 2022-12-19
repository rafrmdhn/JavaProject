-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 19, 2022 at 07:52 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir`
--

-- --------------------------------------------------------

--
-- Table structure for table `Barang`
--

CREATE TABLE `Barang` (
  `barcode` varchar(10) NOT NULL,
  `expired` varchar(10) DEFAULT NULL,
  `nama_produk` varchar(20) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `harga` double NOT NULL,
  `jumlah` int(11) NOT NULL,
  `diskon` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Barang`
--

INSERT INTO `Barang` (`barcode`, `expired`, `nama_produk`, `kategori`, `harga`, `jumlah`, `diskon`) VALUES
('ABC123', '-', 'sapu', 'alat', 12000, 3, 0.1);

-- --------------------------------------------------------

--
-- Table structure for table `Kategori`
--

CREATE TABLE `Kategori` (
  `nama_kategori` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('raphking', 2117051044);

-- --------------------------------------------------------

--
-- Table structure for table `Makanan`
--

CREATE TABLE `Makanan` (
  `id` int(11) NOT NULL,
  `daya_tahan` int(11) NOT NULL,
  `nama_produk` varchar(20) NOT NULL,
  `harga` double NOT NULL,
  `jumlah` int(11) NOT NULL,
  `diskon` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Makanan`
--

INSERT INTO `Makanan` (`id`, `daya_tahan`, `nama_produk`, `harga`, `jumlah`, `diskon`) VALUES
(14, 30, 'mie', 3000, 5, 0.3);

-- --------------------------------------------------------

--
-- Table structure for table `Penjualan`
--

CREATE TABLE `Penjualan` (
  `Produk` varchar(20) NOT NULL,
  `jumlahProduk` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Barang`
--
ALTER TABLE `Barang`
  ADD PRIMARY KEY (`barcode`),
  ADD KEY `kategori` (`kategori`) USING BTREE;

--
-- Indexes for table `Kategori`
--
ALTER TABLE `Kategori`
  ADD PRIMARY KEY (`nama_kategori`);

--
-- Indexes for table `Makanan`
--
ALTER TABLE `Makanan`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
