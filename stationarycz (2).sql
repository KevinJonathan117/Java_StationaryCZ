-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2019 at 05:24 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.1.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stationarycz`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `IDBARANG` varchar(5) NOT NULL,
  `IDKATEGORI` varchar(5) NOT NULL,
  `IDMEREK` varchar(5) NOT NULL,
  `NMBARANG` varchar(50) NOT NULL,
  `NMGAMBAR` varchar(55) NOT NULL,
  `HRGJUALBARANG` int(11) DEFAULT NULL,
  `STOK` int(11) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`IDBARANG`, `IDKATEGORI`, `IDMEREK`, `NMBARANG`, `NMGAMBAR`, `HRGJUALBARANG`, `STOK`, `status`) VALUES
('I0001', 'K0001', 'ME001', 'Bolpen Tripen', 'TripenFaberCastell.png', 7500, 96, 'AKTIF'),
('I0002', 'K0001', 'ME001', 'Bolpen Vernate 3in1', 'VernateFaberCastell.png', 6000, 72, 'AKTIF'),
('I0003', 'K0001', 'ME001', 'Bolpen Slicx', 'SlicxFaberCastell.png', 9000, 80, 'AKTIF'),
('I0004', 'K0002', 'ME001', 'Penggaris Faber Castell', 'PenggarisFaberCastell.png', 3500, 100, 'AKTIF'),
('I0005', 'K0003', 'ME021', 'Noteboook Harvest', 'NoteboookHarvest.png', 25000, 50, 'AKTIF'),
('I0006', 'K0004', 'ME012', 'Binder Bantex', 'BinderBantex.png', 12000, 70, 'AKTIF'),
('I0007', 'K0005', 'ME022', 'Binder Refill Loose Leaf', 'BinderRefillLooseLeaf.png', 5000, 82, 'AKTIF'),
('I0008', 'K0006', 'ME023', 'Buku Kotak Vision', 'BukuKotakVision.png', 2500, 70, 'AKTIF'),
('I0009', 'K0007', 'ME019', 'Buku Tulis Sinar Dunia', 'BukuTulisSinarDunia.png', 2000, 100, 'AKTIF'),
('I0010', 'K0008', 'ME021', 'Kotak Pensil Harvest', 'KotakPensilHarvest.png', 16000, 60, 'AKTIF'),
('I0011', 'K0009', 'ME024', 'Tas Ransel Matrix Store', 'TasRanselMatrixStore.png', 210000, 50, 'AKTIF'),
('I0012', 'K0010', 'ME025', 'Tote Bag Visval', 'ToteBagVisval.png', 150000, 50, 'AKTIF'),
('I0013', 'K0011', 'ME002', 'Pensil Staedtler', 'PensilStaedtler.png', 4000, 100, 'AKTIF'),
('I0014', 'K0012', 'ME001', 'Pensil Mekanik Faber Castell', 'PensilMekanikFaberCastell.png', 9000, 100, 'AKTIF'),
('I0015', 'K0013', 'ME026', 'Crayon TiTi', 'CrayonTiTi.png', 50000, 60, 'AKTIF'),
('I0016', 'K0014', 'ME001', 'Pensil Warna Faber Castell', 'PensilWarnaFaberCastell.png', 24000, 80, 'AKTIF'),
('I0017', 'K0015', 'ME027', 'Stiker Kayo', 'StikerKayo.png', 9000, 100, 'AKTIF'),
('I0018', 'K0016', 'ME005', 'Penghapus Joyko', 'PenghapusJoyko.png', 2500, 90, 'AKTIF'),
('I0019', 'K0016', 'ME001', 'Penghapus Faber Castell', 'PenghapusFaberCastell.png', 9000, 70, 'AKTIF'),
('I0020', 'K0017', 'ME006', 'Rautan Pensil Kenko', 'RautanPensilKenko.png', 1500, 90, 'AKTIF'),
('I0021', 'K0018', 'ME005', 'Tipex Cair Joyko', 'TipexCairJoyko.png', 5000, 80, 'AKTIF'),
('I0022', 'K0019', 'ME005', 'Tipex Kertas Joyko', 'TipexKertasJoyko.png', 7500, 90, 'AKTIF'),
('I0023', 'K0020', 'ME028', 'Sticky Notes Post It', 'StickyNotesParisPostIt.png', 9000, 80, 'AKTIF'),
('I0024', 'K0021', 'ME001', 'Isi Pensil 0.7 Faber Castell', 'IsiPensil0.7FaberCastell.png', 6500, 100, 'AKTIF'),
('I0025', 'K0022', 'ME001', 'Isi Pensil 0.5 Faber Castell', 'IsiPensil0.5FaberCastell.png', 5500, 100, 'AKTIF'),
('I0026', 'K0023', 'ME008', 'Lem Serbaguna UHU', 'LemSerbagunaUHU.png', 12000, 100, 'AKTIF'),
('I0027', 'K0024', 'ME013', 'Lem Kertas Fox', 'LemKertasFox.png', 10000, 80, 'AKTIF'),
('I0028', 'K0003', 'ME001', 'buku warna', 'BukuKotakVision.png', 5000, 0, 'AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `detailbarang`
--

CREATE TABLE `detailbarang` (
  `NODETAIL` int(11) NOT NULL,
  `IDBARANG` varchar(5) NOT NULL,
  `DESKRIPSI` varchar(200) NOT NULL,
  `STOK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detailbarang`
--

INSERT INTO `detailbarang` (`NODETAIL`, `IDBARANG`, `DESKRIPSI`, `STOK`) VALUES
(1, 'I0001', 'Bolpen Faber Castell Tripen Hijau', 24),
(1, 'I0028', 'buku warna merah', 0),
(2, 'I0001', 'Bolpen Faber Castell Tripen Biru', 24),
(2, 'I0028', 'buku warna hijau', 0),
(3, 'I0001', 'Bolpen Faber Castell Tripen Ungu', 24),
(4, 'I0001', 'Bolpen Faber Castell Tripen Pink', 24),
(5, 'I0002', 'Bolpen Vernate 3in1 Merah', 35),
(6, 'I0002', 'Bolpen Vernate 3in1 Hitam', 30),
(7, 'I0002', 'xxxxxx', 7),
(7, 'I0003', 'Bolpen Faber Castell Slicx Black', 30),
(8, 'I0003', 'Bolpen Faber Castell Slicx Blue', 25),
(9, 'I0003', 'Bolpen Faber Castell Slicx Orange', 25),
(10, 'I0004', 'Penggaris 15cm', 25),
(11, 'I0004', 'Penggaris Segitiga Siku', 25),
(12, 'I0004', 'Penggaris Segitiga Siku Sama Sisi', 25),
(13, 'I0004', 'Penggaris Busur', 25),
(14, 'I0013', 'Pensil Staedtler 2B', 50),
(15, 'I0013', 'Pensil Staedtler HB', 50),
(16, 'I0021', 'Tipex Joyko Red', 40),
(17, 'I0021', 'Tipex Joyko Blue', 40),
(18, 'I0005', 'Noteboook Harvest', 50),
(19, 'I0006', 'Binder Bantex', 70),
(20, 'I0007', 'Binder Refill Loose Leaf', 82),
(21, 'I0008', 'Buku Kotak Vision', 70),
(22, 'I0009', 'Buku Tulis Sinar Dunia', 100),
(23, 'I0010', 'Kotak Pensil Harvest', 60),
(24, 'I0011', 'Tas Ransel Matrix Store', 50),
(25, 'I0012', 'Tote Bag Visval', 50),
(27, 'I0014', 'Pensil Mekanik Faber Castell', 100),
(28, 'I0015', 'Crayon TiTi', 60),
(29, 'I0016', 'Pensil Warna Faber Castell', 80),
(30, 'I0017', 'Stiker Kayo', 100),
(31, 'I0018', 'Penghapus Joyko', 90),
(32, 'I0019', 'Penghapus Faber Castell', 70),
(33, 'I0020', 'Rautan Pensil Kenko', 90),
(35, 'I0022', 'Tipex Kertas Joyko', 90),
(36, 'I0023', 'Sticky Notes Post It', 80),
(37, 'I0023', 'Isi Pensil 0.7 Faber Castell', 100),
(38, 'I0023', 'Isi Pensil 0.5 Faber Castell', 100),
(39, 'I0023', 'Lem Serbaguna UHU', 100),
(40, 'I0023', 'Lem Kertas Fox', 80);

-- --------------------------------------------------------

--
-- Table structure for table `detail_beli`
--

CREATE TABLE `detail_beli` (
  `IDBELI` varchar(5) NOT NULL,
  `IDBARANG` varchar(5) NOT NULL,
  `NODETAIL` int(11) NOT NULL,
  `JUMLAH` int(11) DEFAULT NULL,
  `HRGBELI` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_beli`
