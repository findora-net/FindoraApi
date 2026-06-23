-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 23-06-2026 a las 08:51:28
-- Versión del servidor: 8.1.0
-- Versión de PHP: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `findora`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CATEGORY`
--

CREATE TABLE `CATEGORY` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `COMMENT`
--

CREATE TABLE `COMMENT` (
  `id` bigint NOT NULL,
  `post_id` bigint NOT NULL,
  `text` text NOT NULL,
  `created_at` date NOT NULL,
  `created_by` bigint NOT NULL,
  `is_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `IMAGE`
--

CREATE TABLE `IMAGE` (
  `num` int NOT NULL,
  `post_id` bigint NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LINK`
--

CREATE TABLE `LINK` (
  `num` int NOT NULL,
  `post_id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LOCATION`
--

CREATE TABLE `LOCATION` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `latitud` decimal(10,0) NOT NULL,
  `longitud` int NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` bigint NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `POST`
--

CREATE TABLE `POST` (
  `id` bigint NOT NULL,
  `location_id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `rate` int NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `category_id` bigint NOT NULL,
  `created_at` date NOT NULL,
  `created_by` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REACTION_COMMENT`
--

CREATE TABLE `REACTION_COMMENT` (
  `user_id` bigint NOT NULL,
  `comment_id` bigint NOT NULL,
  `type` enum('+','-') NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REACTION_POST`
--

CREATE TABLE `REACTION_POST` (
  `user_id` bigint NOT NULL,
  `post_id` bigint NOT NULL,
  `type` enum('-','+') NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REACTION_RESPONSE`
--

CREATE TABLE `REACTION_RESPONSE` (
  `user_id` bigint NOT NULL,
  `response_id` bigint NOT NULL,
  `type` enum('+','-') NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REPORT_COMMENT`
--

CREATE TABLE `REPORT_COMMENT` (
  `id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` bigint NOT NULL,
  `created_at` int NOT NULL,
  `comment_reported_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REPORT_LOCATION`
--

CREATE TABLE `REPORT_LOCATION` (
  `id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` bigint NOT NULL,
  `created_at` date NOT NULL,
  `location_reported_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REPORT_POST`
--

CREATE TABLE `REPORT_POST` (
  `id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` bigint NOT NULL,
  `created_at` date NOT NULL,
  `post_reported_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REPORT_RESPONSE`
--

CREATE TABLE `REPORT_RESPONSE` (
  `id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` bigint NOT NULL,
  `created_at` date NOT NULL,
  `response_reported_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REPORT_USER`
--

CREATE TABLE `REPORT_USER` (
  `id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` bigint NOT NULL,
  `created_at` date NOT NULL,
  `user_reported_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RESPONSE`
--

CREATE TABLE `RESPONSE` (
  `id` bigint NOT NULL,
  `comment_id` bigint NOT NULL,
  `created_by` bigint NOT NULL,
  `text` text NOT NULL,
  `created_at` date NOT NULL,
  `is_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `SOCIAL_RELATION`
--

CREATE TABLE `SOCIAL_RELATION` (
  `origin_user_id` bigint NOT NULL,
  `target_user_id` bigint NOT NULL,
  `type` enum('FOLLOW','BLOCK') NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TAG`
--

CREATE TABLE `TAG` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `value` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USER`
--

CREATE TABLE `USER` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `birthdate` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('USER','MOD') NOT NULL,
  `point` int NOT NULL,
  `status` enum('ACTIVE','BANNED','DISACTIVE') NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `CATEGORY`
--
ALTER TABLE `CATEGORY`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `COMMENT`
--
ALTER TABLE `COMMENT`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_POST_COMMENT` (`post_id`),
  ADD KEY `FK_CREATED_BY_COMMENT` (`created_by`);

--
-- Indices de la tabla `IMAGE`
--
ALTER TABLE `IMAGE`
  ADD PRIMARY KEY (`num`,`post_id`),
  ADD KEY `FK_POST_IMAGE` (`post_id`);

--
-- Indices de la tabla `LINK`
--
ALTER TABLE `LINK`
  ADD PRIMARY KEY (`num`,`post_id`),
  ADD KEY `FK_POST_LINK` (`post_id`);

--
-- Indices de la tabla `LOCATION`
--
ALTER TABLE `LOCATION`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CREATED_BY_LOCATION` (`created_by`);

--
-- Indices de la tabla `POST`
--
ALTER TABLE `POST`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_LOCATION_POST` (`location_id`),
  ADD KEY `FK_CATEGORY_POST` (`category_id`),
  ADD KEY `FK_CREATED_BY` (`created_by`);

--
-- Indices de la tabla `REACTION_COMMENT`
--
ALTER TABLE `REACTION_COMMENT`
  ADD PRIMARY KEY (`user_id`,`comment_id`),
  ADD KEY `FK_COMMENT_REACTION_COMMENT` (`comment_id`);

--
-- Indices de la tabla `REACTION_POST`
--
ALTER TABLE `REACTION_POST`
  ADD PRIMARY KEY (`user_id`,`post_id`),
  ADD KEY `FK_POST_REACTION_POST` (`post_id`);

--
-- Indices de la tabla `REACTION_RESPONSE`
--
ALTER TABLE `REACTION_RESPONSE`
  ADD KEY `FK_USER_REACTION_RESPONSE` (`user_id`),
  ADD KEY `FK_RESPONSE_REACTION_RESPONSE` (`response_id`);

--
-- Indices de la tabla `REPORT_COMMENT`
--
ALTER TABLE `REPORT_COMMENT`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_COMMENT_REPORTED_REPORT_COMMENT` (`comment_reported_id`),
  ADD KEY `FK_CREATED_BY_REPORT_COMMENT` (`created_by`);

--
-- Indices de la tabla `REPORT_LOCATION`
--
ALTER TABLE `REPORT_LOCATION`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CREATED_BY_REPORT_LOCATION` (`created_by`),
  ADD KEY `FK_LOCATION_REPORTED_LOCATION_REPORTED` (`location_reported_id`);

--
-- Indices de la tabla `REPORT_POST`
--
ALTER TABLE `REPORT_POST`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CREATED_BY_REPORT_POST` (`created_by`),
  ADD KEY `FK_POST_REPORTED_REPORT_POST` (`post_reported_id`);

--
-- Indices de la tabla `REPORT_RESPONSE`
--
ALTER TABLE `REPORT_RESPONSE`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CREATED_BY_REPORT_RESPONSE` (`created_by`),
  ADD KEY `FK_RESPONSE_REPORT_RESPONSE` (`response_reported_id`);

--
-- Indices de la tabla `REPORT_USER`
--
ALTER TABLE `REPORT_USER`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_USER_REPORTED_REPORT_USER` (`user_reported_id`);

--
-- Indices de la tabla `RESPONSE`
--
ALTER TABLE `RESPONSE`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CREATED_BY_RESPONSE` (`created_by`),
  ADD KEY `FK_COMMENT_RESPONSE` (`comment_id`);

--
-- Indices de la tabla `SOCIAL_RELATION`
--
ALTER TABLE `SOCIAL_RELATION`
  ADD PRIMARY KEY (`origin_user_id`,`target_user_id`),
  ADD KEY `FK_TARGET_USER_SOCIAL_RELATION` (`target_user_id`);

--
-- Indices de la tabla `TAG`
--
ALTER TABLE `TAG`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `CATEGORY`
--
ALTER TABLE `CATEGORY`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `COMMENT`
--
ALTER TABLE `COMMENT`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `LOCATION`
--
ALTER TABLE `LOCATION`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `POST`
--
ALTER TABLE `POST`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `REPORT_COMMENT`
--
ALTER TABLE `REPORT_COMMENT`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `REPORT_LOCATION`
--
ALTER TABLE `REPORT_LOCATION`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `REPORT_POST`
--
ALTER TABLE `REPORT_POST`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `REPORT_RESPONSE`
--
ALTER TABLE `REPORT_RESPONSE`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `REPORT_USER`
--
ALTER TABLE `REPORT_USER`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `RESPONSE`
--
ALTER TABLE `RESPONSE`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `TAG`
--
ALTER TABLE `TAG`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `USER`
--
ALTER TABLE `USER`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `COMMENT`
--
ALTER TABLE `COMMENT`
  ADD CONSTRAINT `FK_CREATED_BY_COMMENT` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_POST_COMMENT` FOREIGN KEY (`post_id`) REFERENCES `POST` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `IMAGE`
--
ALTER TABLE `IMAGE`
  ADD CONSTRAINT `FK_POST_IMAGE` FOREIGN KEY (`post_id`) REFERENCES `POST` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `LINK`
--
ALTER TABLE `LINK`
  ADD CONSTRAINT `FK_POST_LINK` FOREIGN KEY (`post_id`) REFERENCES `POST` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `LOCATION`
--
ALTER TABLE `LOCATION`
  ADD CONSTRAINT `FK_CREATED_BY_LOCATION` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `POST`
--
ALTER TABLE `POST`
  ADD CONSTRAINT `FK_CATEGORY_POST` FOREIGN KEY (`category_id`) REFERENCES `CATEGORY` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CREATED_BY` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_LOCATION_POST` FOREIGN KEY (`location_id`) REFERENCES `LOCATION` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REACTION_COMMENT`
--
ALTER TABLE `REACTION_COMMENT`
  ADD CONSTRAINT `FK_COMMENT_REACTION_COMMENT` FOREIGN KEY (`comment_id`) REFERENCES `COMMENT` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_USER_REACTION_COMMENT` FOREIGN KEY (`user_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REACTION_POST`
--
ALTER TABLE `REACTION_POST`
  ADD CONSTRAINT `FK_POST_REACTION_POST` FOREIGN KEY (`post_id`) REFERENCES `POST` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_USER_REACTION_POST` FOREIGN KEY (`user_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REACTION_RESPONSE`
--
ALTER TABLE `REACTION_RESPONSE`
  ADD CONSTRAINT `FK_RESPONSE_REACTION_RESPONSE` FOREIGN KEY (`response_id`) REFERENCES `RESPONSE` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_USER_REACTION_RESPONSE` FOREIGN KEY (`user_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REPORT_COMMENT`
--
ALTER TABLE `REPORT_COMMENT`
  ADD CONSTRAINT `FK_COMMENT_REPORTED_REPORT_COMMENT` FOREIGN KEY (`comment_reported_id`) REFERENCES `REPORT_COMMENT` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CREATED_BY_REPORT_COMMENT` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REPORT_LOCATION`
--
ALTER TABLE `REPORT_LOCATION`
  ADD CONSTRAINT `FK_CREATED_BY_REPORT_LOCATION` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_LOCATION_REPORTED_LOCATION_REPORTED` FOREIGN KEY (`location_reported_id`) REFERENCES `LOCATION` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REPORT_POST`
--
ALTER TABLE `REPORT_POST`
  ADD CONSTRAINT `FK_CREATED_BY_REPORT_POST` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_POST_REPORTED_REPORT_POST` FOREIGN KEY (`post_reported_id`) REFERENCES `POST` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REPORT_RESPONSE`
--
ALTER TABLE `REPORT_RESPONSE`
  ADD CONSTRAINT `FK_CREATED_BY_REPORT_RESPONSE` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_RESPONSE_REPORT_RESPONSE` FOREIGN KEY (`response_reported_id`) REFERENCES `RESPONSE` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `REPORT_USER`
--
ALTER TABLE `REPORT_USER`
  ADD CONSTRAINT `FK_CREATED_BY_REPORT_USER` FOREIGN KEY (`user_reported_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_USER_REPORTED_REPORT_USER` FOREIGN KEY (`user_reported_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `RESPONSE`
--
ALTER TABLE `RESPONSE`
  ADD CONSTRAINT `FK_COMMENT_RESPONSE` FOREIGN KEY (`comment_id`) REFERENCES `COMMENT` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `FK_CREATED_BY_RESPONSE` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `SOCIAL_RELATION`
--
ALTER TABLE `SOCIAL_RELATION`
  ADD CONSTRAINT `FK_ORIGIN_USER_SOCIAL_RELATION` FOREIGN KEY (`origin_user_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_TARGET_USER_SOCIAL_RELATION` FOREIGN KEY (`target_user_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
