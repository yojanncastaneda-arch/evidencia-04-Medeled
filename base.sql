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

CREATE TABLE IF NOT EXISTS venta (
    idventa INT AUTO_INCREMENT PRIMARY KEY,
    idcliente INT NOT NULL,
    producto VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    fecha_venta DATE NOT NULL,
    estado VARCHAR(30) NOT NULL,
    FOREIGN KEY (idcliente) REFERENCES cliente(idcliente)
);

SELECT * FROM medeled_cmr.cliente;