--

INSERT INTO `detail_beli` (`IDBELI`, `IDBARANG`, `NODETAIL`, `JUMLAH`, `HRGBELI`) VALUES
('Z0003', 'I0003', 7, 2, 3),
('Z0004', 'I0002', 5, 2, 3),
('Z0004', 'I0006', 19, 1, 2),
('Z0005', 'I0003', 7, 2, 2),
('Z0006', 'I0002', 5, 2, 3),
('Z0007', 'I0002', 5, 5, 3000),
('Z0008', 'I0002', 5, 2, 2),
('Z0009', 'I0002', 5, 5, 5),
('Z0010', 'I0002', 7, 7, 7),
('Z0011', 'I0007', 20, 12, 1200),
('Z0012', 'I0001', 1, 5, 3000);

-- --------------------------------------------------------

--
-- Table structure for table `detail_jual`
--

CREATE TABLE `detail_jual` (
  `IDJUAL` varchar(5) NOT NULL,
  `IDBARANG` varchar(5) NOT NULL,
  `NODETAIL` int(11) NOT NULL,
  `JUMLAH` int(11) NOT NULL,
  `HRGJUAL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `detail_retur`
--

CREATE TABLE `detail_retur` (
  `NORETUR` varchar(5) NOT NULL,
  `IDBARANG` varchar(5) NOT NULL,
  `NODETAIL` int(11) NOT NULL,
  `JUMLAHRETUR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_retur`
--

INSERT INTO `detail_retur` (`NORETUR`, `IDBARANG`, `NODETAIL`, `JUMLAHRETUR`) VALUES
('R0002', 'I0001', 1, 5),
('R0003', 'I0001', 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `IDJABATAN` varchar(5) NOT NULL,
  `NMJABATAN` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`IDJABATAN`, `NMJABATAN`) VALUES
('J1', 'Admin'),
('J2', 'Kasir Pembelian'),
('J3', 'Kasir Penjualan');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `IDKATEGORI` varchar(5) NOT NULL,
  `NMKATEGORI` varchar(50) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`IDKATEGORI`, `NMKATEGORI`, `status`) VALUES
('K0001', 'Bolpoin', 'AKTIF'),
('K0002', 'Penggaris', 'AKTIF'),
('K0003', 'Notebook', 'AKTIF'),
('K0004', 'Binder', 'AKTIF'),
('K0005', 'Binder Refill', 'AKTIF'),
('K0006', 'Buku Kotak', 'AKTIF'),
('K0007', 'Buku Tulis', 'AKTIF'),
('K0008', 'Kotak Pensil', 'AKTIF'),
('K0009', 'Tas Ransel', 'AKTIF'),
('K0010', 'Tote Bag', 'AKTIF'),
('K0011', 'Pensil', 'AKTIF'),
('K0012', 'Pensil Mekanik', 'AKTIF'),
('K0013', 'Crayon', 'AKTIF'),
('K0014', 'Pensil Warna', 'AKTIF'),
('K0015', 'Stiker', 'AKTIF'),
('K0016', 'Penghapus Pensil', 'AKTIF'),
('K0017', 'Rautan', 'AKTIF'),
('K0018', 'Tipex Cair', 'AKTIF'),
('K0019', 'Tipex Kertas', 'AKTIF'),
('K0020', 'Sticky Notes', 'AKTIF'),
('K0021', 'Isi Pensil 0.7', 'AKTIF'),
('K0022', 'Isi Pensil 0.5', 'AKTIF'),
('K0023', 'Lem Serbaguna', 'AKTIF'),
('K0024', 'Lem Kertas', 'AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `IDMEMBER` varchar(5) NOT NULL,
  `NMMEMBER` varchar(50) NOT NULL,
  `HPMEMBER` varchar(15) NOT NULL,
  `SALDOMEMBER` int(11) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`IDMEMBER`, `NMMEMBER`, `HPMEMBER`, `SALDOMEMBER`, `status`) VALUES
('M0001', 'Frank Bobbey', '081255678810', 0, 'AKTIF'),
('M0002', 'Stanley Kish', '081990761455', 20500, 'AKTIF'),
('M0003', 'Marshita Berly', '081254399987', 0, 'AKTIF'),
('M0004', 'Yuri Kenn', '081288903525', 100000, 'AKTIF'),
('M0005', 'Catherine Odre', '081722289931', 60000, 'AKTIF'),
('M0006', 'Victory Theofilus', '081148779096', 0, 'AKTIF'),
('M0007', 'Annie Laurenz', '081612022787', 12400, 'AKTIF'),
('M0008', 'Hanny Gozali', '081252886555', 0, 'AKTIF'),
('M0009', 'Jeremy Zwedia', '081551089972', 50000, 'AKTIF'),
('M0010', 'Xander ', '081278888929', 1500, 'AKTIF'),
('M0011', 'Warren Man', '081399952677', 0, 'AKTIF'),
('M0012', 'Felly Dominique', '083345982021', 0, 'AKTIF'),
('M0013', 'Yenny Charita', '081552464735', 0, 'AKTIF'),
('M0014', 'Jack Frozzy', '081278905578', 0, 'AKTIF'),
('M0015', 'Marishka Bella', '081255789098', 0, 'AKTIF'),
('M0016', 'Donny Mario Joyo', '081266798898', 0, 'AKTIF'),
('M0017', 'Theo Gezy', '085242556804', 5800, 'AKTIF'),
('M0018', 'Sally Oceano', '081277360027', 0, 'AKTIF'),
('M0019', 'Fransisco ', '081215678925', 0, 'AKTIF'),
('M0020', 'Jessica Kath', '081238887252', 0, 'AKTIF'),
('M0021', 'Warren Onsky', '08196678435', 0, 'TIDAK AKTIF'),
('M0022', 'Naeyoon', '081716278895', 0, 'AKTIF'),
('M0023', 'Kevin Ariwan', '082135565742', 0, 'TIDAK AKTIF'),
('M0024', 'Siska Johary', '0878786752', 0, 'AKTIF'),
('M0025', 'Kim Roo Won', '0812456724', 0, 'AKTIF'),
('M0026', 'Cesse Westy', '08195567797', 0, 'AKTIF'),
('M0027', 'Michael Randy', '0816764290', 0, 'AKTIF'),
('M0028', 'Raymond Asley', '0814526728', 0, 'AKTIF'),
('M0029', 'Hanna Milky', '08155267281', 0, 'AKTIF'),
('M0030', 'Teddy Oslen', '0877878890', 0, 'AKTIF'),
('M0031', 'Tony Stark', '0812345678', 0, 'TIDAK AKTIF'),
('M0032', 'kevjo', '0812456', 150000, 'AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `merek`
--

CREATE TABLE `merek` (
  `IDMEREK` varchar(5) NOT NULL,
  `NMMEREK` varchar(50) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `merek`
--

INSERT INTO `merek` (`IDMEREK`, `NMMEREK`, `status`) VALUES
('ME001', 'Faber Castell', 'AKTIF'),
('ME002', 'Staedtler', 'AKTIF'),
('ME003', 'Artline', 'AKTIF'),
('ME004', 'Faster', 'AKTIF'),
('ME005', 'Joyko', 'AKTIF'),
('ME006', 'Kenko', 'AKTIF'),
('ME007', 'Butterfly', 'AKTIF'),
('ME008', 'UHU', 'AKTIF'),
('ME009', 'Stabilo', 'AKTIF'),
('ME010', 'Pronto', 'AKTIF'),
('ME011', 'Max', 'AKTIF'),
('ME012', 'Bantex', 'AKTIF'),
('ME013', 'Fox', 'AKTIF'),
('ME014', 'Bindex', 'AKTIF'),
('ME015', 'Snowman', 'AKTIF'),
('ME016', 'Pilot', 'AKTIF'),
('ME017', 'Glue Stick', 'AKTIF'),
('ME018', 'Glukol', 'AKTIF'),
('ME019', 'Sinar Dunia', 'AKTIF'),
('ME020', 'Kiky', 'AKTIF'),
('ME021', 'Harvest', 'AKTIF'),
('ME022', 'Loose Leaf', 'AKTIF'),
('ME023', 'Vision', 'AKTIF'),
('ME024', 'Matrix Store', 'AKTIF'),
('ME025', 'Visval', 'AKTIF'),
('ME026', 'TiTi', 'AKTIF'),
('ME027', 'Kayo', 'AKTIF'),
('ME028', 'Post It', 'AKTIF'),
('ME029', 'Apple', 'AKTIF'),
('ME030', 'lamborgini', 'TIDAK AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `IDPEG` varchar(5) NOT NULL,
  `IDJABATAN` varchar(5) NOT NULL,
  `NMPEG` varchar(50) NOT NULL,
  `USERNAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`IDPEG`, `IDJABATAN`, `NMPEG`, `USERNAME`, `PASSWORD`, `status`) VALUES
