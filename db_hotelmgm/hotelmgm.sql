-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Mar 16, 2018 alle 18:17
-- Versione del server: 5.6.26
-- Versione PHP: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelmgm`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `associa`
--

CREATE TABLE IF NOT EXISTS `associa` (
  `CodCliente` int(11) NOT NULL,
  `CodPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `associa`
--

INSERT INTO `associa` (`CodCliente`, `CodPersona`) VALUES
(1, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(4, 6),
(4, 7),
(4, 8),
(5, 9),
(6, 10),
(6, 11),
(6, 12),
(6, 13),
(6, 14),
(6, 15),
(6, 16),
(7, 17),
(8, 18),
(8, 19),
(8, 20),
(9, 21),
(10, 22),
(10, 23);

-- --------------------------------------------------------

--
-- Struttura della tabella `calendario`
--

CREATE TABLE IF NOT EXISTS `calendario` (
  `IDcalendario` int(11) NOT NULL,
  `DataInizio` varchar(10) NOT NULL,
  `DataFine` varchar(10) NOT NULL,
  `CodCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `calendario`
--

INSERT INTO `calendario` (`IDcalendario`, `DataInizio`, `DataFine`, `CodCliente`) VALUES
(20, '20/05/2011', '28/05/2011', 3),
(21, '20/05/2011', '27/05/2011', 5),
(22, '20/05/2011', '24/05/2011', 7),
(23, '20/05/2011', '30/05/2011', 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `camera`
--

CREATE TABLE IF NOT EXISTS `camera` (
  `Numero` int(11) NOT NULL,
  `Piano` int(11) NOT NULL,
  `NumLetti` int(11) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Stato` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `camera`
--

INSERT INTO `camera` (`Numero`, `Piano`, `NumLetti`, `Tipo`, `Stato`) VALUES
(100, 1, 1, 'Singola', 1),
(101, 1, 1, 'Singola', 0),
(102, 1, 1, 'Singola', 0),
(103, 1, 1, 'Singola', 0),
(104, 1, 1, 'Singola', 1),
(105, 1, 2, 'Doppia', 0),
(106, 1, 2, 'Doppia', 0),
(107, 1, 2, 'Doppia', 0),
(108, 1, 2, 'Doppia', 0),
(109, 1, 2, 'Doppia', 1),
(110, 1, 2, 'Matrimoniale', 1),
(200, 2, 2, 'Matrimoniale', 0),
(201, 2, 2, 'Matrimoniale', 0),
(202, 2, 2, 'Matrimoniale', 0),
(203, 2, 2, 'Matrimoniale', 0),
(204, 2, 3, 'Tripla', 0),
(205, 2, 3, 'Tripla', 0),
(206, 2, 3, 'Tripla', 0),
(207, 2, 3, 'Tripla', 0),
(208, 2, 4, 'Quadrupla', 0),
(209, 2, 4, 'Quadrupla', 0),
(210, 2, 4, 'Quadrupla', 0),
(300, 3, 4, 'Quadrupla', 0),
(301, 3, 5, 'Multipla', 0),
(302, 3, 5, 'Multipla', 0),
(303, 3, 5, 'Multipla', 0),
(304, 3, 5, 'Multipla', 0),
(305, 3, 5, 'Multipla', 0),
(306, 3, 2, 'Suite', 0),
(307, 3, 2, 'Suite', 0),
(308, 3, 3, 'Suite', 0),
(309, 3, 4, 'Suite', 0),
(310, 3, 5, 'Suite', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `Cod` int(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `LuogoNascita` varchar(20) NOT NULL,
  `Provincia` varchar(20) NOT NULL,
  `DataNascita` varchar(10) NOT NULL,
  `NumCartaID` varchar(20) DEFAULT NULL,
  `CodFiscale` varchar(20) DEFAULT NULL,
  `Nazionalita` varchar(20) DEFAULT NULL,
  `Sesso` varchar(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`Cod`, `Nome`, `Cognome`, `LuogoNascita`, `Provincia`, `DataNascita`, `NumCartaID`, `CodFiscale`, `Nazionalita`, `Sesso`) VALUES
(1, 'Rizziero', 'Gaeta', 'Salerno', 'Salerno', '19/05/1979', 'AG0897654345', 'GTARZR89E19H703 A', 'Italiana', 'M'),
(2, 'Roberto', 'Sessa', 'Nocera Inferiore', 'Salerno', '23/10/1958', 'AC5749465909', 'SSSRRT86R23F912E  ', 'Italiana', 'M'),
(3, 'Marta', 'Citro', 'Napoli', 'Napoli', '05/06/1989', 'NA6485638294', 'MRTCTR89H45F839K  ', 'Italiana', 'F'),
(4, 'Daniele', 'Pierri', 'Bologna', 'Bologna', '05/07/1960', 'BO34657563849', 'DNLPRR86E05A944P  ', 'Italiana', 'M'),
(5, 'Elena', 'Landi', 'Monaco', 'Monaco', '17/09/1978', 'MO57376357394', 'LNELND88P57Z123Q   ', 'Tedesca', 'F'),
(6, 'Andrea', 'Cantarella', 'Avellino', 'Avellino', '29/08/1959', 'AV46484657548', 'NDRCTR89M29A509L  ', 'Italiana', 'M'),
(7, 'Andrea', 'Merola', 'Curteri', 'Salerno', '04/04/1984', 'SA57474384735483', 'MRLNDR99D04F138T   ', 'Italiana', 'M'),
(8, 'Mario', 'Rossi', 'Roma', 'Roma', '26/03/1956', 'AL956768', 'MRARSSE58TYW471G', 'Italiana', 'M'),
(9, 'Francesco', 'Verdi', 'Montoro Inferiore', 'Avellino', '02/11/1977', 'AY575768', 'FRNVRD5E58TY471P', 'Italiana', 'M'),
(10, 'Carlo', 'Neri', 'Venosa', 'Potenza', '08/12/1968', 'ER575768', 'CRLNRE5E88TS471Z', 'Italiana', 'M'),
(11, 'Michele', 'Bianchi', 'Mestre', 'Venezia', '17/01/1981', 'OT575734', 'MCHBNC7E3PCR471F', 'Italiana', 'M'),
(13, 'Mario', 'Mariotti', 'Napoli', 'Na', '12/15/2001', 'forpehiper', 'rgtrgtkgjktrgj', 'Italiana', 'M'),
(14, 'Luigi', 'Cutolo', 'Salerno', 'SA', '20/01/1985', 'gdfgdf', 'gfhfgdghf', 'Italiana', 'M');

-- --------------------------------------------------------

--
-- Struttura della tabella `extra`
--

CREATE TABLE IF NOT EXISTS `extra` (
  `Cod` int(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Prezzo` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `extra`
--

INSERT INTO `extra` (`Cod`, `Nome`, `Prezzo`) VALUES
(1, 'Caffe', 0.7),
(2, 'Cappuccino', 1),
(3, 'Pizza Margherita', 3),
(4, 'Croccantelle', 0.5),
(6, 'Cornetto', 0.8),
(7, 'Patatine', 1),
(8, 'Coca Cola', 1),
(9, 'Cioccolata', 1.2),
(10, 'Spremuta', 2),
(11, 'Hot Dog', 3),
(12, 'Primo Piatto', 3),
(13, 'Secondo Piatto', 3),
(14, 'Contorno', 1),
(15, 'Vino', 2),
(16, 'Frutta', 0.5),
(17, 'Caffe corretto', 1.5),
(18, 'Acqua', 0.4),
(19, 'Gelato', 1),
(20, 'Torte', 10),
(21, 'Dolce', 2),
(22, 'Succo di Frutta', 1),
(23, 'Yogurt', 1),
(25, 'Sigari', 4),
(27, 'Ricarica Vodafone', 10),
(28, 'Ricarica Wind', 10),
(29, 'Ricarica Tim', 10),
(30, 'Ricarica 3', 10),
(31, 'Birra', 2.5),
(32, 'Spumante', 50);

-- --------------------------------------------------------

--
-- Struttura della tabella `ha`
--

CREATE TABLE IF NOT EXISTS `ha` (
  `Numero` int(11) NOT NULL,
  `CodCliente` int(11) NOT NULL,
  `CodExtra` int(11) NOT NULL,
  `DataConsumazione` varchar(10) DEFAULT NULL,
  `Quantita` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `ha`
--

INSERT INTO `ha` (`Numero`, `CodCliente`, `CodExtra`, `DataConsumazione`, `Quantita`) VALUES
(101, 3, 21, '11/04/2011', 1),
(101, 3, 3, '11/04/2011', 1),
(105, 5, 2, '11/04/2011', 2),
(105, 5, 11, '11/04/2011', 2),
(105, 5, 3, '11/04/2011', 2),
(110, 7, 1, '11/04/2011', 2),
(110, 7, 6, '11/04/2011', 2),
(110, 7, 3, '11/04/2011', 2),
(204, 10, 2, '11/04/2011', 3),
(204, 10, 19, '11/04/2011', 1),
(204, 10, 22, '11/04/2011', 3),
(105, 5, 3, '12/04/2011', 3),
(105, 5, 3, '22/04/2011', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `Cod` int(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `LuogoNascita` varchar(20) NOT NULL,
  `Provincia` varchar(20) NOT NULL,
  `DataNascita` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `persona`
--

INSERT INTO `persona` (`Cod`, `Nome`, `Cognome`, `LuogoNascita`, `Provincia`, `DataNascita`) VALUES
(1, 'Rosa', 'Buono', 'Pontecagnano', 'Salerno', '23/06/1989'),
(2, 'Marco', 'Sessa', 'Scafati', 'Salerno', '10/11/1993'),
(3, 'Ugo', 'Sessa', 'Pompei', 'Napoli', '31/07/1987'),
(4, 'Carmela', 'Sessa', 'Scafati', 'Salerno', '28/02/1990'),
(5, 'Giuseppina', 'Russo', 'Nocera Inferiore', 'Salerno', '09/09/1960'),
(6, 'Marta', 'Pierri', 'Bologna', 'Bologna', '07/08/1996'),
(7, 'Francesco', 'Pierri', 'Rimini', 'Rimini', '27/12/1993'),
(8, 'Anna', 'Di Lorenzo', 'Bologna', 'Bologna', '22/11/1962'),
(9, 'Katrin', 'Muller', 'Berlino', 'Berlino', '06/05/1978'),
(10, 'Benedetta', 'Cantarella', 'Salerno', 'Salerno', '03/09/1994'),
(11, 'Simone', 'Cantarella', 'Baronissi', 'Salerno', '15/12/1992'),
(12, 'Martina', 'Cantarella', 'San Severino', 'Salerno', '14/01/1986'),
(13, 'Francesca', 'Cantarella', 'Battipaglia', 'Salerno', '19/07/1989'),
(14, 'Emiliana', 'Marino', 'Salerno', 'Salerno', '24/08/1961'),
(15, 'Anna', 'Persano', 'Eboli', 'Salerno', '25/12/1933'),
(16, 'Domenico', 'Marino', 'Agropoli', 'Salerno', '21/04/1929'),
(17, 'Sara', 'Costantino', 'San Severino', 'Salerno', '18/03/1989'),
(18, 'Nicola', 'Rossi', 'Roma', 'Roma', '17/07/1987'),
(19, 'Elena', 'Rossi', 'Roma', 'Roma', '13/01/1990'),
(20, 'Giovanna', 'Cerrato', 'Gaeta', 'Latina', '01/05/1960'),
(21, 'Gilda', 'Trezza', 'Salerno', 'Salerno', '21/11/1990'),
(22, 'Roberta', 'Capri', 'Sala Consilina', 'Salerno', '07/07/1973'),
(23, 'Nicola', 'Neri', 'Avellino', 'Avellino', '03/04/2003');

-- --------------------------------------------------------

--
-- Struttura della tabella `possiede`
--

CREATE TABLE IF NOT EXISTS `possiede` (
  `IDcalendario` int(11) NOT NULL,
  `Numero` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `possiede`
--

INSERT INTO `possiede` (`IDcalendario`, `Numero`) VALUES
(20, 101),
(21, 105),
(22, 110),
(23, 204);

-- --------------------------------------------------------

--
-- Struttura della tabella `prenota`
--

CREATE TABLE IF NOT EXISTS `prenota` (
  `Cod` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `DataInizio` varchar(10) NOT NULL,
  `DataFine` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prenota`
--

INSERT INTO `prenota` (`Cod`, `Numero`, `DataInizio`, `DataFine`) VALUES
(3, 101, '20/05/2011', '28/05/2011'),
(5, 105, '20/05/2011', '27/05/2011'),
(7, 110, '20/05/2011', '24/05/2011'),
(10, 204, '20/05/2011', '30/05/2011'),
(2, 301, '25/07/2011', '10/08/2011'),
(4, 208, '18/07/2011', '30/07/2011'),
(5, 106, '25/07/2011', '07/08/2011'),
(5, 106, '01/10/2011', '10/10/2011'),
(6, 208, '01/08/2011', '17/08/2011'),
(6, 201, '01/08/2011', '17/08/2011'),
(6, 202, '01/08/2011', '17/08/2011'),
(7, 200, '06/06/2011', '20/06/2011'),
(7, 200, '01/09/2011', '12/09/2011'),
(8, 208, '26/06/2011', '15/07/2011'),
(9, 200, '11/07/2011', '28/07/2011'),
(10, 205, '06/08/2011', '16/08/2011'),
(11, 102, '02/06/2011', '07/06/2011'),
(1, 200, '01/08/2011', '19/08/2011');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `associa`
--
ALTER TABLE `associa`
  ADD KEY `CodCliente` (`CodCliente`),
  ADD KEY `CodPersona` (`CodPersona`);

--
-- Indici per le tabelle `calendario`
--
ALTER TABLE `calendario`
  ADD PRIMARY KEY (`IDcalendario`);

--
-- Indici per le tabelle `camera`
--
ALTER TABLE `camera`
  ADD PRIMARY KEY (`Numero`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Cod`);

--
-- Indici per le tabelle `extra`
--
ALTER TABLE `extra`
  ADD PRIMARY KEY (`Cod`),
  ADD UNIQUE KEY `Nome` (`Nome`);

--
-- Indici per le tabelle `ha`
--
ALTER TABLE `ha`
  ADD KEY `Numero` (`Numero`),
  ADD KEY `CodCliente` (`CodCliente`),
  ADD KEY `CodExtra` (`CodExtra`);

--
-- Indici per le tabelle `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`Cod`);

--
-- Indici per le tabelle `possiede`
--
ALTER TABLE `possiede`
  ADD KEY `IDcalendario` (`IDcalendario`),
  ADD KEY `Numero` (`Numero`);

--
-- Indici per le tabelle `prenota`
--
ALTER TABLE `prenota`
  ADD KEY `Cod` (`Cod`),
  ADD KEY `Numero` (`Numero`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `calendario`
--
ALTER TABLE `calendario`
  MODIFY `IDcalendario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT per la tabella `extra`
--
ALTER TABLE `extra`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT per la tabella `persona`
--
ALTER TABLE `persona`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT per la tabella `possiede`
--
ALTER TABLE `possiede`
  MODIFY `IDcalendario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `associa`
--
ALTER TABLE `associa`
  ADD CONSTRAINT `associa_ibfk_1` FOREIGN KEY (`CodCliente`) REFERENCES `cliente` (`Cod`),
  ADD CONSTRAINT `associa_ibfk_2` FOREIGN KEY (`CodPersona`) REFERENCES `persona` (`Cod`);

--
-- Limiti per la tabella `ha`
--
ALTER TABLE `ha`
  ADD CONSTRAINT `ha_ibfk_1` FOREIGN KEY (`Numero`) REFERENCES `camera` (`Numero`),
  ADD CONSTRAINT `ha_ibfk_2` FOREIGN KEY (`CodCliente`) REFERENCES `cliente` (`Cod`),
  ADD CONSTRAINT `ha_ibfk_3` FOREIGN KEY (`CodExtra`) REFERENCES `extra` (`Cod`);

--
-- Limiti per la tabella `possiede`
--
ALTER TABLE `possiede`
  ADD CONSTRAINT `possiede_ibfk_1` FOREIGN KEY (`IDcalendario`) REFERENCES `calendario` (`IDcalendario`),
  ADD CONSTRAINT `possiede_ibfk_2` FOREIGN KEY (`Numero`) REFERENCES `camera` (`Numero`);

--
-- Limiti per la tabella `prenota`
--
ALTER TABLE `prenota`
  ADD CONSTRAINT `prenota_ibfk_1` FOREIGN KEY (`Cod`) REFERENCES `cliente` (`Cod`),
  ADD CONSTRAINT `prenota_ibfk_2` FOREIGN KEY (`Numero`) REFERENCES `camera` (`Numero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
