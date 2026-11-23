-- Script SQL consolidado para 05-ferreteria (Videos 37, 41 y 48)
CREATE SCHEMA IF NOT EXISTS db_ferreteria
    DEFAULT CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE db_ferreteria;

-- Tabla de articulos (con BIGINT AUTO_INCREMENT corregido en Video 41)
CREATE TABLE IF NOT EXISTS articulos (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre_articulo VARCHAR(50) NOT NULL,
    precio DECIMAL(6,2) NOT NULL,
    existencia INT NOT NULL
);

-- Tabla de usuarios para Spring Security (Video 48)
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    rol VARCHAR(60) NOT NULL
);

-- 50 registros iniciales de ferreteria
INSERT IGNORE INTO articulos (id, nombre_articulo, precio, existencia) VALUES
(1, 'Martillo de mano', 12.50, 50),
(2, 'Destornillador plano', 5.75, 80),
(3, 'Destornillador Phillips', 6.00, 75),
(4, 'Llave inglesa 10 pulgadas', 18.40, 35),
(5, 'Sierra manual', 22.90, 28),
(6, 'Taladro eléctrico 650W', 89.99, 15),
(7, 'Cinta métrica 5m', 7.50, 60),
(8, 'Alicate universal', 11.20, 42),
(9, 'Pinza de corte diagonal', 10.80, 38),
(10, 'Nivel de burbuja 60cm', 15.60, 25),
(11, 'Escuadra metálica 30cm', 9.30, 40),
(12, 'Llave Allen juego 9 pzas', 13.45, 55),
(13, 'Caja de clavos 2 pulgadas', 4.20, 120),
(14, 'Caja de tornillos madera', 4.80, 110),
(15, 'Taquetes plásticos 1/4', 3.50, 200),
(16, 'Broca para concreto 1/4', 3.90, 90),
(17, 'Broca para metal 3/16', 3.20, 95),
(18, 'Lija de agua grano 220', 1.10, 300),
(19, 'Lija para madera grano 80', 1.00, 280),
(20, 'Cinta aislante negra', 2.30, 150),
(21, 'Cinta teflón 1/2', 1.50, 180),
(22, 'Silicón transparente 280ml', 6.40, 65),
(23, 'Pistola calafateadora', 9.80, 30),
(24, 'Brocha 3 pulgadas', 4.60, 85),
(25, 'Martillo de goma', 14.20, 32),
(26, 'Rodillo para pintura 9p', 8.90, 48),
(27, 'Charola para pintura', 5.40, 52),
(28, 'Espátula metálica 4p', 4.95, 70),
(29, 'Llave Stillson 14 pulgadas', 26.50, 20),
(30, 'Arco con segueta', 13.75, 44),
(31, 'Repuesto de segueta 24D', 2.10, 160),
(32, 'Flexómetro 8m reforzado', 12.00, 46),
(33, 'Guantes de carnaza', 7.80, 64),
(34, 'Gafas de seguridad', 5.25, 92),
(35, 'Casco de protección', 16.90, 30),
(36, 'Extensión eléctrica 10m', 19.50, 26),
(37, 'Multímetro digital básico', 29.90, 18),
(38, 'Cautín tipo lápiz 40W', 14.50, 24),
(39, 'Soldadura estaño 100g', 8.40, 50),
(40, 'Candado latón 50mm', 11.90, 45),
(41, 'Bisagra metálica 3 pulgadas', 2.85, 140),
(42, 'Chapa de pomo recámara', 24.00, 22),
(43, 'Tubo PVC sanitario 2p', 9.60, 70),
(44, 'Codo PVC 90 grados 2p', 1.75, 190),
(45, 'Pegamento para PVC 250ml', 7.20, 58),
(46, 'Cemento blanco 1kg', 3.40, 130),
(47, 'Martillo de bola 16oz', 16.80, 27),
(48, 'Serrucho carpintero 20p', 19.80, 21),
(49, 'Formón para madera 1/2', 8.60, 36),
(50, 'Cúter profesional metálico', 6.30, 88);

-- Usuario inicial del Video 48 (usuario: user1 | contrasena en texto plano: admin123 | rol: ADMIN)
INSERT IGNORE INTO usuarios (id, usuario, password, rol) VALUES
(1, 'user1', '$2a$10$WAQDRu7/CcnNnITiVv7wrOn8zO.0Y6XDQWhbZev1kFdM/Ziwp8NbK', 'ADMIN');