('P0001', 'J1', 'Anthon Crambell', 'anthonc', 'anthonc', 'AKTIF'),
('P0002', 'J2', 'Kelly Jenner', 'kellyj', 'kellyj', 'AKTIF'),
('P0003', 'J2', 'Saphira Anitha', 'saphiraa', 'saphiraa', 'AKTIF'),
('P0004', 'J3', 'Jennie Wesley', 'Jenniew', 'jnw', 'AKTIF'),
('P0005', 'J3', 'George Stanley', 'georges', 'gs', 'TIDAK AKTIF'),
('P0006', 'J3', 'Milly Swarovski', 'millys', 'ms', 'TIDAK AKTIF'),
('P0007', 'J2', 'Allan', 'a', 'a', 'AKTIF'),
('P0008', 'J3', 'Alan Walker', 'alan', 'alan', 'AKTIF'),
('P0009', 'J3', 'cc', 'c', 'c', 'AKTIF'),
('P0010', 'J3', 'bb', 'b', 'b', 'AKTIF'),
('P0011', 'J3', 'gaby', 'gab', 'gab', 'AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `IDBELI` varchar(5) NOT NULL,
  `IDPEG` varchar(5) NOT NULL,
  `IDSUPPLIER` varchar(5) NOT NULL,
  `TGLBELI` date DEFAULT NULL,
  `TOTALHRG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`IDBELI`, `IDPEG`, `IDSUPPLIER`, `TGLBELI`, `TOTALHRG`) VALUES
('Z0001', 'P0007', 'S0001', '2019-12-13', 2),
('Z0002', 'P0007', 'S0001', '2019-12-13', 2),
('Z0003', 'P0007', 'S0001', '2019-12-13', 6),
('Z0004', 'P0007', 'S0001', '2019-12-13', 8),
('Z0005', 'P0007', 'S0001', '2019-12-13', 4),
('Z0006', 'P0007', 'S0004', '2019-12-13', 6),
('Z0007', 'P0007', 'S0001', '2019-12-15', 15000),
('Z0008', 'P0007', 'S0001', '2019-12-15', 4),
('Z0009', 'P0007', 'S0001', '2019-12-15', 25),
('Z0010', 'P0007', 'S0001', '2019-12-15', 49),
('Z0011', 'P0011', 'S0001', '2019-12-19', 14400),
('Z0012', 'P0011', 'S0001', '2019-12-19', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `IDJUAL` varchar(5) NOT NULL,
  `IDMEMBER` varchar(5) NOT NULL,
  `IDPEG` varchar(5) NOT NULL,
  `TGLJUAL` date NOT NULL,
  `DISCJUAL` int(11) DEFAULT NULL,
  `TOTALHRG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`IDJUAL`, `IDMEMBER`, `IDPEG`, `TGLJUAL`, `DISCJUAL`, `TOTALHRG`) VALUES
