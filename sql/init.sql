-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 16-07-2026 a las 08:42:34
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

--
-- Volcado de datos para la tabla `CATEGORY`
--

INSERT INTO `CATEGORY` (`id`, `name`) VALUES
(1, 'Rutas de senderismo'),
(2, 'Miradores'),
(3, 'Lagos y zonas de baño'),
(4, 'Playas'),
(5, 'Zonas tranquilas'),
(6, 'Cafeterías'),
(7, 'Restaurantes y Bares'),
(8, 'Puntos fotográficos'),
(9, 'Parques naturales'),
(10, 'Monumentos'),
(11, 'Museos'),
(12, 'Zonas urbanas'),
(13, 'Áreas de picnic'),
(14, 'Campings'),
(15, 'Rutas en bicicleta'),
(16, 'Puntos de interés histórico'),
(17, 'Aparcamiento'),
(18, 'Aventuras y actividades'),
(19, 'Naturaleza y fauna'),
(20, 'Rutas nocturnas'),
(21, 'Cascadas'),
(22, 'Cuevas y grutas'),
(23, 'Zonas para acampar libre'),
(24, 'Miradores astronómicos'),
(25, 'Rutas familiares'),
(26, 'Rutas para mascotas'),
(27, 'Zonas deportivas al aire libre'),
(28, 'Skateparks'),
(29, 'Zonas de pesca'),
(30, 'Jardines botánicos'),
(31, 'Zonas de escalada'),
(32, 'Puentes y estructuras emblemáticas'),
(33, 'Mercados locales'),
(34, 'Calles comerciales'),
(35, 'Playas para mascotas'),
(36, 'Playas vírgenes'),
(37, 'Ríos y pozas naturales'),
(38, 'Zonas de observación de aves'),
(39, 'Áreas recreativas infantiles');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `COMMENT`
--

