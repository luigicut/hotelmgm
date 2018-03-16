-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Mar 16, 2018 alle 18:18
-- Versione del server: 5.6.26
-- Versione PHP: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `account`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `Login` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `DataNascita` varchar(10) NOT NULL,
  `Ruolo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `account`
--

INSERT INTO `account` (`Login`, `Password`, `Nome`, `Cognome`, `DataNascita`, `Ruolo`) VALUES
('admin89', 'salerno89', 'Daniele', 'Calabro', '05/05/1989', 'Amministratore'),
('casa89', 'abitazione89', 'Raffaele', 'Costantino', '11/05/1989', 'Operatore livello2'),
('dottore85', 'unisa', 'Gabriele', 'Bavota', '19/11/1985', 'Amministratore'),
('fraorc', 'studente89', 'Francesco', 'Orciuoli', '09/08/1989', 'Operatore livello1'),
('manager', 'ingegneria', 'Andrea', 'De Lucia', '30/06/1968', 'Amministratore');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Login`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
