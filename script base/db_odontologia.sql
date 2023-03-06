-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 03-03-2023 a las 14:17:45
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_odontologia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_odontograma`
--

CREATE TABLE `historial_odontograma` (
  `id_historial_odonto` bigint(20) NOT NULL,
  `id_ficha` bigint(20) DEFAULT NULL,
  `id_odontograma` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `odontoficha`
--

CREATE TABLE `odontoficha` (
  `id_ficha` bigint(20) NOT NULL,
  `diagnostico` varchar(100) NOT NULL,
  `fecha_consulta` date NOT NULL,
  `habilitado` bit(1) NOT NULL,
  `motivo_consulta` varchar(100) NOT NULL,
  `observaciones` varchar(100) NOT NULL,
  `id_persona` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `odontoficha`
--

INSERT INTO `odontoficha` (`id_ficha`, `diagnostico`, `fecha_consulta`, `habilitado`, `motivo_consulta`, `observaciones`, `id_persona`) VALUES
(19, 'qwe', '2023-03-03', b'1', 'qwe', 'qwe', 2),
(20, 'qwe', '2023-03-03', b'0', 'qwe', 'qwe', 6),
(21, 'qwe', '2023-03-03', b'1', 'qwe', 'qwe', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `odontograma`
--

CREATE TABLE `odontograma` (
  `id_odontograma` bigint(20) NOT NULL,
  `fecha_odontograma` date NOT NULL,
  `id_ficha` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `odontograma`
--

INSERT INTO `odontograma` (`id_odontograma`, `fecha_odontograma`, `id_ficha`) VALUES
(49, '2023-03-02', 19),
(50, '2023-03-03', 19),
(51, '2023-03-03', 20),
(52, '2023-03-03', 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_persona` bigint(20) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `celular` varchar(10) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `genero` varchar(255) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `apellido`, `cedula`, `celular`, `direccion`, `email`, `fecha_nacimiento`, `genero`, `nombre`, `telefono`) VALUES
(2, 'Siavichay', '0103156675', '0983018147', 'Ricaurte1', 'alexis.siavichay@tecazuay.edu.ec', '2002-06-06', 'Masculino', 'Mateo', '07-2476084'),
(5, 'Pinares', '0106045221', '0897777777', 'Americas1', 'juan@gmail.com', '1982-02-07', 'Masculino', 'Juan', '07-2145632'),
(6, 'Naula Quezada', '0103680435', '0888888888', 'Abdon Calderon3', 'CMYZTHZHR@juanpa.xyz', '2020-04-03', 'Femenino', 'Maria Gabriela', '21-4444444');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pieza`
--

CREATE TABLE `pieza` (
  `id_pieza` bigint(20) NOT NULL,
  `cara_pieza` varchar(15) NOT NULL,
  `fecha_consulta` datetime(6) DEFAULT NULL,
  `numero_pieza` varchar(10) NOT NULL,
  `nombre_tratamiento` varchar(30) NOT NULL,
  `id_odontograma` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pieza`
--

INSERT INTO `pieza` (`id_pieza`, `cara_pieza`, `fecha_consulta`, `numero_pieza`, `nombre_tratamiento`, `id_odontograma`) VALUES
(14, 'Vestibular', '2023-03-02 23:36:05.000000', '61', 'Apiceptomia', 49),
(15, 'Vestibular', '2023-03-03 01:27:22.000000', '53', 'Apiceptomia', 50),
(16, 'Vestibular', '2023-03-03 07:10:16.000000', '26', 'Apiceptomia', 51),
(17, 'Vestibular', '2023-03-03 07:10:53.000000', '25', 'Apiceptomia', 52);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `rol_id` bigint(20) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `rol_nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`rol_id`, `descripcion`, `rol_nombre`) VALUES
(1, 'Rol Asignado Para Pacientes', 'Paciente'),
(2, 'Rol Asignado Para Odontologos', 'Odontologo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(25) NOT NULL,
  `id_persona` bigint(20) DEFAULT NULL,
  `rol_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `enabled`, `password`, `username`, `id_persona`, `rol_id`) VALUES
