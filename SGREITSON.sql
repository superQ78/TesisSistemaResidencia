DROP DATABASE IF EXISTS SistemaResidencias;
CREATE DATABASE SistemaResidencias;
USE SistemaResidencias;

-- =========================
-- TABLA USUARIOS
-- =========================
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

INSERT INTO Usuarios (nombreCompleto, email, contrasena, rol, telefono) 
VALUES ('Abril Administradora', 'admin@itson.edu.mx', '12345', 'Administrador', '6441234567');


-- =========================
-- TABLA RESIDENTES
-- =========================
CREATE TABLE Residentes (
    idResidente INT AUTO_INCREMENT PRIMARY KEY,

    -- DATOS DEL SOLICITANTE
    nombreCompleto VARCHAR(100),
    sexo VARCHAR(20),
    fechaNacimiento DATE,
    domicilio VARCHAR(150),
    curp VARCHAR(18) UNIQUE NOT NULL,
    lugarResidencia VARCHAR(150),
    nss VARCHAR(11),
    celular VARCHAR(20),
    telefono VARCHAR(20),
    correo VARCHAR(100),

    -- DATOS ACADÉMICOS
    idAcademico VARCHAR(20) UNIQUE NOT NULL,
    correoInstitucional VARCHAR(100),
    carrera VARCHAR(100),
    semestre VARCHAR(20),
    buscaAyudaAcademica VARCHAR(20),
    efectividadEstudio VARCHAR(50),
    efectividadTiempo VARCHAR(50),
    aspectosMejoraAcademica TEXT,

    -- CONTACTO DE EMERGENCIA
    nombreEmergencia VARCHAR(100),
    parentescoEmergencia VARCHAR(50),
    domicilioEmergencia VARCHAR(150),
    lugarEmergencia VARCHAR(150),
    celularEmergencia VARCHAR(20),
    telefonoEmergencia VARCHAR(20),
    correoEmergencia VARCHAR(100),

    -- DATOS DEL TUTOR
    nombreTutor VARCHAR(100),
    parentescoTutor VARCHAR(50),
    domicilioTutor VARCHAR(150),
    lugarTutor VARCHAR(150),
    celularTutor VARCHAR(20),
    telefonoTutor VARCHAR(20),
    correoTutor VARCHAR(100),

    -- DATOS MÉDICOS
    estadoSalud VARCHAR(20),
    tieneDeficienciaVista BOOLEAN,
    especificarVista TEXT,
    tieneDeficienciaAuditiva BOOLEAN,
    especificarAuditiva TEXT,
    tieneDiscapacidadFisica BOOLEAN,
    especificarFisica TEXT,
    tieneLesionesGraves BOOLEAN,
    especificarLesiones TEXT,
    tienePadecimientos BOOLEAN,
    especificarPadecimientos TEXT,
    tieneTratamientosPsicologicos BOOLEAN,
    motivoTratamientosPsicologicos TEXT,
    tieneMedicamentosControlados BOOLEAN,
    especificarMedicamentos TEXT,
    tieneAlergias BOOLEAN,
    especificarAlergias TEXT,
    tieneTratamientosExternos BOOLEAN,
    motivoTratamientosExternos TEXT,
    tipoSangre VARCHAR(10),
    aspectosSaludMejora TEXT,
    otraInformacionSalud TEXT,

    -- ASPECTOS PERSONALES Y CONVIVENCIA
    haVividoFuera BOOLEAN,
    tiempoVividoFuera VARCHAR(50),
    decisionResidencia VARCHAR(50),
    razonesVivirResidencia TEXT,
    adaptacion VARCHAR(50),
    estiloConvivencia VARCHAR(50),
    situacionesNoDeseadas TEXT,
    buscaCompaneroExtranjero BOOLEAN,
    buscaCompaneroMexicano BOOLEAN,
    buscaCompaneroReingreso BOOLEAN,
    horaDormir VARCHAR(20),
    toleraRuido BOOLEAN,
    importanciaOrden VARCHAR(20),
    habitosHigiene TEXT,
    traeAuto BOOLEAN,
    traeComputadora BOOLEAN,
    traeTv BOOLEAN,
    traeFrigobar BOOLEAN,
    iniciativaActividades TEXT,
    participacionGrupo BOOLEAN,
    tipoGrupo VARCHAR(100),
    actividadesRealizadasGrupo TEXT,
    deseaActDeportivas BOOLEAN,
    deseaActCulturales BOOLEAN,
    deseaActArtisticas BOOLEAN,
    aspectosMejoraPersona TEXT,
    otraInformacion TEXT,

    -- CONTROL
    fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- =========================
-- TABLA SOLICITUDES DE INGRESO
-- =========================
CREATE TABLE SolicitudesIngreso (
    idSolicitud INT AUTO_INCREMENT PRIMARY KEY,

    curpResidente VARCHAR(18) NOT NULL,
    tipoPago VARCHAR(100) NOT NULL,
    montoPago VARCHAR(50) NOT NULL,
    
    idCompanero VARCHAR(50),
    nombreCompanero VARCHAR(150),

    CONSTRAINT fk_solicitud_residente_curp
        FOREIGN KEY (curpResidente) REFERENCES Residentes(curp)
        ON DELETE CASCADE
);


-- =========================
-- TABLA DOCUMENTOS
-- =========================
CREATE TABLE Documentos (
    idDocumento INT AUTO_INCREMENT PRIMARY KEY,

    idAcademico VARCHAR(20) NOT NULL,
    tipoDocumento VARCHAR(100) NOT NULL,
    nombreArchivo VARCHAR(255) NOT NULL,
    archivo LONGBLOB NOT NULL,

    fechaSubida TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_documento_residente_academico
        FOREIGN KEY (idAcademico) REFERENCES Residentes(idAcademico)
        ON DELETE CASCADE
);


CREATE TABLE ActasAdministrativas (
    idActa INT AUTO_INCREMENT PRIMARY KEY,
    idAcademico VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    semestre VARCHAR(50),
    lineamiento VARCHAR(100),
    descripcion TEXT,
    estado VARCHAR(20) DEFAULT 'Pendiente de firma', 
    archivoFirmado LONGBLOB, -- Aquí guardaremos el PDF
    FOREIGN KEY (idAcademico) REFERENCES Residentes(idAcademico) ON DELETE CASCADE
);

-- =========================
-- CONSULTAS DE PRUEBA
-- =========================
SELECT * FROM Usuarios;
SELECT * FROM Residentes;
SELECT * FROM SolicitudesIngreso;
SELECT * FROM Documentos;