('Y0001', 'M0003', 'P0002', '2019-12-19', 0, 100000),
('Y0002', 'M0004', 'P0001', '2019-12-09', 0, 250000),
('Y0003', 'M0001', 'P0004', '2019-10-08', 0, 50000),
('Y0004', 'M0006', 'P0003', '2019-05-21', 0, 200000),
('Y0005', 'M0011', 'P0004', '2019-10-03', 0, 150000),
('Y0006', 'M0006', 'P0002', '2019-12-28', 0, 270000);

-- --------------------------------------------------------

--
-- Table structure for table `pricelist`
--

CREATE TABLE `pricelist` (
  `IDBARANG` varchar(5) NOT NULL,
  `IDSUPPLIER` varchar(5) NOT NULL,
  `HRGBELIPERSUPPLIER` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `returpembelian`
--

CREATE TABLE `returpembelian` (
  `NORETUR` varchar(5) NOT NULL,
  `IDSUPPLIER` varchar(5) NOT NULL,
  `TGLRETUR` date NOT NULL,
  `TGLDAPATBARANG` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returpembelian`
--

INSERT INTO `returpembelian` (`NORETUR`, `IDSUPPLIER`, `TGLRETUR`, `TGLDAPATBARANG`) VALUES
('R0001', 'S0001', '2019-12-15', NULL),
('R0002', 'S0001', '2019-12-15', '2019-12-16'),
('R0003', 'S0001', '2019-12-19', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `IDSUPPLIER` varchar(5) NOT NULL,
  `NMSUPPLIER` varchar(50) NOT NULL,
  `ALAMAT` varchar(50) NOT NULL,
  `TELP` varchar(30) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`IDSUPPLIER`, `NMSUPPLIER`, `ALAMAT`, `TELP`, `status`) VALUES
('S0001', 'PT. Tulis Senang', 'Jl. Gatot Subroto 29 Surabaya', '031504228', 'AKTIF'),
('S0002', 'CV. Andalan Kita', 'Jl. Mawar Indah 12 Bandung', '031502770', 'AKTIF'),
('S0003', 'PT. Snowman', 'Jl. Tunjungan I/22 Surabaya', '031602789', 'AKTIF'),
('S0004', 'PT. IndoStationary', 'Jl. Kartini 50 Surabaya', '032808917', 'AKTIF'),
('S0005', 'PT. Sidu', 'Jl. Biliton AA/29 Jakarta', '0312289226', 'AKTIF'),
('S0006', 'PT. Sansan Wawa', 'Jl. Haris 35 Jakarta', '0316825', 'AKTIF'),
('S0007', 'PT. Grasindo', 'Jl. Menjangan II/8 Bogor', '031921625', 'AKTIF'),
('S0008', 'PT. Indonesia Bahagia', 'Jl. Tempe 19  Jakarta', '031991911', 'AKTIF'),
('S0009', 'PT.Sinar Dunia', 'Jl. Terong 15A, Sidoarjo', '031564887', 'AKTIF'),
('S0010', 'Toko Jaya Stationary', 'Jl.Majapahit 60, Surabaya', '031372667', 'AKTIF'),
('S0011', 'Toko Mega Alat Tulis', 'Jl.Embong besar 105-106', '031455878', 'AKTIF'),
('S0012', 'PT.Joyko', 'Jl.Kusuma 99B, Bandung', '031357502', 'TIDAK AKTIF'),
('S0013', 'PT. Java Bahagia', 'Jl. Hitler Kesandung No.23', '03123456', 'AKTIF'),
('S0014', 'PT.Apple jaya', 'ass', '081256', 'TIDAK AKTIF');

-- --------------------------------------------------------

--
-- Table structure for table `topupsaldo`
--

CREATE TABLE `topupsaldo` (
  `IDTOPUP` varchar(5) NOT NULL,
  `IDMEMBER` varchar(5) NOT NULL,
  `TGLTOPUP` date NOT NULL,
  `NILAITOPUP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `topupsaldo`
--

INSERT INTO `topupsaldo` (`IDTOPUP`, `IDMEMBER`, `TGLTOPUP`, `NILAITOPUP`) VALUES
('T0001', 'M0002', '2019-11-01', 25000),
('T0002', 'M0007', '2019-10-31', 50000),
('T0003', 'M0006', '2019-11-01', 20000),
('T0004', 'M0017', '2019-11-02', 100000),
('T0005', 'M0010', '2019-10-29', 150000),
('T0006', 'M0024', '2019-10-17', 50000),
('T0007', 'M0019', '2019-09-19', 15000),
('T0008', 'M0001', '2019-09-22', 20000),
('T0009', 'M0030', '2019-10-06', 30000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`IDBARANG`),
  ADD KEY `FK_BERKATEGORI` (`IDKATEGORI`),
  ADD KEY `FK_RELATIONSHIP_17` (`IDMEREK`);

--
-- Indexes for table `detailbarang`
--
ALTER TABLE `detailbarang`
  ADD PRIMARY KEY (`NODETAIL`,`IDBARANG`),
  ADD KEY `FK_RELATIONSHIP_14` (`IDBARANG`);

--
-- Indexes for table `detail_beli`
--
ALTER TABLE `detail_beli`
  ADD PRIMARY KEY (`IDBELI`,`IDBARANG`,`NODETAIL`),
  ADD KEY `FK_PUNYA` (`IDBELI`),
  ADD KEY `FK_KEDETAIL` (`IDBARANG`,`NODETAIL`);

--
-- Indexes for table `detail_jual`
--
ALTER TABLE `detail_jual`
  ADD PRIMARY KEY (`IDJUAL`,`NODETAIL`),
  ADD KEY `FK_RELATIONSHIP_9` (`NODETAIL`),
  ADD KEY `FK_JUALKEDETAIL` (`IDBARANG`,`NODETAIL`);

--
-- Indexes for table `detail_retur`
--
ALTER TABLE `detail_retur`
  ADD PRIMARY KEY (`NORETUR`,`IDBARANG`,`NODETAIL`),
  ADD KEY `FK_RELATIONSHIP_20` (`NODETAIL`),
  ADD KEY `FK_BARANGRETUR` (`IDBARANG`,`NODETAIL`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`IDJABATAN`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`IDKATEGORI`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`IDMEMBER`);

--
-- Indexes for table `merek`
--
ALTER TABLE `merek`
  ADD PRIMARY KEY (`IDMEREK`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`IDPEG`),
  ADD KEY `FK_MENJABAT` (`IDJABATAN`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`IDBELI`),
  ADD KEY `FK_OLEH` (`IDSUPPLIER`),
  ADD KEY `FK_RELATIONSHIP_10` (`IDPEG`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`IDJUAL`),
  ADD KEY `FK_RELATIONSHIP_11` (`IDPEG`),
  ADD KEY `FK_RELATIONSHIP_12` (`IDMEMBER`);

--
-- Indexes for table `pricelist`
--
ALTER TABLE `pricelist`
  ADD PRIMARY KEY (`IDBARANG`,`IDSUPPLIER`),
  ADD KEY `FK_RELATIONSHIP_16` (`IDSUPPLIER`);

--
-- Indexes for table `returpembelian`
--
ALTER TABLE `returpembelian`
  ADD PRIMARY KEY (`NORETUR`),
  ADD KEY `FK_RELATIONSHIP_19` (`IDSUPPLIER`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`IDSUPPLIER`);

--
-- Indexes for table `topupsaldo`
--
ALTER TABLE `topupsaldo`
  ADD PRIMARY KEY (`IDTOPUP`),
  ADD KEY `FK_RELATIONSHIP_13` (`IDMEMBER`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `FK_BERKATEGORI` FOREIGN KEY (`IDKATEGORI`) REFERENCES `kategori` (`IDKATEGORI`),
  ADD CONSTRAINT `FK_RELATIONSHIP_17` FOREIGN KEY (`IDMEREK`) REFERENCES `merek` (`IDMEREK`);

--
-- Constraints for table `detailbarang`
--
ALTER TABLE `detailbarang`
  ADD CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`IDBARANG`) REFERENCES `barang` (`IDBARANG`);

--
-- Constraints for table `detail_beli`
--
ALTER TABLE `detail_beli`
  ADD CONSTRAINT `FK_KEDETAIL` FOREIGN KEY (`IDBARANG`,`NODETAIL`) REFERENCES `detailbarang` (`IDBARANG`, `NODETAIL`),
  ADD CONSTRAINT `FK_PUNYA` FOREIGN KEY (`IDBELI`) REFERENCES `pembelian` (`IDBELI`);

--
-- Constraints for table `detail_jual`
--
ALTER TABLE `detail_jual`
  ADD CONSTRAINT `FK_JUALKEDETAIL` FOREIGN KEY (`IDBARANG`,`NODETAIL`) REFERENCES `detailbarang` (`IDBARANG`, `NODETAIL`),
  ADD CONSTRAINT `FK_MEMILIKI` FOREIGN KEY (`IDJUAL`) REFERENCES `penjualan` (`IDJUAL`);

--
-- Constraints for table `detail_retur`
--
ALTER TABLE `detail_retur`
  ADD CONSTRAINT `FK_BARANGRETUR` FOREIGN KEY (`IDBARANG`,`NODETAIL`) REFERENCES `detailbarang` (`IDBARANG`, `NODETAIL`),
  ADD CONSTRAINT `FK_MERETUR` FOREIGN KEY (`NORETUR`) REFERENCES `returpembelian` (`NORETUR`);

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `FK_MENJABAT` FOREIGN KEY (`IDJABATAN`) REFERENCES `jabatan` (`IDJABATAN`);

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `FK_OLEH` FOREIGN KEY (`IDSUPPLIER`) REFERENCES `supplier` (`IDSUPPLIER`),
  ADD CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`IDPEG`) REFERENCES `pegawai` (`IDPEG`);

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `FK_RELATIONSHIP_11` FOREIGN KEY (`IDPEG`) REFERENCES `pegawai` (`IDPEG`),
  ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`IDMEMBER`) REFERENCES `member` (`IDMEMBER`);

--
-- Constraints for table `pricelist`
--
ALTER TABLE `pricelist`
  ADD CONSTRAINT `FK_RELATIONSHIP_15` FOREIGN KEY (`IDBARANG`) REFERENCES `barang` (`IDBARANG`),
  ADD CONSTRAINT `FK_RELATIONSHIP_16` FOREIGN KEY (`IDSUPPLIER`) REFERENCES `supplier` (`IDSUPPLIER`);

--
-- Constraints for table `returpembelian`
--
ALTER TABLE `returpembelian`
  ADD CONSTRAINT `FK_RELATIONSHIP_19` FOREIGN KEY (`IDSUPPLIER`) REFERENCES `supplier` (`IDSUPPLIER`);

--
-- Constraints for table `topupsaldo`
--
ALTER TABLE `topupsaldo`
  ADD CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`IDMEMBER`) REFERENCES `member` (`IDMEMBER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
