--Poblacion de la tabla Voluntarios
INSERT INTO Voluntario (idVoluntario, rut, email, nombre, apellido, edadVoluntario, sexoVoluntario, contrasena, disponibilidad, role)
VALUES 
    (1, '12345678-9', 'juan@example.com', 'Juan', 'Pérez', 25, true, 'contraseña123', true, 'VOLUNTARIO'),
    (2, '98765432-1', 'maria@example.com', 'María', 'González', 30, false, 'clave456', false, 'VOLUNTARIO'),
    (3, '11223344-5', 'carlos@example.com', 'Carlos', 'López', 40, true, 'pass1234', true, 'VOLUNTARIO'),
    (4, '55443322-1', 'ana@example.com', 'Ana', 'Martínez', 28, false, '123456', true, 'VOLUNTARIO'),
    (5, '87654321-0', 'pedro@example.com', 'Pedro', 'Sánchez', 35, true, 'p@$$w0rd', false, 'VOLUNTARIO'),
    (6, '33221100-K', 'laura@example.com', 'Laura', 'Rodríguez', 22, false, 'laura123', true, 'VOLUNTARIO'),
    (7, '45678901-2', 'diego@example.com', 'Diego', 'Hernández', 27, true, 'd1ego789', false, 'VOLUNTARIO'),
    (8, '99887766-3', 'sofia@example.com', 'Sofía', 'Gómez', 33, false, 'sofia321', true, 'VOLUNTARIO'),
    (9, '12454633-4', 'miguel@example.com', 'Miguel', 'Díaz', 29, true, 'diazmiguel', true, 'VOLUNTARIO'),
    (10, '44556677-5', 'paula@example.com', 'Paula', 'Fernández', 26, false, 'fernandez', false, 'VOLUNTARIO');

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
    (20, 10, 3);

--Poblacion de la tabla Institucion
INSERT INTO Institucion (idInstitucion, nombreInstitucion) 
VALUES 
    (1, 'Cruz Roja de Chile'),
    (2, 'Bomberos Municipales'),
    (3, 'Equipo de rescate de desastres naturales');

--Poblacion de la tabla Coordinador
INSERT INTO Coordinador (idCoordinador, rut, email, nombre, apellido, contrasena, idInstitucion, role)
VALUES 
    (1, '1234678-9', 'maria_coordinador@example.com', 'María', 'García', 'pass1234', 1, 'COORDINADOR'),
    (2, '9871432-1', 'carlos_coordinador@example.com', 'Carlos', 'Rodríguez', 'contrdawa1', 2, 'COORDINADOR'),
    (3, '1353344-5', 'ana_coordinador@example.com', 'Ana', 'López', '123454321', 3, 'COORDINADOR');

--Poblacion de la tabla Emergencia
INSERT INTO Emergencia (idEmergencia, estadoEmergencia, tituloEmergencia, descripcionEmergencia, idCoordinador)
VALUES 
    (1, true, 'Incendio forestal en zona rural', 'Se ha reportado un incendio forestal en la zona de la Reserva Nacional. Se necesita asistencia inmediata.', 2),
    (2, false, 'Evacuación por fuga de gas', 'Se ha detectado una fuga de gas en un edificio residencial. Se requiere evacuación de los residentes.', 1),
    (3, true, 'Inundación en área urbana', 'Las fuertes lluvias han provocado inundaciones en varios sectores de la ciudad. Se necesitan equipos de rescate.', 3),
    (4, true, 'Accidente de tráfico múltiple', 'Se ha producido un accidente de tráfico en la autopista principal. Varios vehículos están involucrados.', 1),
    (5, false, 'Deslizamiento de tierra en carretera', 'Un deslizamiento de tierra ha bloqueado una carretera importante. Se necesita ayuda para despejar la vía.', 3);

