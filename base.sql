CREATE DATABASE IF NOT EXISTS medeled_cmr;
USE medeled_cmr;

CREATE TABLE IF NOT EXISTS cliente (
    idcliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    producto VARCHAR(100) NOT NULL,
    fecha_compra DATE NOT NULL,
    estado VARCHAR(30) NOT NULL,
    observaciones VARCHAR(255)
);

SELECT * FROM medeled_cmr.cliente;
