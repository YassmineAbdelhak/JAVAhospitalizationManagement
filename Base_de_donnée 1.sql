-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 19, 2021 at 03:40 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `id_consultation` int(11) NOT NULL AUTO_INCREMENT,
  `id_patient` int(25) NOT NULL,
  `dateCons` varchar(255) NOT NULL,
  `honoraire` varchar(25) NOT NULL,
  `cnam` varchar(25) NOT NULL,
  `cliché` varchar(255) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `consTxt` text NOT NULL,
  PRIMARY KEY (`id_consultation`),
  KEY `id_patient` (`id_patient`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `IdM` int(30) NOT NULL AUTO_INCREMENT,
  `IdMed` varchar(30) NOT NULL,
  `NomMed` varchar(30) NOT NULL,
  PRIMARY KEY (`IdM`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicament`
--

INSERT INTO `medicament` (`IdM`, `IdMed`, `NomMed`) VALUES
(15, 'id', 'Doliprane'),
(16, 'id', 'Panadole'),
(17, 'id', 'Aspirine'),
(18, 'id', 'Spasmocalme'),
(19, 'id', 'Voltaréne'),
(20, 'id', 'Clipal'),
(21, 'id', 'Rozal'),
(32, 'id', 'Adol');

-- --------------------------------------------------------

--
-- Table structure for table `ordo`
--

DROP TABLE IF EXISTS `ordo`;
CREATE TABLE IF NOT EXISTS `ordo` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `idL` int(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idL` (`idL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ordonnance`
--

DROP TABLE IF EXISTS `ordonnance`;
CREATE TABLE IF NOT EXISTS `ordonnance` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `Posologie` varchar(100) NOT NULL,
  `Qte` int(30) NOT NULL,
  `IdMed` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IdMed` (`IdMed`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ordonnance`
--

INSERT INTO `ordonnance` (`id`, `Posologie`, `Qte`, `IdMed`) VALUES
(1, 'abababa', 2, 1),
(2, 'lllllmlml', 1, 2),
(3, 'aaaaa', 1, 1),
(4, 'aaaaa', 1, 1),
(5, 'aaaaa', 1, 1),
(6, 'deux fois par jour', 2, 1),
(7, 'une fois la nuit', 1, 1),
(8, 'le matin', 2, 1),
(9, 'Deux fois par jour ', 2, 1),
(10, 'aaa', 4, 1),
(11, 'aa', 3, 1),
(12, 'aa', 3, 1),
(13, 'aa', 1, 1),
(14, 'a', 4, 1),
(15, 'aaaa', 5, 1),
(16, 'aa', 5, 1),
(17, 'aa', 5, 1),
(18, 'aa', 3, 1),
(19, 'aa', 3, 1),
(20, 'Deux fois par jour ', 2, 1),
(21, 'deux fois par hour', 2, 1),
(22, 'deux fois par hour', 2, 1),
(23, '2 fois par jour', 2, 1),
(24, '2 fois par Jour', 2, 1),
(25, '2 fois par jour', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nip` int(11) NOT NULL,
  `num_imm` varchar(25) NOT NULL,
  `sexe` varchar(25) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `dateNai` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `adressé_par` varchar(255) NOT NULL,
  `code_postale` int(11) NOT NULL,
  `ville` varchar(25) NOT NULL,
  `civilite` varchar(25) NOT NULL,
  `grp_sng` varchar(25) NOT NULL,
  `sit_fam` varchar(25) NOT NULL,
  `nb_enf` int(11) NOT NULL,
  `profession` varchar(255) NOT NULL,
  `tel_dom` int(11) NOT NULL,
  `tel_prof` int(11) NOT NULL,
  `tel_portable` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `nip`, `num_imm`, `sexe`, `nom`, `prenom`, `photo`, `dateNai`, `email`, `adresse`, `adressé_par`, `code_postale`, `ville`, `civilite`, `grp_sng`, `sit_fam`, `nb_enf`, `profession`, `tel_dom`, `tel_prof`, `tel_portable`) VALUES
(17, 8888, '12345', 'Homme', 'mohamed Hatem', 'belhaj', 'C:\\Users\\USER\\Desktop\\manT.png', '30-10-1990', 'hatembelhaj@gmail.com', 'monastir, teboulba, bodriss', 'Kaouther Belaalia', 5080, 'teboulba', 'Mr.', 'O+', 'Marié ', 1, 'professeur', 735548, 73655488, 98677248),
(15, 326687, '140018', 'Femme', 'fff', 'ffff', 'C:\\Users\\USER\\Desktop\\femaleT.png', '01-02-2019', 'fffff', 'qqq', 'maha ben amor', 123, 'qq', 'Mlle.', 'A+', 'Célibataire ', 0, 'dsdd', 1212, 1212, 12545),
(14, 8555555, '7777777', 'Homme', 'z', 'szsz', 'C:\\Users\\USER\\Desktop\\femaleT.png', '01-02-1998', 'szszs', 'zszs', 'maha ben amor', 12, 'zsz', 'Mr.', 'A+', 'Marié ', 1111, 'ssssssssss', 4444, 4444, 1111),
(18, 9999, '12345678', 'Femme', 'belamor', 'imen', 'C:\\Users\\USER\\Desktop\\femaleT.png', '21-03-1996', 'imenbelamor@gmail.com', 'tafella', 'wiem chebaane', 203, 'sousse', 'Mlle.', 'B-', 'Célibataire ', 0, 'étudiante', 736669, 7325548, 2399947),
(7, 90, '2', 'Homme', 'ahmed', 'bashir', 'C:\\Users\\USER\\Desktop\\female.png', '01-02-1996', 'ahmed@gmail.com', 'tafela', 'ashref gadour', 5080, 'sousse', 'Mr.', 'B+', 'Célibataire ', 0, 'étudiant', 7888421, 73555574, 9965548),
(11, 17777, '77777', 'Femme', 'lklk', 'kl', 'C:\\Users\\USER\\Desktop\\female.png', '01-02-1990', 'ljlj', 'hhh', 'Kaouther Belaalia', 154, 'kk', 'Mlle.', 'A+', 'Divorcé ', 0, 'lj', 5464, 7895, 545),
(12, 7555, '75555555', 'Homme', 'k', 's', 'C:\\Users\\USER\\Desktop\\manT.png', '01-02-1998', 's', 'sss', 'Docteur...', 5000, 'ss', 'Mr.', 'A-', 'Divorcé ', 0, 's', 787878, 78787, 7878),
(13, 753333, '59987', 'Femme', 'wqswsqw', 'xqsxqsx', 'C:\\Users\\USER\\Desktop\\female.png', '01-02-1995', 'xqsxqsx', 'swsw', 'Kaouther Belaalia', 205, 'qsxw', 'Mlle.', 'B+', 'Divorcé ', 545, 'qxqsx', 6646846, 54654, 6464);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD CONSTRAINT `IdMed` FOREIGN KEY (`IdMed`) REFERENCES `ordonnance` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