CREATE TABLE `COMMENT` (
  `id` bigint NOT NULL,
  `post_id` bigint NOT NULL,
  `text` text NOT NULL,
  `old_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `created_at` date NOT NULL,
  `created_by` bigint NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `rate` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `COMMENT`
--

INSERT INTO `COMMENT` (`id`, `post_id`, `text`, `old_text`, `created_at`, `created_by`, `is_active`, `rate`) VALUES
(1, 31, 'Muy buen sitio para desconectar un rato.', '', '2026-05-10', 14, 1, 4),
(2, 31, 'Fui el fin de semana y estaba bastante tranquilo.', '', '2026-05-11', 22, 1, 5),
(3, 32, 'Las vistas desde aquí son espectaculares.', '', '2026-05-12', 33, 1, 5),
(4, 34, 'Ruta corta pero muy agradable.', '', '2026-05-13', 19, 1, 4),
(5, 34, 'Me encantó la zona de sombra al final del camino.', '', '2026-05-13', 41, 1, 5),
(6, 35, 'Perfecto para ir con amigos a pasar la tarde.', '', '2026-05-14', 28, 1, 4),
(7, 36, 'La vegetación es increíble en esta época.', '', '2026-05-15', 12, 1, 5),
(8, 36, 'Volveré sin duda, muy recomendable.', '', '2026-05-15', 44, 1, 5),
(9, 38, 'Un sitio mágico al atardecer.', '', '2026-05-16', 17, 1, 5),
(10, 39, 'La cueva impresiona más de lo que parece en fotos.', '', '2026-05-17', 30, 1, 4),
(11, 39, 'Llevar linterna es obligatorio.', '', '2026-05-17', 25, 1, 5),
(12, 40, 'Muy buen mirador para ver estrellas.', '', '2026-05-18', 11, 1, 5),
(13, 42, 'La charca estaba muy limpia cuando fui.', '', '2026-05-19', 36, 1, 4),
(14, 42, 'Ideal para relajarse un rato.', '', '2026-05-19', 20, 1, 5),
(15, 43, 'El valle es precioso, sobre todo al anochecer.', '', '2026-05-20', 29, 1, 5),
(16, 44, 'La cueva tiene un eco muy curioso.', '', '2026-05-21', 13, 1, 4),
(17, 44, 'Me sorprendió lo grande que es.', '', '2026-05-21', 40, 1, 5),
(18, 46, 'La playa estaba bastante tranquila.', '', '2026-05-22', 24, 1, 4),
(19, 47, 'Buen sitio para hacer fotos.', '', '2026-05-23', 18, 1, 5),
(20, 47, 'El acceso es fácil y está bien señalizado.', '', '2026-05-23', 35, 1, 4),
(21, 48, 'La zona alta tiene unas vistas brutales.', '', '2026-05-24', 43, 1, 5),
(22, 50, 'El agua estaba muy fría pero merece la pena.', '', '2026-05-25', 21, 1, 4),
(23, 50, 'Perfecto para pasar un rato tranquilo.', '', '2026-05-25', 39, 1, 5),
(24, 51, 'Ruta sencilla y agradable.', '', '2026-05-26', 16, 1, 4),
(25, 52, 'Muy buena zona para caminar.', '', '2026-05-27', 27, 1, 4),
(26, 52, 'Me encantó el ambiente tan natural.', '', '2026-05-27', 32, 1, 5),
(27, 54, 'La cascada es pequeña pero bonita.', '', '2026-05-28', 10, 1, 4),
(28, 55, 'Buen sitio para desconectar.', '', '2026-05-29', 26, 1, 4),
(29, 55, 'Había poca gente cuando fui.', '', '2026-05-29', 38, 1, 5),
(30, 56, 'La laguna estaba muy tranquila.', '', '2026-05-30', 15, 1, 5),
(31, 58, 'La subida merece la pena.', '', '2026-05-31', 34, 1, 5),
(32, 58, 'Muy buenas vistas desde arriba.', '', '2026-05-31', 23, 1, 5),
(33, 59, 'El sendero es fácil de seguir.', '', '2026-06-01', 42, 1, 4),
(34, 60, 'Muy recomendable para pasar la tarde.', '', '2026-06-02', 37, 1, 5),
(35, 60, 'Volveré pronto, me encantó.', '', '2026-06-02', 45, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `IMAGE`
--

CREATE TABLE `IMAGE` (
  `num` int NOT NULL,
  `post_id` bigint NOT NULL,
  `image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `IMAGE`
--

INSERT INTO `IMAGE` (`num`, `post_id`, `image`) VALUES
(1, 31, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 32, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 33, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 34, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 35, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 36, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 37, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 38, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 39, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 40, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 41, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 42, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 43, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 44, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 45, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 46, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 47, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 48, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 49, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 50, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(1, 51, 'https://www.repsol.com/content/dam/repsol-corporate/es/sostenibilidad/naturaleza%20bosque%20y%20lago.jpg'),
(2, 31, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%BAsculo-en-el-esp%C3%ADritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 32, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%BAsculo-en-el-esp%C3%ADritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 33, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%BAsculo-en-el-esp%C3%ADritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 34, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%BAsculo-en-el-esp%C3%ADritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 35, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%BAsculo-en-el-esp%C3%ADritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 36, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%BAsculo-en-el-esp%C3%ADritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 37, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 38, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 39, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 40, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 41, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 42, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 43, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 44, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 45, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 46, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 47, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 48, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 49, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 50, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(2, 51, 'https://media.istockphoto.com/id/485371557/es/foto/crep%C3%Básculo-en-el-espíritu-de-la-isla.jpg?s=612x612&w=0&k=20&c=uRiKRRfCu_j0as0MN4UCwZNWMDGVXyTAKVu_Ef9JFF4='),
(3, 31, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 32, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 33, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 34, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 35, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 36, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 37, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 38, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 39, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 40, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 41, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 42, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 43, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 44, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 45, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 46, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 47, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 48, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 49, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 50, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg'),
(3, 51, 'https://www.visitnavarra.es/o/adaptive-media/image/52211338/turismo-navarra-1400xauto/Urederra_oto%C3%B1o.jpg');

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

--
-- Volcado de datos para la tabla `LINK`
--

INSERT INTO `LINK` (`num`, `post_id`, `name`, `url`) VALUES
(1, 31, 'Google Maps', 'https://maps.google.com'),
(1, 32, 'Google Maps', 'https://maps.google.com'),
(1, 33, 'Google Maps', 'https://maps.google.com'),
(1, 34, 'Google Maps', 'https://maps.google.com'),
(1, 35, 'Google Maps', 'https://maps.google.com'),
(1, 36, 'Google Maps', 'https://maps.google.com'),
(1, 37, 'Google Maps', 'https://maps.google.com'),
(1, 38, 'Google Maps', 'https://maps.google.com'),
(1, 39, 'Google Maps', 'https://maps.google.com'),
(1, 40, 'Google Maps', 'https://maps.google.com'),
(1, 41, 'Google Maps', 'https://maps.google.com'),
(1, 42, 'Google Maps', 'https://maps.google.com'),
(1, 43, 'Google Maps', 'https://maps.google.com'),
(1, 44, 'Google Maps', 'https://maps.google.com'),
(1, 45, 'Google Maps', 'https://maps.google.com'),
(1, 46, 'Google Maps', 'https://maps.google.com'),
(1, 47, 'Google Maps', 'https://maps.google.com'),
(1, 48, 'Google Maps', 'https://maps.google.com'),
(1, 49, 'Google Maps', 'https://maps.google.com'),
(1, 50, 'Google Maps', 'https://maps.google.com'),
(1, 51, 'Google Maps', 'https://maps.google.com'),
(1, 52, 'Google Maps', 'https://maps.google.com'),
(1, 53, 'Google Maps', 'https://maps.google.com'),
(1, 54, 'Google Maps', 'https://maps.google.com'),
(1, 55, 'Google Maps', 'https://maps.google.com'),
(1, 56, 'Google Maps', 'https://maps.google.com'),
(1, 57, 'Google Maps', 'https://maps.google.com'),
(1, 58, 'Google Maps', 'https://maps.google.com'),
(1, 59, 'Google Maps', 'https://maps.google.com'),
(1, 60, 'Google Maps', 'https://maps.google.com'),
(2, 31, 'Wikipedia', 'https://wikipedia.org'),
(2, 32, 'Wikipedia', 'https://wikipedia.org'),
(2, 33, 'Wikipedia', 'https://wikipedia.org'),
(2, 34, 'Wikipedia', 'https://wikipedia.org'),
(2, 35, 'Wikipedia', 'https://wikipedia.org'),
(2, 36, 'Wikipedia', 'https://wikipedia.org'),
(2, 37, 'Wikipedia', 'https://wikipedia.org'),
(2, 38, 'Wikipedia', 'https://wikipedia.org'),
(2, 39, 'Wikipedia', 'https://wikipedia.org'),
(2, 40, 'Wikipedia', 'https://wikipedia.org'),
(2, 41, 'Wikipedia', 'https://wikipedia.org'),
(2, 42, 'Wikipedia', 'https://wikipedia.org'),
(2, 43, 'Wikipedia', 'https://wikipedia.org'),
(2, 44, 'Wikipedia', 'https://wikipedia.org'),
(2, 45, 'Wikipedia', 'https://wikipedia.org'),
(2, 46, 'Wikipedia', 'https://wikipedia.org'),
(2, 47, 'Wikipedia', 'https://wikipedia.org'),
(2, 48, 'Wikipedia', 'https://wikipedia.org'),
(2, 49, 'Wikipedia', 'https://wikipedia.org'),
(2, 50, 'Wikipedia', 'https://wikipedia.org'),
(2, 51, 'Wikipedia', 'https://wikipedia.org'),
(2, 52, 'Wikipedia', 'https://wikipedia.org'),
(2, 53, 'Wikipedia', 'https://wikipedia.org'),
(2, 54, 'Wikipedia', 'https://wikipedia.org'),
(2, 55, 'Wikipedia', 'https://wikipedia.org'),
(2, 56, 'Wikipedia', 'https://wikipedia.org'),
(2, 57, 'Wikipedia', 'https://wikipedia.org'),
(2, 58, 'Wikipedia', 'https://wikipedia.org'),
(2, 59, 'Wikipedia', 'https://wikipedia.org'),
(2, 60, 'Wikipedia', 'https://wikipedia.org'),
(3, 31, 'Turismo Oficial', 'https://spain.info'),
(3, 32, 'Turismo Oficial', 'https://spain.info'),
(3, 33, 'Turismo Oficial', 'https://spain.info'),
(3, 34, 'Turismo Oficial', 'https://spain.info'),
(3, 35, 'Turismo Oficial', 'https://spain.info'),
(3, 36, 'Turismo Oficial', 'https://spain.info'),
(3, 37, 'Turismo Oficial', 'https://spain.info'),
(3, 38, 'Turismo Oficial', 'https://spain.info'),
(3, 39, 'Turismo Oficial', 'https://spain.info'),
(3, 40, 'Turismo Oficial', 'https://spain.info'),
(3, 41, 'Turismo Oficial', 'https://spain.info'),
(3, 42, 'Turismo Oficial', 'https://spain.info'),
(3, 43, 'Turismo Oficial', 'https://spain.info'),
(3, 44, 'Turismo Oficial', 'https://spain.info'),
(3, 45, 'Turismo Oficial', 'https://spain.info'),
(3, 46, 'Turismo Oficial', 'https://spain.info'),
(3, 47, 'Turismo Oficial', 'https://spain.info'),
(3, 48, 'Turismo Oficial', 'https://spain.info'),
(3, 49, 'Turismo Oficial', 'https://spain.info'),
(3, 50, 'Turismo Oficial', 'https://spain.info'),
(3, 51, 'Turismo Oficial', 'https://spain.info'),
(3, 52, 'Turismo Oficial', 'https://spain.info'),
(3, 53, 'Turismo Oficial', 'https://spain.info'),
(3, 54, 'Turismo Oficial', 'https://spain.info'),
(3, 55, 'Turismo Oficial', 'https://spain.info'),
(3, 56, 'Turismo Oficial', 'https://spain.info'),
(3, 57, 'Turismo Oficial', 'https://spain.info'),
(3, 58, 'Turismo Oficial', 'https://spain.info'),
(3, 59, 'Turismo Oficial', 'https://spain.info'),
(3, 60, 'Turismo Oficial', 'https://spain.info');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LOCATION`
--

CREATE TABLE `LOCATION` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `latitude` decimal(9,6) NOT NULL,
  `longitude` decimal(9,6) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_by` bigint NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `LOCATION`
--

INSERT INTO `LOCATION` (`id`, `name`, `latitude`, `longitude`, `is_active`, `created_by`, `created_at`) VALUES
(1, 'Mirador del Atardecer', 37.470000, -5.640000, 1, 6, '2026-02-10'),
(2, 'Sendero Río Blanco', 37.455500, -5.620300, 1, 8, '2026-02-11'),
(3, 'Laguna de los Pinos', 37.480200, -5.650800, 1, 12, '2026-02-12'),
(4, 'Cascada del Molino Viejo', 37.462300, -5.633900, 1, 15, '2026-02-13'),
(5, 'Área Recreativa El Robledal', 37.450700, -5.610400, 1, 18, '2026-02-14'),
(6, 'Playa del Horizonte', 36.720500, -4.410200, 1, 20, '2026-02-15'),
(7, 'Cueva de la Luna Azul', 37.390800, -5.980200, 1, 22, '2026-02-16'),
(8, 'Parque Natural Sierra Verde', 37.520300, -5.700100, 1, 25, '2026-02-17'),
(9, 'Poza Esmeralda', 37.430900, -5.600500, 1, 28, '2026-02-18'),
(10, 'Mirador Astronómico Las Estrellas', 37.510400, -5.720900, 1, 30, '2026-02-19'),
(26, 'Sendero del Arroyo Verde', 37.465200, -5.615800, 1, 32, '2026-02-20'),
(27, 'Mirador de la Encina', 37.478900, -5.642300, 1, 34, '2026-02-21'),
(28, 'Pozo del Silencio', 37.452100, -5.601200, 1, 36, '2026-02-22'),
(29, 'Bosque de los Susurros', 37.489300, -5.660400, 1, 38, '2026-02-23'),
(30, 'Ribera del Molino Alto', 37.470800, -5.628900, 1, 40, '2026-02-24'),
(31, 'Cerro del Águila', 37.495600, -5.675300, 1, 42, '2026-02-25'),
(32, 'Laguna del Cerezo', 37.461700, -5.618400, 1, 44, '2026-02-26'),
(33, 'Paraje Natural La Encantada', 37.503200, -5.690100, 1, 45, '2026-02-27'),
(34, 'Cañón del Río Seco', 37.440900, -5.590700, 1, 28, '2026-02-28'),
(35, 'Mirador del Horizonte Azul', 37.512400, -5.705900, 1, 30, '2026-03-01'),
(36, 'Senda de los Helechos', 37.468300, -5.612200, 1, 29, '2026-03-02'),
(37, 'Charca del Roble Viejo', 37.457900, -5.625500, 1, 27, '2026-03-03'),
(38, 'Valle de las Luciérnagas', 37.482600, -5.648800, 1, 23, '2026-03-04'),
(39, 'Cueva del Eco Perdido', 37.493100, -5.670200, 1, 19, '2026-03-05'),
(40, 'Playa de la Arena Blanca', 36.715800, -4.405900, 1, 17, '2026-03-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `POST`
--

CREATE TABLE `POST` (
  `id` bigint NOT NULL,
  `location_id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `rate` decimal(2,1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `category_id` bigint NOT NULL,
  `created_at` date NOT NULL,
  `created_by` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `POST`
--

INSERT INTO `POST` (`id`, `location_id`, `title`, `content`, `rate`, `is_active`, `category_id`, `created_at`, `created_by`) VALUES
(31, 1, 'Mirador del Atardecer', 'Vistas increíbles al atardecer. Lugar perfecto para relajarse.', 4.5, 1, 3, '2026-04-10', 12),
(32, 2, 'Sendero Río Blanco', 'Ruta sencilla junto al río, ideal para caminar en familia.', 4.0, 1, 1, '2026-04-11', 18),
(33, 3, 'Laguna de los Pinos', 'Agua tranquila rodeada de pinos. Muy buen sitio para fotos.', 4.5, 1, 2, '2026-04-12', 22),
(34, 4, 'Cascada del Molino Viejo', 'Cascada pequeña pero muy bonita. Terreno algo irregular.', 3.5, 1, 1, '2026-04-13', 27),
(35, 5, 'Área Recreativa El Robledal', 'Zona amplia con mesas y sombra. Perfecto para picnic.', 4.0, 1, 2, '2026-04-14', 30),
(36, 6, 'Playa del Horizonte', 'Playa tranquila con arena fina. Ideal para pasar la tarde.', 4.5, 1, 4, '2026-04-15', 33),
(37, 7, 'Cueva de la Luna Azul', 'Cueva profunda con luz natural azulada. Muy curiosa.', 3.5, 1, 3, '2026-04-16', 35),
(38, 8, 'Parque Natural Sierra Verde', 'Parque enorme con rutas para todos los niveles.', 5.0, 1, 1, '2026-04-17', 40),
(39, 9, 'Poza Esmeralda', 'Poza de agua verde cristalina. Muy fría pero preciosa.', 3.5, 1, 2, '2026-04-18', 42),
(40, 10, 'Mirador Astronómico Las Estrellas', 'Perfecto para ver estrellas. Cielo muy limpio.', 5.0, 1, 3, '2026-04-19', 44),
(41, 26, 'Sendero del Arroyo Verde', 'Ruta tranquila con sombra y buenas vistas.', 4.0, 1, 1, '2026-04-20', 29),
(42, 27, 'Mirador de la Encina', 'Mirador con una encina enorme. Buen sitio para fotos.', 4.5, 1, 3, '2026-04-21', 26),
(43, 28, 'Pozo del Silencio', 'Lugar muy silencioso rodeado de naturaleza.', 4.0, 1, 2, '2026-04-22', 23),
(44, 29, 'Bosque de los Susurros', 'Bosque con ambiente mágico y senderos estrechos.', 5.0, 1, 1, '2026-04-23', 19),
(45, 30, 'Ribera del Molino Alto', 'Ribera tranquila ideal para descansar.', 4.0, 1, 2, '2026-04-24', 17),
(46, 31, 'Cerro del Águila', 'Subida exigente pero con vistas espectaculares.', 4.5, 1, 1, '2026-04-25', 14),
(47, 32, 'Laguna del Cerezo', 'Laguna pequeña con agua clara. Muy fotogénica.', 3.5, 1, 3, '2026-04-26', 21),
(48, 33, 'Paraje Natural La Encantada', 'Paraje amplio perfecto para grupos.', 4.0, 1, 2, '2026-04-27', 25),
(49, 34, 'Cañón del Río Seco', 'Ruta estrecha entre paredes de roca. Muy bonita.', 3.5, 1, 1, '2026-04-28', 31),
(50, 35, 'Mirador del Horizonte Azul', 'Mirador con vistas al horizonte completo.', 5.0, 1, 3, '2026-04-29', 37),
(51, 36, 'Senda de los Helechos', 'Sendero fácil rodeado de helechos.', 4.0, 1, 1, '2026-04-30', 41),
(52, 37, 'Charca del Roble Viejo', 'Charca tranquila ideal para relajarse.', 3.0, 1, 2, '2026-05-01', 28),
(53, 38, 'Valle de las Luciérnagas', 'Ruta mágica al anochecer con luciérnagas.', 5.0, 1, 3, '2026-05-02', 33),
(54, 39, 'Cueva del Eco Perdido', 'Cueva con eco natural. Muy curiosa.', 3.5, 1, 1, '2026-05-03', 39),
(55, 40, 'Playa de la Arena Blanca', 'Playa con arena fina y agua clara.', 5.0, 1, 4, '2026-05-04', 44),
(56, 8, 'Atardecer en la Sierra', 'Vistas preciosas desde la parte alta del parque.', 4.5, 1, 3, '2026-05-05', 18),
(57, 2, 'Río Blanco Superior', 'Tramo más tranquilo del río, ideal para fotos.', 4.0, 1, 2, '2026-05-06', 22),
(58, 3, 'Laguna Norte', 'Zona menos concurrida de la laguna, muy tranquila.', 3.5, 1, 2, '2026-05-07', 30),
(59, 4, 'Cascada Alta', 'Cascada más alta del parque, acceso algo difícil.', 4.0, 1, 1, '2026-05-08', 35),
(60, 5, 'Poza del Robledal', 'Pequeña poza escondida entre robles.', 3.5, 1, 2, '2026-05-09', 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REACTION_COMMENT`
--

CREATE TABLE `REACTION_COMMENT` (
  `user_id` bigint NOT NULL,
  `comment_id` bigint NOT NULL,
  `type` enum('UP','DOWN') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `REACTION_COMMENT`
--

INSERT INTO `REACTION_COMMENT` (`user_id`, `comment_id`, `type`, `created_at`) VALUES
(12, 4, 'UP', '2026-05-14'),
(12, 7, 'UP', '2026-05-16'),
(14, 1, 'UP', '2026-05-11'),
(14, 15, 'DOWN', '2026-05-21'),
(14, 23, 'UP', '2026-06-04'),
(17, 2, 'UP', '2026-05-12'),
(18, 5, 'UP', '2026-05-14'),
(18, 14, 'UP', '2026-05-20'),
(18, 22, 'UP', '2026-06-03'),
(19, 18, 'UP', '2026-05-30'),
(20, 10, 'UP', '2026-05-18'),
(22, 1, 'UP', '2026-05-11'),
(23, 21, 'DOWN', '2026-06-02'),
(24, 9, 'UP', '2026-05-17'),
(27, 20, 'UP', '2026-06-01'),
(28, 11, 'DOWN', '2026-05-18'),
(28, 16, 'UP', '2026-05-22'),
(29, 3, 'DOWN', '2026-05-13'),
(29, 7, 'UP', '2026-05-16'),
(31, 14, 'UP', '2026-05-20'),
(31, 22, 'UP', '2026-06-03'),
(32, 19, 'UP', '2026-05-31'),
(33, 3, 'UP', '2026-05-13'),
(35, 7, 'DOWN', '2026-05-16'),
(35, 12, 'UP', '2026-05-19'),
(36, 6, 'DOWN', '2026-05-15'),
(36, 10, 'UP', '2026-05-18'),
(39, 16, 'UP', '2026-05-22'),
(40, 20, 'UP', '2026-06-01'),
(41, 5, 'UP', '2026-05-14'),
(41, 8, 'UP', '2026-05-16'),
(43, 17, 'UP', '2026-05-23'),
(43, 24, 'UP', '2026-06-05'),
(44, 13, 'UP', '2026-05-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REACTION_POST`
--

CREATE TABLE `REACTION_POST` (
  `user_id` bigint NOT NULL,
  `post_id` bigint NOT NULL,
  `type` enum('UP','DOWN') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `REACTION_POST`
--

INSERT INTO `REACTION_POST` (`user_id`, `post_id`, `type`, `created_at`) VALUES
(12, 34, 'UP', '2026-05-13'),
(12, 37, 'UP', '2026-05-16'),
(14, 31, 'UP', '2026-05-10'),
(14, 45, 'DOWN', '2026-05-24'),
(14, 53, 'UP', '2026-06-01'),
(18, 32, 'UP', '2026-05-11'),
(18, 35, 'UP', '2026-05-14'),
(18, 44, 'UP', '2026-05-23'),
(18, 52, 'UP', '2026-05-31'),
(19, 48, 'UP', '2026-05-27'),
(20, 36, 'UP', '2026-05-15'),
(20, 40, 'UP', '2026-05-19'),
(22, 31, 'UP', '2026-05-10'),
(22, 55, 'UP', '2026-06-03'),
(23, 51, 'DOWN', '2026-05-30'),
(24, 39, 'UP', '2026-05-18'),
(27, 50, 'UP', '2026-05-29'),
(28, 41, 'DOWN', '2026-05-20'),
(28, 46, 'UP', '2026-05-25'),
(29, 33, 'DOWN', '2026-05-12'),
(29, 37, 'UP', '2026-05-16'),
(31, 44, 'UP', '2026-05-23'),
(31, 52, 'UP', '2026-05-31'),
(32, 49, 'UP', '2026-05-28'),
(33, 33, 'UP', '2026-05-12'),
(35, 37, 'DOWN', '2026-05-16'),
(35, 42, 'UP', '2026-05-21'),
(35, 55, 'UP', '2026-06-03'),
(36, 36, 'UP', '2026-05-15'),
(36, 40, 'UP', '2026-05-19'),
(39, 46, 'UP', '2026-05-25'),
(40, 50, 'UP', '2026-05-29'),
(41, 35, 'UP', '2026-05-14'),
(41, 38, 'UP', '2026-05-17'),
(43, 47, 'UP', '2026-05-26'),
(43, 54, 'UP', '2026-06-02'),
(44, 43, 'UP', '2026-05-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REACTION_RESPONSE`
--

CREATE TABLE `REACTION_RESPONSE` (
  `user_id` bigint NOT NULL,
  `response_id` bigint NOT NULL,
  `type` enum('UP','DOWN') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `REACTION_RESPONSE`
--

INSERT INTO `REACTION_RESPONSE` (`user_id`, `response_id`, `type`, `created_at`) VALUES
(22, 1, 'UP', '2026-06-05'),
(14, 1, 'UP', '2026-06-05'),
(17, 2, 'UP', '2026-06-06'),
(33, 3, 'UP', '2026-06-07'),
(29, 3, 'DOWN', '2026-06-07'),
(12, 4, 'UP', '2026-06-08'),
(41, 5, 'UP', '2026-06-08'),
(18, 5, 'UP', '2026-06-08'),
(36, 6, 'DOWN', '2026-06-09'),
(29, 7, 'UP', '2026-06-10'),
(12, 7, 'UP', '2026-06-10'),
(35, 7, 'DOWN', '2026-06-10'),
(41, 8, 'UP', '2026-06-11'),
(24, 9, 'UP', '2026-06-12'),
(36, 10, 'UP', '2026-06-13'),
(20, 10, 'UP', '2026-06-13'),
(28, 11, 'DOWN', '2026-06-14'),
(35, 12, 'UP', '2026-06-15'),
(44, 13, 'UP', '2026-06-16'),
(31, 14, 'UP', '2026-06-17'),
(18, 14, 'UP', '2026-06-17'),
(14, 15, 'DOWN', '2026-06-18'),
(28, 16, 'UP', '2026-06-19'),
(39, 16, 'UP', '2026-06-19'),
(43, 17, 'UP', '2026-06-20'),
(19, 18, 'UP', '2026-06-21'),
(32, 19, 'UP', '2026-06-22'),
(27, 20, 'UP', '2026-06-23'),
(40, 20, 'UP', '2026-06-23'),
(23, 21, 'DOWN', '2026-06-24'),
(31, 22, 'UP', '2026-06-25'),
(18, 22, 'UP', '2026-06-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `REPORT`
--

CREATE TABLE `REPORT` (
  `id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `type` enum('USER','LOCATION','POST','COMMENT','RESPONSE') NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `created_at` date NOT NULL,
  `created_by` bigint NOT NULL,
  `id_reported` bigint NOT NULL
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
  `is_active` tinyint(1) NOT NULL,
  `rate` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `RESPONSE`
--

INSERT INTO `RESPONSE` (`id`, `comment_id`, `created_by`, `text`, `created_at`, `is_active`, `rate`) VALUES
(1, 1, 22, 'Totalmente de acuerdo, es un sitio muy tranquilo.', '2026-05-11', 1, 5),
(2, 3, 17, 'Yo también quedé impresionado con las vistas.', '2026-05-13', 1, 4),
(3, 5, 33, 'Esa parte del camino es la mejor.', '2026-05-14', 1, 5),
(4, 7, 29, 'En primavera está aún más bonito.', '2026-05-16', 1, 5),
(5, 7, 12, 'Coincido, merece mucho la pena.', '2026-05-16', 1, 4),
(6, 8, 41, 'Yo también volveré, es espectacular.', '2026-05-16', 1, 5),
(7, 10, 24, 'La cueva es enorme, sorprende mucho.', '2026-05-18', 1, 4),
(8, 12, 36, 'Buen sitio para observar el cielo, sí.', '2026-05-19', 1, 5),
(9, 14, 20, 'A mí también me pareció muy relajante.', '2026-05-20', 1, 4),
(10, 16, 28, 'El eco es increíble, me sorprendió.', '2026-05-22', 1, 5),
(11, 16, 39, 'Yo también pensé lo mismo.', '2026-05-22', 1, 4),
(12, 18, 35, 'La playa suele estar tranquila entre semana.', '2026-05-23', 1, 4),
(13, 20, 44, 'Las señales ayudan bastante, sí.', '2026-05-24', 1, 5),
(14, 22, 31, 'El agua siempre está fría allí.', '2026-05-26', 1, 4),
(15, 22, 18, 'Aun así merece la pena.', '2026-05-26', 1, 5),
(16, 24, 14, 'Es una ruta muy accesible.', '2026-05-27', 1, 4),
(17, 26, 43, 'El ambiente es muy natural, sí.', '2026-05-28', 1, 5),
(18, 28, 19, 'A mí también me ayudó a desconectar.', '2026-05-30', 1, 4),
(19, 30, 32, 'La laguna suele estar tranquila por la mañana.', '2026-05-31', 1, 5),
(20, 32, 27, 'La subida es dura pero vale la pena.', '2026-06-01', 1, 5),
(21, 32, 40, 'Las vistas son increíbles.', '2026-06-01', 1, 4),
(22, 34, 23, 'Es un sitio perfecto para relajarse.', '2026-06-03', 1, 5);

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

--
-- Volcado de datos para la tabla `SOCIAL_RELATION`
--

INSERT INTO `SOCIAL_RELATION` (`origin_user_id`, `target_user_id`, `type`, `created_at`) VALUES
(12, 18, 'FOLLOW', '2026-05-10'),
(14, 22, 'FOLLOW', '2026-05-11'),
(15, 39, 'FOLLOW', '2026-05-16'),
(17, 36, 'FOLLOW', '2026-05-14'),
(19, 33, 'BLOCK', '2026-05-11'),
(20, 37, 'FOLLOW', '2026-05-17'),
(21, 35, 'FOLLOW', '2026-05-14'),
(25, 12, 'FOLLOW', '2026-05-12'),
(28, 31, 'FOLLOW', '2026-05-15'),
(29, 34, 'FOLLOW', '2026-05-17'),
(30, 41, 'FOLLOW', '2026-05-12'),
(32, 18, 'BLOCK', '2026-05-16'),
(33, 14, 'BLOCK', '2026-05-14'),
(36, 44, 'FOLLOW', '2026-05-16'),
(38, 29, 'FOLLOW', '2026-05-13'),
(40, 26, 'BLOCK', '2026-05-15'),
(41, 12, 'BLOCK', '2026-05-18'),
(42, 19, 'FOLLOW', '2026-05-15'),
(44, 27, 'BLOCK', '2026-05-13'),
(45, 23, 'FOLLOW', '2026-05-17');

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

--
-- Volcado de datos para la tabla `TAG`
--

INSERT INTO `TAG` (`id`, `name`, `type`, `value`) VALUES
(1, 'Precio bajo', 'precio', 1),
(2, 'Precio medio', 'precio', 2),
(3, 'Precio alto', 'precio', 3),
(4, 'Distancia corta', 'distancia', 1),
(5, 'Distancia media', 'distancia', 2),
(6, 'Distancia larga', 'distancia', 3),
(7, 'Duración corta', 'duracion', 1),
(8, 'Duración media', 'duracion', 2),
(9, 'Duración larga', 'duracion', 3),
(10, 'Accesibilidad fácil', 'accesibilidad', 1),
(11, 'Accesibilidad media', 'accesibilidad', 2),
(12, 'Accesibilidad difícil', 'accesibilidad', 3),
(13, 'Terreno llano', 'terreno', 1),
(14, 'Terreno pedregoso', 'terreno', 2),
(15, 'Terreno con desnivel', 'terreno', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TAG_POST`
--

CREATE TABLE `TAG_POST` (
  `post_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `TAG_POST`
--

INSERT INTO `TAG_POST` (`post_id`, `tag_id`) VALUES
(32, 1),
(35, 1),
(39, 1),
(41, 1),
(43, 1),
(45, 1),
(47, 1),
(51, 1),
(52, 1),
(31, 2),
(33, 2),
(34, 2),
(37, 2),
(38, 2),
(40, 2),
(42, 2),
(44, 2),
(48, 2),
(49, 2),
(53, 2),
(54, 2),
(36, 3),
(46, 3),
(50, 3),
(55, 3),
(31, 4),
(33, 4),
(35, 4),
(40, 4),
(41, 4),
(43, 4),
(45, 4),
(47, 4),
(51, 4),
(52, 4),
(32, 5),
(34, 5),
(37, 5),
(39, 5),
(42, 5),
(44, 5),
(48, 5),
(53, 5),
(54, 5),
(36, 6),
(38, 6),
(46, 6),
(49, 6),
(50, 6),
(55, 6),
(31, 7),
(33, 7),
(35, 7),
(40, 7),
(41, 7),
(43, 7),
(45, 7),
(47, 7),
(51, 7),
(52, 7),
(32, 8),
(34, 8),
(37, 8),
(39, 8),
(42, 8),
(44, 8),
(48, 8),
(53, 8),
(54, 8),
(36, 9),
(38, 9),
(46, 9),
(49, 9),
(50, 9),
(55, 9),
(31, 10),
(32, 10),
(35, 10),
(36, 10),
(40, 10),
(41, 10),
(42, 10),
(44, 10),
(45, 10),
(47, 10),
(50, 10),
(51, 10),
(53, 10),
(55, 10),
(33, 11),
(34, 11),
(38, 11),
(39, 11),
(43, 11),
(48, 11),
(52, 11),
(37, 12),
(46, 12),
(49, 12),
(54, 12),
(31, 13),
(32, 13),
(33, 13),
(35, 13),
(36, 13),
(40, 13),
(41, 13),
(42, 13),
(44, 13),
(45, 13),
(47, 13),
(50, 13),
(51, 13),
(53, 13),
(55, 13),
(34, 14),
(38, 14),
(39, 14),
(43, 14),
(48, 14),
(52, 14),
(37, 15),
(46, 15),
(49, 15),
(54, 15);

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
-- Volcado de datos para la tabla `USER`
--

INSERT INTO `USER` (`id`, `name`, `surname`, `username`, `image`, `birthdate`, `email`, `password`, `role`, `point`, `status`, `created_at`) VALUES
(1, 'Carlos', 'Gómez', 'carlosgomez', NULL, '1990-05-12', 'carlos.gomez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'MOD', 120, 'ACTIVE', '2026-01-10'),
(2, 'Lucía', 'Martínez', 'luciamartinez', NULL, '1988-03-22', 'lucia.martinez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'MOD', 200, 'ACTIVE', '2026-01-11'),
(3, 'Javier', 'Ruiz', 'javiruiz92', NULL, '1992-11-02', 'javier.ruiz@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'MOD', 150, 'ACTIVE', '2026-01-12'),
(4, 'María', 'Santos', 'mariasantos', NULL, '1995-07-18', 'maria.santos@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'MOD', 180, 'ACTIVE', '2026-01-13'),
(5, 'Pedro', 'López', 'pedrolopez87', NULL, '1987-09-30', 'pedro.lopez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'MOD', 210, 'ACTIVE', '2026-01-14'),
(6, 'Daniel', 'Torres', 'dtorres', NULL, '2000-01-10', 'daniel.torres@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 10, 'ACTIVE', '2026-02-01'),
(7, 'Ana', 'López', 'analopez', NULL, '1999-04-15', 'ana.lopez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 5, 'ACTIVE', '2026-02-01'),
(8, 'Sergio', 'Martín', 'sergiomartin', NULL, '1998-06-20', 'sergio.martin@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 8, 'ACTIVE', '2026-02-01'),
(9, 'Laura', 'García', 'laurag', NULL, '2001-02-11', 'laura.garcia@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 12, 'ACTIVE', '2026-02-01'),
(10, 'Pablo', 'Serrano', 'pabloserrano', NULL, '1997-08-09', 'pablo.serrano@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 3, 'ACTIVE', '2026-02-01'),
(11, 'Elena', 'Ramos', 'elenaramos', NULL, '1996-03-25', 'elena.ramos@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 7, 'ACTIVE', '2026-02-02'),
(12, 'David', 'Morales', 'dmorales', NULL, '1995-12-14', 'david.morales@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 15, 'ACTIVE', '2026-02-02'),
(13, 'Sara', 'Jiménez', 'sarajimenez', NULL, '2002-10-05', 'sara.jimenez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 4, 'ACTIVE', '2026-02-02'),
(14, 'Rubén', 'Castro', 'rubencastro', NULL, '1994-09-17', 'ruben.castro@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 9, 'ACTIVE', '2026-02-02'),
(15, 'Marta', 'Vega', 'martavega', NULL, '1993-11-29', 'marta.vega@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 6, 'ACTIVE', '2026-02-02'),
(16, 'Iván', 'Soto', 'ivansoto', NULL, '1998-07-21', 'ivan.soto@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 11, 'ACTIVE', '2026-02-03'),
(17, 'Patricia', 'Rey', 'patriciarey', NULL, '1999-01-30', 'patricia.rey@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 2, 'ACTIVE', '2026-02-03'),
(18, 'Hugo', 'Navarro', 'hugonavarro', NULL, '2000-05-19', 'hugo.navarro@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 14, 'ACTIVE', '2026-02-03'),
(19, 'Clara', 'Mendoza', 'claramendoza', NULL, '1997-03-08', 'clara.mendoza@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 1, 'ACTIVE', '2026-02-03'),
(20, 'Adrián', 'Pérez', 'adrianperez', NULL, '1996-06-12', 'adrian.perez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 13, 'ACTIVE', '2026-02-03'),
(21, 'Nuria', 'Cano', 'nuriacano', NULL, '1995-04-04', 'nuria.cano@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 5, 'ACTIVE', '2026-02-04'),
(22, 'Jorge', 'Gil', 'jorgegil', NULL, '1994-02-22', 'jorge.gil@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 7, 'ACTIVE', '2026-02-04'),
(23, 'Raquel', 'Suárez', 'raquelsuarez', NULL, '1993-10-10', 'raquel.suarez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 9, 'ACTIVE', '2026-02-04'),
(24, 'Tomás', 'Delgado', 'tomasdelgado', NULL, '1992-01-16', 'tomas.delgado@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 4, 'ACTIVE', '2026-02-04'),
(25, 'Isabel', 'Cruz', 'isabelcruz', NULL, '1991-12-03', 'isabel.cruz@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 6, 'ACTIVE', '2026-02-04'),
(26, 'Víctor', 'Sanz', 'victorsanz', NULL, '1990-09-14', 'victor.sanz@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 8, 'ACTIVE', '2026-02-05'),
(27, 'Paula', 'Ortega', 'paulaortega', NULL, '1999-11-23', 'paula.ortega@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 10, 'ACTIVE', '2026-02-05'),
(28, 'Álvaro', 'Herrera', 'alvaroherrera', NULL, '1998-08-01', 'alvaro.herrera@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 12, 'ACTIVE', '2026-02-05'),
(29, 'Cristina', 'Moya', 'cristinamoya', NULL, '1997-07-27', 'cristina.moya@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 3, 'ACTIVE', '2026-02-05'),
(30, 'Samuel', 'Iglesias', 'samueliglesias', NULL, '1996-05-06', 'samuel.iglesias@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 11, 'ACTIVE', '2026-02-05'),
(31, 'Rocío', 'Benítez', 'rociobenitez', NULL, '1995-03-12', 'rocio.benitez@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 2, 'ACTIVE', '2026-02-06'),
(32, 'Gonzalo', 'Lara', 'gonzalolara', NULL, '1994-01-25', 'gonzalo.lara@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 9, 'ACTIVE', '2026-02-06'),
(33, 'Alicia', 'Campos', 'aliciacampos', NULL, '1993-10-14', 'alicia.campos@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 7, 'ACTIVE', '2026-02-06'),
(34, 'Óscar', 'Fuentes', 'oscarfuentes', NULL, '1992-09-09', 'oscar.fuentes@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 5, 'ACTIVE', '2026-02-06'),
(35, 'Beatriz', 'Romero', 'beatrizromero', NULL, '1991-06-18', 'beatriz.romero@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 6, 'ACTIVE', '2026-02-06'),
(36, 'Manuel', 'Sierra', 'manuelsierra', NULL, '1990-04-22', 'manuel.sierra@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 8, 'ACTIVE', '2026-02-07'),
(37, 'Irene', 'Bravo', 'irenebravo', NULL, '1999-02-11', 'irene.bravo@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 10, 'ACTIVE', '2026-02-07'),
(38, 'Diego', 'Reina', 'diegoreina', NULL, '1998-03-19', 'diego.reina@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 6, 'ACTIVE', '2026-02-07'),
(39, 'Noelia', 'Campos', 'noeliacampos', NULL, '1997-01-28', 'noelia.campos@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 4, 'ACTIVE', '2026-02-07'),
(40, 'Álex', 'Vargas', 'alexvargas', NULL, '1996-10-03', 'alex.vargas@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 7, 'ACTIVE', '2026-02-07'),
(41, 'Sofía', 'Luna', 'sofialuna', NULL, '1995-09-15', 'sofia.luna@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 3, 'ACTIVE', '2026-02-08'),
(42, 'Mario', 'Crespo', 'mariocrespo', NULL, '1994-07-22', 'mario.crespo@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 9, 'ACTIVE', '2026-02-08'),
(43, 'Nerea', 'Pardo', 'nereapardo', NULL, '1993-05-11', 'nerea.pardo@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 5, 'ACTIVE', '2026-02-08'),
(44, 'Héctor', 'Santos', 'hectorsantos', NULL, '1992-02-09', 'hector.santos@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 8, 'ACTIVE', '2026-02-08'),
(45, 'Julia', 'Rivas', 'juliarivas', NULL, '1991-12-01', 'julia.rivas@findora.com', '$2a$12$HLCVxPdY9cOffP.XmHrKmuHfm.bgWULTjY5hOLEcEYszqzbl9noAi', 'USER', 6, 'ACTIVE', '2026-02-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `VERIFICATION_TOKEN`
--

CREATE TABLE `VERIFICATION_TOKEN` (
  `id` bigint NOT NULL,
  `expires_at` date NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` bigint NOT NULL
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
-- Indices de la tabla `REPORT`
--
ALTER TABLE `REPORT`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_REPORT_USER` (`created_by`);

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
-- Indices de la tabla `TAG_POST`
--
ALTER TABLE `TAG_POST`
  ADD PRIMARY KEY (`post_id`,`tag_id`),
  ADD KEY `FK_TAG_TAG_POST` (`tag_id`);

--
-- Indices de la tabla `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `VERIFICATION_TOKEN`
--
ALTER TABLE `VERIFICATION_TOKEN`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `CATEGORY`
--
ALTER TABLE `CATEGORY`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `COMMENT`
--
ALTER TABLE `COMMENT`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `LOCATION`
--
ALTER TABLE `LOCATION`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `POST`
--
ALTER TABLE `POST`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `REPORT`
--
ALTER TABLE `REPORT`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `RESPONSE`
--
ALTER TABLE `RESPONSE`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `TAG`
--
ALTER TABLE `TAG`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `USER`
--
ALTER TABLE `USER`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT de la tabla `VERIFICATION_TOKEN`
--
ALTER TABLE `VERIFICATION_TOKEN`
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
-- Filtros para la tabla `REPORT`
--
ALTER TABLE `REPORT`
  ADD CONSTRAINT `FK_REPORT_USER` FOREIGN KEY (`created_by`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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

--
-- Filtros para la tabla `TAG_POST`
--
ALTER TABLE `TAG_POST`
  ADD CONSTRAINT `FK_POST_TAG_POST` FOREIGN KEY (`post_id`) REFERENCES `POST` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_TAG_TAG_POST` FOREIGN KEY (`tag_id`) REFERENCES `TAG` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
