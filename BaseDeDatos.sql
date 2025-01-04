-- tiendaropa.categoria definition

CREATE TABLE `categoria` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `descripcioncategoria` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.cliente definition

CREATE TABLE `cliente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `razonsocial` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ruc` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.proveedor definition

CREATE TABLE `proveedor` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `razonsocial` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ruc` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.talla definition

CREATE TABLE `talla` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `descripciontalla` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.tienda definition

CREATE TABLE `tienda` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `descripciontienda` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `correo` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.pedidocompra definition

CREATE TABLE `pedidocompra` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nropedido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '01',
  `idproveedor` int unsigned NOT NULL,
  `idtienda` int unsigned NOT NULL,
  `fechapedido` date NOT NULL,
  `estado` int NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idproveedor` (`idproveedor`),
  KEY `idtienda` (`idtienda`),
  CONSTRAINT `pedidocompra_ibfk_1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pedidocompra_ibfk_2` FOREIGN KEY (`idtienda`) REFERENCES `tienda` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.ropa definition

CREATE TABLE `ropa` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `idtalla` int unsigned NOT NULL,
  `idcategoria` int unsigned NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idtalla` (`idtalla`),
  KEY `idcategoria` (`idcategoria`),
  CONSTRAINT `ropa_ibfk_1` FOREIGN KEY (`idtalla`) REFERENCES `talla` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ropa_ibfk_2` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.stock definition

CREATE TABLE `stock` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `idtienda` int unsigned NOT NULL,
  `idropa` int unsigned NOT NULL,
  `cantidadexistencia` int NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idtienda` (`idtienda`),
  KEY `idropa` (`idropa`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`idtienda`) REFERENCES `tienda` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`idropa`) REFERENCES `ropa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.detallepedidocompra definition

CREATE TABLE `detallepedidocompra` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `idpedidocompra` int unsigned NOT NULL,
  `idropa` int unsigned NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `cantidad` int NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idpedidocompra` (`idpedidocompra`),
  KEY `idropa` (`idropa`),
  CONSTRAINT `detallepedidocompra_ibfk_1` FOREIGN KEY (`idpedidocompra`) REFERENCES `pedidocompra` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detallepedidocompra_ibfk_2` FOREIGN KEY (`idropa`) REFERENCES `ropa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- tiendaropa.facturacompra definition

CREATE TABLE `facturacompra` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `idpedidocompra` int unsigned NOT NULL,
  `fechafactura` date NOT NULL,
  `estado` int NOT NULL,
  `usuario` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fechaultmodificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `nrofactura` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idpedidocompra` (`idpedidocompra`),
  CONSTRAINT `facturacompra_ibfk_1` FOREIGN KEY (`idpedidocompra`) REFERENCES `pedidocompra` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



--INSERTAR DATOS NECESARIOS
INSERT INTO tiendaropa.talla
(id, descripciontalla, usuario, fechaultmodificacion)
VALUES(1, 'Talla S', 'adsf', '2024-12-30 23:51:34');
INSERT INTO tiendaropa.talla
(id, descripciontalla, usuario, fechaultmodificacion)
VALUES(2, 'Talla P', 'adsf', '2024-12-30 23:51:34');
INSERT INTO tiendaropa.talla
(id, descripciontalla, usuario, fechaultmodificacion)
VALUES(3, 'Talla M', 'adsf', '2024-12-30 23:51:34');