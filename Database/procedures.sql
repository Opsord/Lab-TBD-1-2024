-- Este procedimiento almacenado genera el reporte de eliminaciones, inserciones y actualizaciones a nivel usuario
CREATE OR REPLACE PROCEDURE obtener_estadisticas_operaciones()
AS $$
DECLARE
    usuario_voluntario RECORD;
    usuario_coordinador RECORD;
BEGIN
    -- Contar operaciones de inserción por voluntarios
    RAISE NOTICE 'Voluntarios con más operaciones de inserción:';
    FOR usuario_voluntario IN
        SELECT rut, nombre, COUNT(*)
        FROM voluntario_disparador
        WHERE operacion = 'INSERT'
        GROUP BY rut, nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Rut: %, Nombre: %, Cantidad: %', usuario_voluntario.rut, usuario_voluntario.nombre, usuario_voluntario.count;
    END LOOP;

    -- Contar operaciones de actualización por voluntarios
    RAISE NOTICE 'Voluntarios con más operaciones de actualización:';
    FOR usuario_voluntario IN
        SELECT rut, nombre, COUNT(*)
        FROM voluntario_disparador
        WHERE operacion = 'UPDATE'
        GROUP BY rut, nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Rut: %, Nombre: %, Cantidad: %', usuario_voluntario.rut, usuario_voluntario.nombre, usuario_voluntario.count;
    END LOOP;

    -- Contar operaciones de eliminación por voluntarios
    RAISE NOTICE 'Voluntarios con más operaciones de eliminación:';
    FOR usuario_voluntario IN
        SELECT rut, nombre, COUNT(*)
        FROM voluntario_disparador
        WHERE operacion = 'DELETE'
        GROUP BY rut, nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Rut: %, Nombre: %, Cantidad: %', usuario_voluntario.rut, usuario_voluntario.nombre, usuario_voluntario.count;
    END LOOP;

    -- Contar operaciones de inserción por coordinadores
    RAISE NOTICE 'Coordinadores con más operaciones de inserción:';
    FOR usuario_coordinador IN
        SELECT rut, nombre, COUNT(*)
        FROM coordinador_disparador
        WHERE operacion = 'INSERT'
        GROUP BY rut, nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Rut: %, Nombre: %, Cantidad: %', usuario_coordinador.rut, usuario_coordinador.nombre, usuario_coordinador.count;
    END LOOP;

    -- Contar operaciones de actualización por coordinadores
    RAISE NOTICE 'Coordinadores con más operaciones de actualización:';
    FOR usuario_coordinador IN
        SELECT rut, nombre, COUNT(*)
        FROM coordinador_disparador
        WHERE operacion = 'UPDATE'
        GROUP BY rut, nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Rut: %, Nombre: %, Cantidad: %', usuario_coordinador.rut, usuario_coordinador.nombre, usuario_coordinador.count;
    END LOOP;

    -- Contar operaciones de eliminación por coordinadores
    RAISE NOTICE 'Coordinadores con más operaciones de eliminación:';
    FOR usuario_coordinador IN
        SELECT rut, nombre, COUNT(*)
        FROM coordinador_disparador
        WHERE operacion = 'DELETE'
        GROUP BY rut, nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Rut: %, Nombre: %, Cantidad: %', usuario_coordinador.rut, usuario_coordinador.nombre, usuario_coordinador.count;
    END LOOP;
END;
$$ LANGUAGE plpgsql;

-- Para llamarlo dentro directamente en la base de dato ejecute: CALL obtener_estadisticas_operaciones();


-- Procedimiento almacenado para el el reporte de cantidad e actulaizaciones, inserciones y eliminaciones de emergencia 
-- Genera el reporte a partir del coordinador que que tenga mas de cada tipo de operacion.
CREATE OR REPLACE PROCEDURE obtener_estadisticas_operaciones_emergencias()
AS $$
DECLARE
    coordinador_insert_max INT;
    coordinador_insert_max_id INT;
    coordinador_update_max INT;
    coordinador_update_max_id INT;
    coordinador_delete_max INT;
    coordinador_delete_max_id INT;
BEGIN
    -- Contar operaciones de inserción por coordinadores
    SELECT COUNT(*), idCoordinador INTO coordinador_insert_max, coordinador_insert_max_id
    FROM emergencia_disparador
    WHERE operacion = 'INSERT'
    GROUP BY idCoordinador
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    -- Contar operaciones de actualización por coordinadores
    SELECT COUNT(*), idCoordinador INTO coordinador_update_max, coordinador_update_max_id
    FROM emergencia_disparador
    WHERE operacion = 'UPDATE'
    GROUP BY idCoordinador
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    -- Contar operaciones de eliminación por coordinadores
    SELECT COUNT(*), idCoordinador INTO coordinador_delete_max, coordinador_delete_max_id
    FROM emergencia_disparador
    WHERE operacion = 'DELETE'
    GROUP BY idCoordinador
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    -- Mostrar resultados
    RAISE NOTICE 'Coordinador con más operaciones de inserción de emergencias: ID = %, Cantidad = %', coordinador_insert_max_id, coordinador_insert_max;
    RAISE NOTICE 'Coordinador con más operaciones de actualización de emergencias: ID = %, Cantidad = %', coordinador_update_max_id, coordinador_update_max;
    RAISE NOTICE 'Coordinador con más operaciones de eliminación de emergencias: ID = %, Cantidad = %', coordinador_delete_max_id, coordinador_delete_max;
END;
$$ LANGUAGE plpgsql;


--Para llamar al procedimiento: CALL obtener_estadisticas_operaciones_emergencias();

