CREATE TABLE Voluntario (
    idVoluntario BIGSERIAL PRIMARY KEY,
    rutVoluntario VARCHAR(20) NOT NULL,
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
    rutCoordinador VARCHAR(20) NOT NULL,
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



--Trigger para Coordinador

CREATE TABLE coordinador_disparador(
 idTrigger SERIAL PRIMARY KEY,
 rutCoordinador varchar(20),
 nombreCoordinador varchar(255),
 contrasena varchar(255),
 fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 operacion TEXT
);


--Insert
CREATE OR REPLACE FUNCTION coordinador_insert_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO coordinador_disparador (rutCoordinador, nombreCoordinador, contrasena,fecha_hora, operacion)
    VALUES (NEW.rutCoordinador, NEW.nombreCoordinador, NEW.contrasena,  CURRENT_TIMESTAMP, 'INSERT');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_trigger_coordinador
AFTER INSERT ON Coordinador
FOR EACH ROW
EXECUTE FUNCTION coordinador_insert_trigger_funcion();


--Update
CREATE OR REPLACE FUNCTION coordinador_update_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO coordinador_disparador (rutCoordinador, nombreCoordinador, contrasena,fecha_hora, operacion)
    VALUES (NEW.rutCoordinador, NEW.nombreCoordinador,NEW.contrasena, CURRENT_TIMESTAMP, 'UPDATE');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_trigger_coordinador
AFTER UPDATE ON Coordinador
FOR EACH ROW
EXECUTE FUNCTION coordinador_update_trigger_funcion();


--Delete
CREATE OR REPLACE FUNCTION coordinador_delete_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO coordinador_disparador (rutCoordinador, nombreCoordinador, contrasena,fecha_hora, operacion)
    VALUES (OLD.rutCoordinador, OLD.nombreCoordinador, OLD.contrasena, CURRENT_TIMESTAMP, 'DELETE');
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_trigger_coordinador
AFTER DELETE ON Coordinador
FOR EACH ROW
EXECUTE FUNCTION coordinador_delete_trigger_funcion();

--Trigger para voluntario

CREATE TABLE voluntario_disparador (
    idTrigger SERIAL PRIMARY KEY,
    nombreVoluntario VARCHAR(100),
    rutVoluntario VARCHAR(20),
    edadVoluntario INT,
    contrasena VARCHAR(100),
    disponibilidad BOOLEAN,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    operacion TEXT
);


-- Insert
CREATE OR REPLACE FUNCTION voluntario_insert_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO voluntario_disparador(nombreVoluntario, rutVoluntario, edadVoluntario, contrasena, disponibilidad,fecha_hora,operacion)
    VALUES (NEW.nombreVoluntario, NEW.rutVoluntario, NEW.edadVoluntario, NEW.contrasena, NEW.disponibilidad,CURRENT_TIMESTAMP,'INSERT');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_trigger_voluntario
AFTER INSERT ON Voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_insert_trigger_funcion();


--Update
CREATE OR REPLACE FUNCTION voluntario_update_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO voluntario_disparador(nombreVoluntario, rutVoluntario, edadVoluntario, contrasena, disponibilidad,fecha_hora,operacion)
    VALUES (NEW.nombreVoluntario, NEW.rutVoluntario, NEW.edadVoluntario, NEW.contrasena, NEW.disponibilidad,CURRENT_TIMESTAMP,'UPDATE');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_trigger_voluntario
AFTER UPDATE ON Voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_update_trigger_funcion();

--Delete
CREATE OR REPLACE FUNCTION voluntario_delete_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO voluntario_disparador(nombreVoluntario, rutVoluntario, edadVoluntario, contrasena, disponibilidad, fecha_hora, operacion)
    VALUES (OLD.nombreVoluntario, OLD.rutVoluntario, OLD.edadVoluntario, OLD.contrasena, OLD.disponibilidad,CURRENT_TIMESTAMP,'DELETE');
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_trigger_voluntario
AFTER DELETE ON Voluntario
FOR EACH ROW
EXECUTE FUNCTION voluntario_delete_trigger_funcion();



-- Trigger para Emergencia

CREATE TABLE emergencia_disparador (
    idTrigger SERIAL PRIMARY KEY,
    idEmergencia INT,
    estadoEmergencia BOOLEAN,
    tituloEmergencia VARCHAR(100),
    descripcionEmergencia TEXT,
    idCoordinador INT,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    operacion TEXT
);


-- INSERT
CREATE OR REPLACE FUNCTION emergencia_delete_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO emergencia_disparador (idEmergencia, estadoEmergencia, tituloEmergencia, descripcionEmergencia, idCoordinador,hora_fecha,operacion)
    VALUES (NEW.idEmergencia, NEW.estadoEmergencia, NEW.tituloEmergencia, NEW.descripcionEmergencia, NEW.idCoordinador,CURRENT_TIMESTAMP, 'INSERT' );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_trigger_emergencia
AFTER INSERT ON Emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_delete_trigger_funcion();


-- UPDATE
CREATE OR REPLACE FUNCTION emergencia_update_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO emergencia_disparador (idEmergencia, estadoEmergencia, tituloEmergencia, descripcionEmergencia, idCoordinador, fecha_hora,operacion)
    VALUES (NEW.idEmergencia, NEW.estadoEmergencia, NEW.tituloEmergencia, NEW.descripcionEmergencia, NEW.idCoordinador,CURRENT_TIMESTAMP, 'UPDATE');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_trigger_emergencia
AFTER UPDATE ON Emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_update_trigger_funcion();


--DELETE
CREATE OR REPLACE FUNCTION emergencia_delete_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO emergencia_disparador (idEmergencia, estadoEmergencia, tituloEmergencia, descripcionEmergencia, idCoordinador,fecha_hora,operacion)
    VALUES (OLD.idEmergencia, OLD.estadoEmergencia, OLD.tituloEmergencia, OLD.descripcionEmergencia, OLD.idCoordinador, CURRENT_TIMESTAMP, 'DELETE');
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_trigger_emergencia
AFTER DELETE ON Emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_delete_trigger_funcion();


-- Trigger para EmergenciaAtributo

CREATE TABLE emergenciaAtributo_disparador (
    idTrigger SERIAL PRIMARY KEY,
    idEmergenciaAtributo INT,
    idEmergencia INT,
    idAtributo INT,
    compatibilidad BOOLEAN,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    operacion TEXT
);


-- INSERT

CREATE OR REPLACE FUNCTION emergencia_atributo_insert_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO emergenciaAtributo_disparador(idEmergenciaAtributo, idEmergencia, idAtributo, compatibilidad, fecha_hora, operacion)
    VALUES (NEW.idEmergenciaAtributo, NEW.idEmergencia, NEW.idAtributo, NEW.compatibilidad, CURRENT_TIMESTAMP, 'INSERT');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_trigger_emergencia_atributo
AFTER INSERT ON Emergencia_Atributo
FOR EACH ROW
EXECUTE FUNCTION emergencia_atributo_insert_trigger_funcion();


-- UPDATE

CREATE OR REPLACE FUNCTION emergencia_atributo_update_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO emergenciaAtributo_disparador(idEmergenciaAtributo, idEmergencia, idAtributo, compatibilidad, fecha_hora, operacion)
    VALUES (NEW.idEmergenciaAtributo, NEW.idEmergencia, NEW.idAtributo, NEW.compatibilidad, CURRENT_TIMESTAMP, 'UPDATE');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_trigger_emergencia_atributo
AFTER UPDATE ON Emergencia_Atributo
FOR EACH ROW
EXECUTE FUNCTION emergencia_atributo_update_trigger_funcion();


-- DELETE

CREATE OR REPLACE FUNCTION emergencia_atributo_delete_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO emergenciaAtributo_disparador(idEmergenciaAtributo, idEmergencia, idAtributo, compatibilidad, fecha_ora, operacion)
    VALUES (OLD.idEmergenciaAtributo, OLD.idEmergencia, OLD.idAtributo, OLD.compatibilidad, CURRENT_TIMESTAMP,'DELETE');
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_trigger_emergencia_atributo
AFTER DELETE ON Emergencia_Atributo
FOR EACH ROW
EXECUTE FUNCTION emergencia_atributo_delete_trigger_funcion();
