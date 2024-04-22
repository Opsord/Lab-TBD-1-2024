CREATE TABLE Voluntario (
    idVoluntario BIGSERIAL PRIMARY KEY,
    rut VARCHAR(20) NOT NULL,
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
    rut VARCHAR(20) NOT NULL,
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

--Indexes

CREATE INDEX idx_voluntarioatributo_idvoluntario ON Voluntario_Atributo (idVoluntario);
CREATE INDEX idx_voluntarioatributo_idatributo ON Voluntario_Atributo (idAtributo);

CREATE INDEX idx_coordinador_idinstitucion ON Coordinador (idInstitucion);

CREATE INDEX idx_emergencia_idcoordinador ON Emergencia (idCoordinador);

CREATE INDEX idx_emergenciaatributo_idemergencia ON Emergencia_Atributo (idEmergencia);
CREATE INDEX idx_emergenciaatributo_idatributo ON Emergencia_Atributo (idAtributo);

CREATE INDEX idx_tarea_idemergencia ON Tarea (idEmergencia);

CREATE INDEX idx_ranking_idvoluntario ON Ranking (idVoluntario);
CREATE INDEX idx_ranking_idtarea ON Ranking (idTarea);



