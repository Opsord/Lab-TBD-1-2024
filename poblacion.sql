--Poblacion de la tabla Voluntarios
INSERT INTO Voluntario (idVoluntario, rutVoluntario, nombreVoluntario, apellidoVoluntario, edadVoluntario, sexoVoluntario, contrasena, disponibilidad)
VALUES 
    (1, '12345678-9', 'Juan', 'Pérez', 25, true, 'contraseña123', true),
    (2, '98765432-1', 'María', 'González', 30, false, 'clave456', false),
    (3, '11223344-5', 'Carlos', 'López', 40, true, 'pass1234', true),
    (4, '55443322-1', 'Ana', 'Martínez', 28, false, '123456', true),
    (5, '87654321-0', 'Pedro', 'Sánchez', 35, true, 'p@$$w0rd', false),
    (6, '33221100-K', 'Laura', 'Rodríguez', 22, false, 'laura123', true),
    (7, '45678901-2', 'Diego', 'Hernández', 27, true, 'd1ego789', false),
    (8, '99887766-3', 'Sofía', 'Gómez', 33, false, 'sofia321', true),
    (9, '12454633-4', 'Miguel', 'Díaz', 29, true, 'diazmiguel', true),
    (10, '44556677-5', 'Paula', 'Fernández', 26, false, 'fernandez', false);

--Poblacion de la tabla Atributo
INSERT INTO Atributo (idAtributo, atributo)
VALUES 
    (1, 'Fuerza fisica'),
    (2, 'Rescate en Terreno'),
    (3, 'Apoyo psicologico'),
    (4, 'Manejo de herramientas de rescate'),
    (5, 'Conocimientos en primeros auxilios'),
    (6, 'Manejo de equipos de comunicacion'),
    (7, 'Capacidad para la búsqueda y localización de personas perdidas');

--Poblacion de la tabla Voluntario_Atributo
INSERT INTO Voluntario_Atributo (idVoluntarioAtributo, idVoluntario, idAtributo)
VALUES 
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 3),
    (4, 2, 4), 
    (5, 3, 5),
    (6, 3, 6),
    (7, 4, 7), 
    (8, 4, 1), 
    (9, 5, 4), 
    (10, 5, 1), 
    (11, 6, 6), 
    (12, 6, 7), 
    (13, 7, 1),
    (14, 7, 2), 
    (15, 8, 7), 
    (16, 8, 3),
    (17, 9, 1),
    (18, 9, 2), 
    (19, 10, 7), 
    (20, 10, 3),

--Poblacion de la tabla Institucion
INSERT INTO Institucion (idInstitucion, nombreInstitucion) 
VALUES 
    (1, 'Cruz Roja de Chile'),
    (2, 'Bomberos Municipales'),
    (3, 'Equipo de rescate de desastres naturales');

--Poblacion de la tabla Coordinador
INSERT INTO Coordinador (idCoordinador, rutCoordinador, nombreCoordinador, apellidoCoordinador, contrasena, idInstitucion)
VALUES 
    (1, '12341678-9', 'María', 'García', 'pass1234', 1),
    (2, '98761432-1', 'Carlos', 'Rodríguez', 'contrdawa1', 2),
    (3, '13553344-5', 'Ana', 'López', '123454321', 3);

--Poblacion de la tabla Emergencia
INSERT INTO Emergencia (idEmergencia, estadoEmergencia, tituloEmergencia, descripcionEmergencia, idCoordinador)
VALUES 
    (1, true, 'Incendio forestal en zona rural', 'Se ha reportado un incendio forestal en la zona de la Reserva Nacional. Se necesita asistencia inmediata.', 2),
    (2, false, 'Evacuación por fuga de gas', 'Se ha detectado una fuga de gas en un edificio residencial. Se requiere evacuación de los residentes.', 1),
    (3, true, 'Inundación en área urbana', 'Las fuertes lluvias han provocado inundaciones en varios sectores de la ciudad. Se necesitan equipos de rescate.', 3),
    (4, true, 'Accidente de tráfico múltiple', 'Se ha producido un accidente de tráfico en la autopista principal. Varios vehículos están involucrados.', 1),
    (5, false, 'Deslizamiento de tierra en carretera', 'Un deslizamiento de tierra ha bloqueado una carretera importante. Se necesita ayuda para despejar la vía.', 3);






