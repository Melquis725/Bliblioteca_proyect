-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 04-02-2021 a las 03:37:55
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE IF NOT EXISTS `estudiante` (
  `idLector` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`idLector`, `Nombre`, `Carrera`, `Telefono`) VALUES
(1, 'Alexis Sanchez', 'Informatica', '39245466'),
(2, 'Melquis Garcia', 'Informatica', '84752523'),
(3, 'Winston Javier', 'Informatica', '82726252');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

DROP TABLE IF EXISTS `libro`;
CREATE TABLE IF NOT EXISTS `libro` (
  `idLibro` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(30) DEFAULT NULL,
  `Area` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`idLibro`, `Titulo`, `Area`) VALUES
(1, 'Inteligencia Emocional', 'Psicologia'),
(2, 'Lenguaje y Literatura', 'Eapañol'),
(3, 'Teorema de Firulais', 'Algebra');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE IF NOT EXISTS `prestamo` (
  `idPrestamo` int(11) NOT NULL AUTO_INCREMENT,
  `idLector` int(11) NOT NULL,
  `idLibro` int(11) NOT NULL,
  `FechaPrestamo` timestamp NULL DEFAULT current_timestamp(),
  `FechaDevolucion` date DEFAULT NULL,
  `Devuelto` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idPrestamo`),
  KEY `idLector` (`idLector`),
  KEY `idLibro` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`idPrestamo`, `idLector`, `idLibro`, `FechaPrestamo`, `FechaDevolucion`, `Devuelto`) VALUES
(1, 1, 3, '2021-01-30 04:21:28', '2021-02-28', 'No'),
(2, 3, 3, '2021-01-30 04:34:31', '2021-02-15', 'No'),
(3, 2, 3, '2021-01-30 04:36:39', '2021-03-05', 'No');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`idLector`) REFERENCES `estudiante` (`idLector`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
