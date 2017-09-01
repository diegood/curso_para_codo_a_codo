-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-09-2017 a las 20:00:20
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `codo`
--
CREATE DATABASE IF NOT EXISTS `codo` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `codo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(45) NOT NULL DEFAULT '',
  `apellido` varchar(45) NOT NULL DEFAULT '',
  `documento` int(10) UNSIGNED NOT NULL DEFAULT '0',
  `id_pais` int(10) UNSIGNED NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombre`, `apellido`, `documento`, `id_pais`) VALUES
(1, 'Pepe', 'Pruebas', 123456, 1),
(2, 'carlos', 'intos', 321654, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE `paises` (
  `id` int(10) UNSIGNED NOT NULL,
  `iso` char(2) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`id`, `iso`, `nombre`) VALUES
(1, 'DZ', 'Argelia'),
(2, 'AR', 'Argentina'),
(3, 'AM', 'Armenia'),
(4, 'AW', 'Aruba'),
(5, 'BZ', 'Belice'),
(6, 'BJ', 'Benin'),
(7, 'BM', 'Bermudas'),
(8, 'BT', 'Bhután'),
(9, 'BO', 'Bolivia'),
(10, 'CM', 'Camerún'),
(11, 'CA', 'Canadá'),
(12, 'CF', 'República Centroafricana'),
(13, 'TD', 'Chad'),
(14, 'CZ', 'República Checa'),
(15, 'CL', 'Chile'),
(16, 'CN', 'China'),
(17, 'CY', 'Chipre'),
(18, 'CX', 'Isla de Navidad'),
(19, 'VA', 'Ciudad del Vaticano'),
(20, 'CC', 'Islas Cocos'),
(21, 'EG', 'Egipto'),
(22, 'SV', 'El Salvador'),
(23, 'AE', 'Emiratos Árabes Unidos'),
(24, 'ER', 'Eritrea'),
(25, 'SK', 'Eslovaquia'),
(26, 'SI', 'Eslovenia'),
(27, 'ES', 'España'),
(28, 'GD', 'Granada'),
(29, 'GR', 'Grecia'),
(30, 'GL', 'Groenlandia'),
(31, 'GP', 'Guadalupe'),
(32, 'GU', 'Guam'),
(33, 'GT', 'Guatemala'),
(34, 'GF', 'Guayana Francesa'),
(35, 'GN', 'Guinea'),
(36, 'PW', 'Palau'),
(37, 'PS', 'Palestina'),
(38, 'PA', 'Panamá'),
(39, 'PG', 'Papúa Nueva Guinea'),
(40, 'PY', 'Paraguay'),
(41, 'PE', 'Perú'),
(42, 'PN', 'Islas Pitcairn'),
(43, 'PF', 'Polinesia Francesa'),
(44, 'PL', 'Polonia'),
(45, 'PT', 'Portugal'),
(46, 'SC', 'Seychelles'),
(47, 'SL', 'Sierra Leona'),
(48, 'SG', 'Singapur'),
(49, 'SY', 'Siria'),
(50, 'SO', 'Somalia'),
(51, 'LK', 'Sri Lanka'),
(52, 'SZ', 'Suazilandia'),
(53, 'ZA', 'Sudáfrica'),
(54, 'SD', 'Sudán'),
(55, 'SE', 'Suecia'),
(56, 'CH', 'Suiza'),
(57, 'SR', 'Surinam');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nacionalidad` (`id_pais`) USING BTREE;

--
-- Indices de la tabla `paises`
--
ALTER TABLE `paises`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `paises`
--
ALTER TABLE `paises`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