--Poblacion de tabla
-- Población de la tabla Emergencia_Atributo
INSERT INTO Emergencia_Atributo (idEmergenciaAtributo, idEmergencia, idAtributo, compatibilidad)
VALUES 
    (1, 1, 1, true),   -- La emergencia 1 tiene compatibilidad con el atributo 1 (Fuerza física)
    (2, 1, 2, true),   -- La emergencia 1 tiene compatibilidad con el atributo 2 (Rescate en Terreno)
    (3, 1, 3, false),  -- La emergencia 1 no tiene compatibilidad con el atributo 3 (Apoyo psicológico)
    (4, 2, 4, false),  -- La emergencia 2 no tiene compatibilidad con el atributo 4 (Manejo de herramientas de rescate)
    (5, 2, 5, true),   -- La emergencia 2 tiene compatibilidad con el atributo 5 (Conocimientos en primeros auxilios)
    (6, 3, 6, true),   -- La emergencia 3 tiene compatibilidad con el atributo 6 (Manejo de equipos de comunicación)
    (7, 3, 7, true),   -- La emergencia 3 tiene compatibilidad con el atributo 7 (Capacidad para la búsqueda y localización de personas perdidas)
    (8, 4, 1, true),   -- La emergencia 4 tiene compatibilidad con el atributo 1 (Fuerza física)
    (9, 4, 2, false),  -- La emergencia 4 no tiene compatibilidad con el atributo 2 (Rescate en Terreno)
    (10, 5, 6, false), -- La emergencia 5 no tiene compatibilidad con el atributo 6 (Manejo de equipos de comunicación)
    (11, 5, 7, true);  -- La emergencia 5 tiene compatibilidad con el atributo 7 (Capacidad para la búsqueda y localización de personas perdidas)

-- Población de la tabla Tarea
INSERT INTO Tarea (idTarea, idEmergencia, tipoTarea, descripcion, estado)
VALUES 
    (1, 1, 'Evacuación de residentes', 'Coordinar y ejecutar la evacuación de los residentes afectados por el incendio forestal.', true),
    (2, 2, 'Control de fuga de gas', 'Gestionar la contención y control de la fuga de gas en el edificio residencial.', false),
    (3, 3, 'Rescate de personas atrapadas', 'Realizar operaciones de rescate para ayudar a las personas atrapadas por la inundación.', true),
    (4, 4, 'Atención médica a heridos', 'Brindar atención médica a los heridos en el accidente de tráfico múltiple.', true),
    (5, 5, 'Despeje de la carretera', 'Organizar y llevar a cabo el despeje de la carretera bloqueada por el deslizamiento de tierra.', false),
    (6, 1, 'Suministro de alimentos', 'Distribuir alimentos y agua potable a los evacuados.', true),
    (7, 2, 'Apoyo psicológico a afectados', 'Brindar apoyo emocional y asistencia psicológica a las personas afectadas por la fuga de gas.', false);

-- Población de la tabla Ranking
INSERT INTO Ranking (idRanking, idVoluntario, idTarea, valorRanking)
VALUES 
    (1, 1, 1, 4),   -- Juan participó en la evacuación de residentes del incendio forestal y recibió un valor de ranking de 4.
    (2, 2, 2, 3),   -- María estuvo a cargo del control de la fuga de gas y recibió un valor de ranking de 3.
    (3, 3, 3, 5),   -- Carlos participó en el rescate de personas atrapadas por la inundación y recibió un valor de ranking de 5.
    (4, 4, 4, 4),   -- Ana brindó atención médica a los heridos en el accidente de tráfico múltiple y recibió un valor de ranking de 4.
    (5, 5, 5, 2),   -- Pedro ayudó en el despeje de la carretera bloqueada por el deslizamiento de tierra y recibió un valor de ranking de 2.
    (6, 6, 1, 3),   -- Laura participó en la evacuación de residentes del incendio forestal y recibió un valor de ranking de 3.
    (7, 7, 2, 4),   -- Diego estuvo a cargo del control de la fuga de gas y recibió un valor de ranking de 4.
    (8, 8, 3, 5),   -- Sofía participó en el rescate de personas atrapadas por la inundación y recibió un valor de ranking de 5.
    (9, 9, 4, 4),   -- Miguel brindó atención médica a los heridos en el accidente de tráfico múltiple y recibió un valor de ranking de 4.
    (10, 10, 5, 3);-- Paula ayudó en el despeje de la carretera bloqueada por el deslizamiento de tierra y recibió un valor de ranking de 3.
