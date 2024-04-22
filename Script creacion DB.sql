CREATE TABLE Voluntario (
    idVoluntario BIGSERIAL PRIMARY KEY,
    rut VARCHAR(12) NOT NULL,
    email VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    edadVoluntario INT NOT NULL,
    sexoVoluntario BOOLEAN NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    disponibilidad BOOLEAN NOT NULL,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE Atributo (
    idAtributo BIGSERIAL PRIMARY KEY,
    atributo VARCHAR(255) NOT NULL
);

CREATE TABLE Voluntario_Atributo (
    idVoluntarioAtributo BIGSERIAL PRIMARY KEY,
    idVoluntario BIGINT,
    idAtributo BIGINT,
    FOREIGN KEY (idVoluntario) REFERENCES Voluntario(idVoluntario),
    FOREIGN KEY (idAtributo) REFERENCES Atributo(idAtributo)
);

CREATE TABLE Institucion (
    idInstitucion BIGSERIAL PRIMARY KEY,
    nombreInstitucion VARCHAR(255) NOT NULL
);

CREATE TABLE Coordinador (
    idCoordinador BIGSERIAL PRIMARY KEY,
    rut VARCHAR(12) NOT NULL,
    email VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,  
    contrasena VARCHAR(255) NOT NULL,
    idInstitucion BIGINT,
    FOREIGN KEY (idInstitucion) REFERENCES Institucion(idInstitucion),
    role VARCHAR(255) NOT NULL
);

CREATE TABLE Emergencia (
    idEmergencia BIGSERIAL PRIMARY KEY,
    estadoEmergencia BOOLEAN NOT NULL,
    tituloEmergencia VARCHAR(255) NOT NULL,
    descripcionEmergencia TEXT NOT NULL,
    idCoordinador BIGINT,
    FOREIGN KEY (idCoordinador) REFERENCES Coordinador(idCoordinador)
);

CREATE TABLE Emergencia_Atributo (
    idEmergenciaAtributo BIGSERIAL PRIMARY KEY,
    idEmergencia BIGINT,
    idAtributo BIGINT,
    compatibilidad BOOLEAN NOT NULL,
    FOREIGN KEY (idEmergencia) REFERENCES Emergencia(idEmergencia),
    FOREIGN KEY (idAtributo) REFERENCES Atributo(idAtributo)
);

CREATE TABLE Tarea (
    idTarea BIGSERIAL PRIMARY KEY,
    idEmergencia BIGINT,
    tipoTarea VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL,
    FOREIGN KEY (idEmergencia) REFERENCES Emergencia(idEmergencia)
);

CREATE TABLE Ranking (
    idRanking BIGSERIAL PRIMARY KEY,
    idVoluntario BIGINT,
    idTarea BIGINT,
    valorRanking INT,
    FOREIGN KEY (idVoluntario) REFERENCES Voluntario(idVoluntario),
    FOREIGN KEY (idTarea) REFERENCES Tarea(idTarea)
);