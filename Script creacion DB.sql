CREATE TABLE Voluntario (
    rutVoluntario VARCHAR(20) PRIMARY KEY,
    nombreVoluntario VARCHAR(255) NOT NULL,
    apellidoVoluntario VARCHAR(255) NOT NULL,
    edadVoluntario INT NOT NULL,
    sexoVoluntario BOOLEAN NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    disponibilidad BOOLEAN NOT NULL
);


CREATE TABLE Atributo (
    idAtributo UUID PRIMARY KEY,
    atributo VARCHAR(255) NOT NULL
);

CREATE TABLE Voluntario_Atributo (
    rutVoluntarioAtributo UUID PRIMARY KEY,
    rutVoluntario VARCHAR(20),
    idAtributo UUID,
    FOREIGN KEY (rutVoluntario) REFERENCES Voluntario(rutVoluntario),
    FOREIGN KEY (idAtributo) REFERENCES Atributo(idAtributo)
);

CREATE TABLE Institucion (
    idInstitucion UUID PRIMARY KEY,
    nombreInstitucion VARCHAR(255) NOT NULL
);

CREATE TABLE Coordinador (
    rutCoordinador VARCHAR(20) PRIMARY KEY,
    nombreCoordinador VARCHAR(255) NOT NULL,
    apellidoCoordinador VARCHAR(255) NOT NULL,  
    contrasena VARCHAR(255) NOT NULL,
    idInstitucion UUID,
    FOREIGN KEY (idInstitucion) REFERENCES Institucion(idInstitucion)
);

CREATE TABLE Emergencia (
    idEmergencia UUID PRIMARY KEY,
    estadoEmergencia BOOLEAN NOT NULL,
    tituloEmergencia VARCHAR(255) NOT NULL,
    descripcionEmergencia TEXT NOT NULL,
    rutCoordinador VARCHAR(20) NOT NULL,
    FOREIGN KEY (rutCoordinador) REFERENCES Coordinador(rutCoordinador)
);

CREATE TABLE Emergencia_Atributo (
    idEmergenciaAtributo UUID PRIMARY KEY,
    idEmergencia UUID,
    idAtributo UUID,
    compatibilidad BOOLEAN NOT NULL,
    FOREIGN KEY (idEmergencia) REFERENCES Emergencia(idEmergencia),
    FOREIGN KEY (idAtributo) REFERENCES Atributo(idAtributo)
);

CREATE TABLE Tarea (
    idTarea UUID PRIMARY KEY,
    idEmergencia UUID,
    tipoTarea VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    estado BOOLEAN NOT NULL,
    FOREIGN KEY (idEmergencia) REFERENCES Emergencia(idEmergencia)
);

CREATE TABLE Ranking (
    idRanking UUID PRIMARY KEY,
    rutVoluntario VARCHAR(20) NOT NULL,
    idTarea UUID,
    valorRanking INT,
    FOREIGN KEY (rutVoluntario) REFERENCES Voluntario(rutVoluntario),
    FOREIGN KEY (idTarea) REFERENCES Tarea(idTarea)
);

--Indexes

CREATE INDEX idx_voluntarioatributo_rutvoluntario ON Voluntario_Atributo (rutVoluntario);
CREATE INDEX idx_voluntarioatributo_idatributo ON Voluntario_Atributo (idAtributo);

CREATE INDEX idx_coordinador_idinstitucion ON Coordinador (idInstitucion);

CREATE INDEX idx_emergencia_rutcoordinador ON Emergencia (rutCoordinador);

CREATE INDEX idx_emergenciaatributo_idemergencia ON Emergencia_Atributo (idEmergencia);
CREATE INDEX idx_emergenciaatributo_idatributo ON Emergencia_Atributo (idAtributo);

CREATE INDEX idx_tarea_idemergencia ON Tarea (idEmergencia);

CREATE INDEX idx_ranking_rutvoluntario ON Ranking (rutVoluntario);
CREATE INDEX idx_ranking_idtarea ON Ranking (idTarea);
