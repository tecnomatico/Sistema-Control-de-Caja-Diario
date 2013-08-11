-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-08-2013 a las 15:39:09
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `control_caja`
--
CREATE DATABASE IF NOT EXISTS `control_caja` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `control_caja`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asociado`
--

CREATE TABLE IF NOT EXISTS `asociado` (
  `LEGAJO` int(11) NOT NULL,
  `MATRICULA` int(11) DEFAULT NULL,
  `CUIT` int(11) DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `APELLIDO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA_INGRESO` date DEFAULT NULL,
  `TELEFONO` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`LEGAJO`),
  KEY `MATRICULA` (`MATRICULA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE IF NOT EXISTS `concepto` (
  `CODIGO` int(11) NOT NULL,
  `DESCRIPCION` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cooperativa`
--

CREATE TABLE IF NOT EXISTS `cooperativa` (
  `MATRICULA` int(11) NOT NULL,
  `CUIT` int(11) DEFAULT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA_INGRESO` date DEFAULT NULL,
  `TELEFONO` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DOMICILIO` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`MATRICULA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diario`
--

CREATE TABLE IF NOT EXISTS `diario` (
  `FECHA` date NOT NULL,
  `SALDO_INICIAL` double DEFAULT NULL,
  `ID_ULTIMO_RECIBO` int(11) DEFAULT NULL,
  PRIMARY KEY (`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formulario`
--

CREATE TABLE IF NOT EXISTS `formulario` (
  `NUMERO_SERIE` int(11) NOT NULL,
  `CUIT` int(11) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `CODIGO_CONCEPTO` int(11) DEFAULT NULL,
  `CODIGO_FORMULARIO` int(11) DEFAULT NULL,
  `MONTO` double DEFAULT NULL,
  `NOMBRE` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`NUMERO_SERIE`),
  KEY `CODIGO_CONCEPTO` (`CODIGO_CONCEPTO`),
  KEY `CODIGO_FORMULARIO` (`CODIGO_FORMULARIO`),
  KEY `FECHA` (`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `CUIT` int(11) NOT NULL,
  `RAZON_SOCIAL` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`CUIT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_formulario`
--

CREATE TABLE IF NOT EXISTS `tipo_formulario` (
  `CODIGO` int(11) NOT NULL,
  `FORMULARIO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TIPO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ACCION` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asociado`
--
ALTER TABLE `asociado`
  ADD CONSTRAINT `asociado_ibfk_1` FOREIGN KEY (`MATRICULA`) REFERENCES `cooperativa` (`MATRICULA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `formulario`
--
ALTER TABLE `formulario`
  ADD CONSTRAINT `formulario_ibfk_1` FOREIGN KEY (`CODIGO_CONCEPTO`) REFERENCES `concepto` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `formulario_ibfk_2` FOREIGN KEY (`CODIGO_FORMULARIO`) REFERENCES `tipo_formulario` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `formulario_ibfk_3` FOREIGN KEY (`FECHA`) REFERENCES `diario` (`FECHA`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
