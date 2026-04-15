CREATE DATABASE SistemaResidencias;
USE SistemaResidencias;

CREATE TABLE Usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombreCompleto VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL -- Aquí guardaremos "Administrador" o "Trabajador"
);

-- Inserta un usuario de prueba para poder programar hoy
INSERT INTO Usuarios (nombreCompleto, email, contrasena, rol) 
VALUES ('Abril Administradora', 'admin@itson.edu.mx', '12345', 'Administrador');

ALTER TABLE Usuarios ADD COLUMN telefono VARCHAR(20);

SELECT * FROM Usuarios;
