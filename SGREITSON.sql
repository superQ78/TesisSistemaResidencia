CREATE DATABASE SistemaResidencias;
USE SistemaResidencias;

-- Estructura de la tabla Usuarios
CREATE TABLE Usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombreCompleto VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL, -- 'Administrador' o 'Trabajador'
    telefono VARCHAR(20),
    fotoPerfil LONGBLOB,
    estado ENUM('Activo', 'Inhabilitado') DEFAULT 'Activo'
);

-- usuario de prueba
INSERT INTO Usuarios (nombreCompleto, email, contrasena, rol, telefono) 
VALUES ('Abril Administradora', 'admin@itson.edu.mx', '12345', 'Administrador', '6441234567');

SELECT * FROM Usuarios;
