--Trigger para Coordinador

CREATE TABLE coordinador_disparador(
 idTrigger SERIAL PRIMARY KEY,
 rut varchar(20),
 email varchar(255),
 nombre varchar(255),
 contrasena varchar(255),
 fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 operacion TEXT
);


--Insert
CREATE OR REPLACE FUNCTION coordinador_insert_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO coordinador_disparador (rut, email,nombre, contrasena,fecha_hora, operacion)
    VALUES (NEW.rut, NEW.email, NEW.nombre, NEW.contrasena,  CURRENT_TIMESTAMP, 'INSERT');
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
    INSERT INTO coordinador_disparador (rut, email, nombre, contrasena,fecha_hora, operacion)
    VALUES (NEW.rut, NEW.email, NEW.nombre,NEW.contrasena, CURRENT_TIMESTAMP, 'UPDATE');
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
    INSERT INTO coordinador_disparador (rut, email,nombre, contrasena,fecha_hora, operacion)
    VALUES (OLD.rut, OLD.email, OLD.nombre, OLD.contrasena, CURRENT_TIMESTAMP, 'DELETE');
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
    nombre VARCHAR(100),
    rut VARCHAR(20),
    email VARCHAR(255),
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
    INSERT INTO voluntario_disparador(nombre, email, rut,edadVoluntario, contrasena, disponibilidad,fecha_hora,operacion)
    VALUES (NEW.nombre, NEW.email, NEW.rut, NEW.edadVoluntario, NEW.contrasena, NEW.disponibilidad,CURRENT_TIMESTAMP,'INSERT');
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
    INSERT INTO voluntario_disparador(nombre, rut, email,edadVoluntario, contrasena, disponibilidad,fecha_hora,operacion)
    VALUES (NEW.nombre, NEW.rut, NEW.email, NEW.edadVoluntario, NEW.contrasena, NEW.disponibilidad,CURRENT_TIMESTAMP,'UPDATE');
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
    INSERT INTO voluntario_disparador(nombre, rut, edadVoluntario,email, contrasena, disponibilidad, fecha_hora, operacion)
    VALUES (OLD.nombre, OLD.rut, OLD.email, OLD.edadVoluntario, OLD.contrasena, OLD.disponibilidad,CURRENT_TIMESTAMP,'DELETE');
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
CREATE OR REPLACE FUNCTION emergencia_insert_trigger_funcion()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO emergencia_disparador (idEmergencia, estadoEmergencia, tituloEmergencia, descripcionEmergencia, idCoordinador,fecha_hora,operacion)
    VALUES (NEW.idEmergencia, NEW.estadoEmergencia, NEW.tituloEmergencia, NEW.descripcionEmergencia, NEW.idCoordinador,CURRENT_TIMESTAMP, 'INSERT' );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER insert_trigger_emergencia
AFTER INSERT ON Emergencia
FOR EACH ROW
EXECUTE FUNCTION emergencia_insert_trigger_funcion();


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
    INSERT INTO emergenciaAtributo_disparador(idEmergenciaAtributo, idEmergencia, idAtributo, compatibilidad, fecha_hora, operacion)
    VALUES (OLD.idEmergenciaAtributo, OLD.idEmergencia, OLD.idAtributo, OLD.compatibilidad, CURRENT_TIMESTAMP,'DELETE');
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_trigger_emergencia_atributo
AFTER DELETE ON Emergencia_Atributo
FOR EACH ROW
EXECUTE FUNCTION emergencia_atributo_delete_trigger_funcion();
