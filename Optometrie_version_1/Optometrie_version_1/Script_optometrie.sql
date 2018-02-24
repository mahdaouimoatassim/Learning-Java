-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2017 at 03:46 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `optometrie`
--

-- --------------------------------------------------------

--
-- Table structure for table `aquite`
--

CREATE TABLE `aquite` (
  `Nom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(30) COLLATE utf8_bin NOT NULL,
  `AVB_D` varchar(5) COLLATE utf8_bin NOT NULL,
  `AVB_G` varchar(5) COLLATE utf8_bin NOT NULL,
  `AC_D_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `AC_D_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `AC_D_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `AC_D_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `AC_G_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `AC_G_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `AC_G_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `AC_G_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `Biomicro_D` varchar(20) COLLATE utf8_bin NOT NULL,
  `Biomicro_G` varchar(20) COLLATE utf8_bin NOT NULL,
  `Fond_oeil_D` varchar(20) COLLATE utf8_bin NOT NULL,
  `Fond_oeil_G` varchar(20) COLLATE utf8_bin NOT NULL,
  `Javal_D_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `Javal_D_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `Javal_G_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `Javal_G_C` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `contactologie`
--

CREATE TABLE `contactologie` (
  `Nom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Type_lentille` varchar(30) COLLATE utf8_bin NOT NULL,
  `CL_D_R` varchar(10) COLLATE utf8_bin NOT NULL,
  `CL_D_D` varchar(10) COLLATE utf8_bin NOT NULL,
  `CL_D_P` varchar(10) COLLATE utf8_bin NOT NULL,
  `CL_D_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `CL_G_R` varchar(10) COLLATE utf8_bin NOT NULL,
  `CL_G_D` varchar(10) COLLATE utf8_bin NOT NULL,
  `CL_G_P` varchar(10) COLLATE utf8_bin NOT NULL,
  `CL_G_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `Date_port` date NOT NULL,
  `Marque` varchar(30) COLLATE utf8_bin NOT NULL,
  `Test_shcimer` varchar(30) COLLATE utf8_bin NOT NULL,
  `Allergies` varchar(50) COLLATE utf8_bin NOT NULL,
  `PF_D_R` varchar(10) COLLATE utf8_bin NOT NULL,
  `PF_D_D` varchar(10) COLLATE utf8_bin NOT NULL,
  `PF_D_P` varchar(10) COLLATE utf8_bin NOT NULL,
  `PF_D_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `PF_G_R` varchar(10) COLLATE utf8_bin NOT NULL,
  `PF_G_D` varchar(10) COLLATE utf8_bin NOT NULL,
  `PF_G_P` varchar(10) COLLATE utf8_bin NOT NULL,
  `PF_G_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `Suivi_medical` varchar(512) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `diagnostic`
--

CREATE TABLE `diagnostic` (
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Diagnostic_D` varchar(128) NOT NULL,
  `Diagnostic_G` varchar(128) NOT NULL,
  `AC_LD_S` varchar(10) NOT NULL,
  `AC_LD_C` varchar(10) NOT NULL,
  `AC_LD_Ax` varchar(10) NOT NULL,
  `AC_LD_Av` varchar(10) NOT NULL,
  `AC_LG_S` varchar(10) NOT NULL,
  `AC_LG_C` varchar(10) NOT NULL,
  `AC_LG_Ax` varchar(10) NOT NULL,
  `AC_LG_Av` varchar(10) NOT NULL,
  `AC_PD_S` varchar(10) NOT NULL,
  `AC_PD_C` varchar(10) NOT NULL,
  `AC_PD_Ax` varchar(10) NOT NULL,
  `AC_PD_P` varchar(10) NOT NULL,
  `AC_PG_S` varchar(10) NOT NULL,
  `AC_PG_C` varchar(10) NOT NULL,
  `AC_PG_Ax` varchar(10) NOT NULL,
  `AC_PG_P` varchar(10) NOT NULL,
  `AVB_LD` varchar(10) NOT NULL,
  `AVB_LG` varchar(10) NOT NULL,
  `AVB_PD` varchar(10) NOT NULL,
  `AVB_PG` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `enfant`
--

CREATE TABLE `enfant` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Age` varchar(10) COLLATE utf8_bin NOT NULL,
  `Numero_Telephone` varchar(12) COLLATE utf8_bin NOT NULL,
  `Montant_verse` int(11) NOT NULL,
  `Montant_restant` int(11) NOT NULL,
  `Medecin` varchar(30) COLLATE utf8_bin NOT NULL,
  `Adresse` varchar(128) COLLATE utf8_bin NOT NULL,
  `Predominance` varchar(30) COLLATE utf8_bin NOT NULL,
  `Date_consultation` date NOT NULL,
  `Antecedent` varchar(512) COLLATE utf8_bin NOT NULL,
  `Diagnostic` varchar(512) COLLATE utf8_bin NOT NULL,
  `SF_D_MV` varchar(10) COLLATE utf8_bin NOT NULL,
  `SF_D_MH` varchar(10) COLLATE utf8_bin NOT NULL,
  `SF_G_MV` varchar(10) COLLATE utf8_bin NOT NULL,
  `SF_G_MH` varchar(10) COLLATE utf8_bin NOT NULL,
  `SD_D_MV` varchar(10) COLLATE utf8_bin NOT NULL,
  `SD_D_MH` varchar(10) COLLATE utf8_bin NOT NULL,
  `SD_G_MV` varchar(10) COLLATE utf8_bin NOT NULL,
  `SD_G_MH` varchar(10) COLLATE utf8_bin NOT NULL,
  `Diagnostic_D` varchar(50) COLLATE utf8_bin NOT NULL,
  `Diagnostic_G` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `essai_correction`
--

CREATE TABLE `essai_correction` (
  `Nom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(30) COLLATE utf8_bin NOT NULL,
  `EC_LD_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_LD_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_LD_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_LD_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_LG_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_LG_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_LG_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_LG_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PD_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PD_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PD_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PD_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PG_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PG_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PG_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `EC_PG_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LD_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LD_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LD_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LD_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LG_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LG_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LG_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_LG_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PD_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PD_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PD_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PD_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PG_S` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PG_C` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PG_Ax` varchar(10) COLLATE utf8_bin NOT NULL,
  `CF_PG_Av` varchar(10) COLLATE utf8_bin NOT NULL,
  `Type_verre` varchar(30) COLLATE utf8_bin NOT NULL,
  `Teinte` varchar(30) COLLATE utf8_bin NOT NULL,
  `Suivi_medical` varchar(1024) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `lentille`
--

CREATE TABLE `lentille` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Age` varchar(10) COLLATE utf8_bin NOT NULL,
  `Numero_Telephone` varchar(12) COLLATE utf8_bin NOT NULL,
  `Montant_verse` int(11) NOT NULL,
  `Montant_restant` int(11) NOT NULL,
  `Adresse` varchar(128) COLLATE utf8_bin NOT NULL,
  `Date_consultation` date NOT NULL,
  `Kerato_D_RH` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_G_RH` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_D_RV` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_G_RV` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_D_inconu` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_G_inconu` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_D_axe` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_G_axe` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_D_difference` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_G_difference` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_D_p` varchar(10) COLLATE utf8_bin NOT NULL,
  `Kerato_G_p` varchar(10) COLLATE utf8_bin NOT NULL,
  `Biomicro_D` varchar(10) COLLATE utf8_bin NOT NULL,
  `Biomicro_G` varchar(10) COLLATE utf8_bin NOT NULL,
  `Fond_oeil_D` varchar(10) COLLATE utf8_bin NOT NULL,
  `Fond_oeil_G` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `lunette`
--

CREATE TABLE `lunette` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(256) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(256) COLLATE utf8_bin NOT NULL,
  `Age` varchar(20) COLLATE utf8_bin NOT NULL,
  `Adresse` varchar(256) COLLATE utf8_bin NOT NULL,
  `Montant` double NOT NULL,
  `MedecinTraitant` varchar(128) COLLATE utf8_bin NOT NULL,
  `Date` date NOT NULL,
  `VLDs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLDc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLDa` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLGs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLGc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLGa` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPDs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPDc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPDa` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPGs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPGc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPGa` varchar(10) COLLATE utf8_bin NOT NULL,
  `TypeVerre` varchar(20) COLLATE utf8_bin NOT NULL,
  `Teinte` varchar(20) COLLATE utf8_bin NOT NULL,
  `Montant_restant` int(11) NOT NULL,
  `telphone` varchar(12) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `progressive`
--

CREATE TABLE `progressive` (
  `Id` int(11) NOT NULL,
  `Nom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Prenom` varchar(30) COLLATE utf8_bin NOT NULL,
  `Age` varchar(5) COLLATE utf8_bin NOT NULL,
  `Telephone` varchar(12) COLLATE utf8_bin NOT NULL,
  `Montant_verse` int(11) NOT NULL,
  `Montant_restant` int(11) NOT NULL,
  `Date_Commande` date NOT NULL,
  `Type` varchar(30) COLLATE utf8_bin NOT NULL,
  `Fournisseur` varchar(30) COLLATE utf8_bin NOT NULL,
  `Addition` varchar(30) COLLATE utf8_bin NOT NULL,
  `Transition` varchar(30) COLLATE utf8_bin NOT NULL,
  `Adresse` varchar(128) COLLATE utf8_bin NOT NULL,
  `VLDs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLDc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLDa` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLGs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLGc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VLGa` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPDs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPDc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPDa` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPGs` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPGc` varchar(10) COLLATE utf8_bin NOT NULL,
  `VPGa` varchar(10) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `enfant`
--
ALTER TABLE `enfant`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `lentille`
--
ALTER TABLE `lentille`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `lunette`
--
ALTER TABLE `lunette`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `progressive`
--
ALTER TABLE `progressive`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `enfant`
--
ALTER TABLE `enfant`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `lentille`
--
ALTER TABLE `lentille`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `lunette`
--
ALTER TABLE `lunette`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=346;
--
-- AUTO_INCREMENT for table `progressive`
--
ALTER TABLE `progressive`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1092;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
