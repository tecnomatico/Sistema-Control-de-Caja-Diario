-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-09-2013 a las 15:48:16
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
  `idAsociado` int(11) NOT NULL AUTO_INCREMENT,
  `idCoop` int(11) DEFAULT NULL,
  `legajo` int(11) NOT NULL,
  `cuit` bigint(20) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `apellido` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ingreso` date DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` int(2) DEFAULT NULL,
  PRIMARY KEY (`idAsociado`),
  UNIQUE KEY `legajo` (`legajo`),
  UNIQUE KEY `cuit` (`cuit`),
  UNIQUE KEY `dni` (`dni`),
  KEY `idCoop` (`idCoop`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `asociado`
--

INSERT INTO `asociado` (`idAsociado`, `idCoop`, `legajo`, `cuit`, `dni`, `apellido`, `nombre`, `ingreso`, `telefono`, `estado`) VALUES
(1, NULL, 1, 1, 1, 'PELAEZ', 'JOEL', '2013-09-13', '', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` bigint(20) NOT NULL,
  `razonSocial` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilio` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` int(2) DEFAULT NULL,
 `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,  
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `cuit` (`cuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE IF NOT EXISTS `comprobante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numeroSerie` bigint(20) NOT NULL,
  `cuit` bigint(20) DEFAULT NULL,
  `tipoPersona` int(2) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `codigoTipoComprob` int(11) DEFAULT NULL,
  `tipoProceso` int(2) DEFAULT NULL,
  `ejercicioEconomico` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numeroSerie` (`numeroSerie`),
  KEY `codigoTipoComprob` (`codigoTipoComprob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobanteconcepto`
--

CREATE TABLE IF NOT EXISTS `comprobanteconcepto` (
  `id` int(11) NOT NULL,
  `idComprobante` int(11) DEFAULT NULL,
  `idConcepto` int(11) DEFAULT NULL,
  `monto` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idConcepto` (`idConcepto`),
  KEY `idComprobante` (`idComprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE IF NOT EXISTS `concepto` (
  `codigoConcepto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`codigoConcepto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`codigoConcepto`, `descripcion`) VALUES
(1, 'monotributo'),
(2, 'desarrollo de software a medida'),
(3, 'capacitacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cooperativa`
--

CREATE TABLE IF NOT EXISTS `cooperativa` (
  `idCoop` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` int(11) NOT NULL,
  `cuit` bigint(20) DEFAULT NULL,
  `razonSocial` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioActividad` date DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilio` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicioCaja` double DEFAULT NULL,
  `ingresoBruto` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idCoop`),
  UNIQUE KEY `matricula` (`matricula`),
  UNIQUE KEY `cuit` (`cuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` bigint(20) NOT NULL,
  `razonSocial` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilio` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` int(2) DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,  
PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `cuit` (`cuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocomprobante`
--

CREATE TABLE IF NOT EXISTS `tipocomprobante` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `formulario` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `referencia` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `detalleConcepto` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `formulario` (`formulario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tipocomprobante`
--

INSERT INTO `tipocomprobante` (`codigo`, `formulario`, `referencia`, `detalleConcepto`) VALUES
(1, 'RECIBO A', 'RA', NULL),
(2, 'RECIBO B', 'RB', NULL);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asociado`
--
ALTER TABLE `asociado`
  ADD CONSTRAINT `asociado_ibfk_1` FOREIGN KEY (`idCoop`) REFERENCES `cooperativa` (`idCoop`);

--
-- Filtros para la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD CONSTRAINT `comprobante_ibfk_1` FOREIGN KEY (`codigoTipoComprob`) REFERENCES `tipocomprobante` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `comprobanteconcepto`
--
ALTER TABLE `comprobanteconcepto`
  ADD CONSTRAINT `comprobanteconcepto_ibfk_1` FOREIGN KEY (`idConcepto`) REFERENCES `concepto` (`codigoConcepto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comprobanteconcepto_ibfk_2` FOREIGN KEY (`idComprobante`) REFERENCES `comprobante` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
