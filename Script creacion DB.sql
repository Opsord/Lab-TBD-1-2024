CREATE TABLE Voluntario (
    idVoluntario BIGSERIAL PRIMARY KEY,
    rutVoluntario VARCHAR(12) NOT NULL,
    nombreVoluntario VARCHAR(255) NOT NULL,
    apellidoVoluntario VARCHAR(255) NOT NULL,
    edadVoluntario INT NOT NULL,
    sexoVoluntario BOOLEAN NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    disponibilidad BOOLEAN NOT NULL
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
    rutCoordinador VARCHAR(12) NOT NULL,
    nombreCoordinador VARCHAR(255) NOT NULL,
    apellidoCoordinador VARCHAR(255) NOT NULL,  
    contrasena VARCHAR(255) NOT NULL,
    idInstitucion BIGINT,
    FOREIGN KEY (idInstitucion) REFERENCES Institucion(idInstitucion)
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


--Trigger para Coordinador

CREATE TABLE coordindor_disparador(
 idTrigger BIGSERIAL PRIMARY KEY,
 rut coordinador varchar(12),
 nombreCoordinador varchar(255),
 apellidoCoordinador varchar(255),
 contrasena varchar(255),
 fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 operacion TEXT
);



--Insert
CREATE OR REPLACE FUNCTION coordinador_insert_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO coordinador_disparador (id_trigger, rut_coordinador, nombre_coordinador, apellido_coordinador, contrasena,fecha_hora, operacion)
    VALUES (NEW.idTrigger, NEW.rutCoordinador, NEW.nombreCoordinador, NEW.apellidoCoordinador, NEW.contrasena,  CURRENT_TIMESTAMP, 'INSERT');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_trigger_coordinador
AFTER INSERT ON coordinador
FOR EACH ROW
EXECUTE FUNCTION coordinador_insert_trigger_funcion();


--Update
CREATE OR REPLACE FUNCTION coordinador_update_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO coordinador_disparador (id_trigger, rut_coordinador, nombre_coordinador, apellido_coordinador, contrasena,fecha_hora, operacion)
    VALUES (New.idTrigger, NEW.rutCoordinador, NEW.nombreCoordinador, NEW.apellidoCoordinador, NEW.contrasena, CURRENT_TIMESTAMP, 'UPDATE');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_trigger_coordinador
AFTER UPDATE ON coordinador
FOR EACH ROW
EXECUTE FUNCTION coordinador_update_trigger_funcion();


--Delete
CREATE OR REPLACE FUNCTION coordinador_delete_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO coordinador_disparador (id_trigger, rut_coordinador, nombre_coordinador, apellido_coordinador, contrasena,fecha_hora, operacion)
    VALUES (OLD.idTrigger, OLD.rutCoordinador, OLD.nombreCoordinador, OLD.apellidoCoordinador, OLD.contrasena, CURRENT_TIMESTAMP, 'DELETE');
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_trigger_coordinador
AFTER DELETE ON coordinador
FOR EACH ROW
EXECUTE FUNCTION coordinador_delete_trigger_funcion();