(4, b'1', '1234', 'Pedro', 2, 1),
(7, b'1', 'alexceunca12', '0106045223', 5, 1),
(8, b'1', 'asdfghjkl', 'postgres', 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario_rol_id` bigint(20) NOT NULL,
  `rol_rol_id` bigint(20) DEFAULT NULL,
  `usuario_id_usuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historial_odontograma`
--
ALTER TABLE `historial_odontograma`
  ADD PRIMARY KEY (`id_historial_odonto`),
  ADD KEY `FKk1jimv8lbehrfkqmvdjy5sfup` (`id_ficha`),
  ADD KEY `FKcum4rgb5r05qot0m1iuojwrib` (`id_odontograma`);

--
-- Indices de la tabla `odontoficha`
--
ALTER TABLE `odontoficha`
  ADD PRIMARY KEY (`id_ficha`),
  ADD KEY `FK87f0p93syqsrsj17lagk3gwl1` (`id_persona`);

--
-- Indices de la tabla `odontograma`
--
ALTER TABLE `odontograma`
  ADD PRIMARY KEY (`id_odontograma`),
  ADD KEY `FKimymlpi6ag8bbnx4xbkjo3sir` (`id_ficha`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`);

--
-- Indices de la tabla `pieza`
--
ALTER TABLE `pieza`
  ADD PRIMARY KEY (`id_pieza`),
  ADD KEY `FKfl2d4hflh4fh6drhppmq1t022` (`id_odontograma`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`rol_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FKagix3q8yqktlyj3yp1sn0mcd9` (`id_persona`),
  ADD KEY `FKehtf9w9752mgyxuamu1649laq` (`rol_id`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario_rol_id`),
  ADD KEY `FK7j1tyvjj1tv8gbq7n6f7efccc` (`rol_rol_id`),
  ADD KEY `FKpcxpmhgrf0w0c8u3pouxaqttw` (`usuario_id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_odontograma`
--
ALTER TABLE `historial_odontograma`
  MODIFY `id_historial_odonto` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `odontoficha`
--
ALTER TABLE `odontoficha`
  MODIFY `id_ficha` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `odontograma`
--
ALTER TABLE `odontograma`
  MODIFY `id_odontograma` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id_persona` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `pieza`
--
ALTER TABLE `pieza`
  MODIFY `id_pieza` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `rol_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  MODIFY `usuario_rol_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial_odontograma`
--
ALTER TABLE `historial_odontograma`
  ADD CONSTRAINT `FKcum4rgb5r05qot0m1iuojwrib` FOREIGN KEY (`id_odontograma`) REFERENCES `odontograma` (`id_odontograma`),
  ADD CONSTRAINT `FKk1jimv8lbehrfkqmvdjy5sfup` FOREIGN KEY (`id_ficha`) REFERENCES `odontoficha` (`id_ficha`);

--
-- Filtros para la tabla `odontoficha`
--
ALTER TABLE `odontoficha`
  ADD CONSTRAINT `FK87f0p93syqsrsj17lagk3gwl1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);

--
-- Filtros para la tabla `odontograma`
--
ALTER TABLE `odontograma`
  ADD CONSTRAINT `FKimymlpi6ag8bbnx4xbkjo3sir` FOREIGN KEY (`id_ficha`) REFERENCES `odontoficha` (`id_ficha`);

--
-- Filtros para la tabla `pieza`
--
ALTER TABLE `pieza`
  ADD CONSTRAINT `FKfl2d4hflh4fh6drhppmq1t022` FOREIGN KEY (`id_odontograma`) REFERENCES `odontograma` (`id_odontograma`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FKagix3q8yqktlyj3yp1sn0mcd9` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `FKehtf9w9752mgyxuamu1649laq` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`rol_id`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK7j1tyvjj1tv8gbq7n6f7efccc` FOREIGN KEY (`rol_rol_id`) REFERENCES `roles` (`rol_id`),
  ADD CONSTRAINT `FKpcxpmhgrf0w0c8u3pouxaqttw` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
