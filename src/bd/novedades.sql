-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-09-2013 a las 16:17:52
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `novedades`
--
CREATE DATABASE IF NOT EXISTS `novedades` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `novedades`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE IF NOT EXISTS `concepto` (
  `cod_con` int(3) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `carga_usuario` tinyint(1) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  PRIMARY KEY (`cod_con`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `LEGAJO` int(4) NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `CUIT` int(12) NOT NULL,
  `COD_EMP` int(3) NOT NULL,
  `COD_SUC` int(3) NOT NULL,
  `convenio` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `tarea` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`LEGAJO`),
  KEY `FORANEA` (`COD_EMP`),
  KEY `COD_SUC` (`COD_SUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `COD_EMP` int(3) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `GERENTE` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `MAIL_GERENTE` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`COD_EMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedad`
--

CREATE TABLE IF NOT EXISTS `novedad` (
  `fecha` date NOT NULL,
  `legajo` int(4) NOT NULL,
  `cantidad` int(5) NOT NULL,
  `observacion` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `cod_con` int(3) NOT NULL,
  PRIMARY KEY (`fecha`),
  KEY `cod_emp` (`legajo`,`cod_con`),
  KEY `cod_con` (`cod_con`),
  KEY `legajo` (`legajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE IF NOT EXISTS `sucursal` (
  `cod_suc` int(3) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `cod_emp` int(3) NOT NULL,
  `legajo` int(4) NOT NULL,
  PRIMARY KEY (`cod_suc`),
  KEY `foranea` (`cod_emp`),
  KEY `foranea2` (`legajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int(11) NOT NULL,
  `LEGAJO` int(4) NOT NULL,
  `USUARIO` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `CONTRASEÑA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPCION` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `LEGAJO` (`LEGAJO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`COD_EMP`) REFERENCES `empresa` (`COD_EMP`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`COD_SUC`) REFERENCES `sucursal` (`cod_suc`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `novedad`
--
ALTER TABLE `novedad`
  ADD CONSTRAINT `novedad_ibfk_3` FOREIGN KEY (`legajo`) REFERENCES `empleados` (`LEGAJO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `novedad_ibfk_4` FOREIGN KEY (`cod_con`) REFERENCES `concepto` (`cod_con`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_ibfk_2` FOREIGN KEY (`legajo`) REFERENCES `empleados` (`LEGAJO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`cod_emp`) REFERENCES `empresa` (`COD_EMP`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`LEGAJO`) REFERENCES `empleados` (`LEGAJO`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
