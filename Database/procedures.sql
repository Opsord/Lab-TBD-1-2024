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
        SELECT nombre, COUNT(*)
        FROM voluntario_disparador
        WHERE operacion = 'INSERT'
        GROUP BY nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Usuario: %, Cantidad: %', usuario_voluntario.nombre, usuario_voluntario.count;
    END LOOP;

    -- Contar operaciones de actualización por voluntarios
    RAISE NOTICE 'Voluntarios con más operaciones de actualización:';
    FOR usuario_voluntario IN
        SELECT nombre, COUNT(*)
        FROM voluntario_disparador
        WHERE operacion = 'UPDATE'
        GROUP BY nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Usuario: %, Cantidad: %', usuario_voluntario.nombre, usuario_voluntario.count;
    END LOOP;

    -- Contar operaciones de eliminación por voluntarios
    RAISE NOTICE 'Voluntarios con más operaciones de eliminación:';
    FOR usuario_voluntario IN
        SELECT nombre, COUNT(*)
        FROM voluntario_disparador
        WHERE operacion = 'DELETE'
        GROUP BY nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Usuario: %, Cantidad: %', usuario_voluntario.nombre, usuario_voluntario.count;
    END LOOP;

    -- Contar operaciones de inserción por coordinadores
    RAISE NOTICE 'Coordinadores con más operaciones de inserción:';
    FOR usuario_coordinador IN
        SELECT nombre, COUNT(*)
        FROM coordinador_disparador
        WHERE operacion = 'INSERT'
        GROUP BY nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Usuario: %, Cantidad: %', usuario_coordinador.nombre, usuario_coordinador.count;
    END LOOP;

    -- Contar operaciones de actualización por coordinadores
    RAISE NOTICE 'Coordinadores con más operaciones de actualización:';
    FOR usuario_coordinador IN
        SELECT nombre, COUNT(*)
        FROM coordinador_disparador
        WHERE operacion = 'UPDATE'
        GROUP BY nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Usuario: %, Cantidad: %', usuario_coordinador.nombre, usuario_coordinador.count;
    END LOOP;

    -- Contar operaciones de eliminación por coordinadores
    RAISE NOTICE 'Coordinadores con más operaciones de eliminación:';
    FOR usuario_coordinador IN
        SELECT nombre, COUNT(*)
        FROM coordinador_disparador
        WHERE operacion = 'DELETE'
        GROUP BY nombre
        ORDER BY COUNT(*) DESC
        LIMIT 1
    LOOP
        RAISE NOTICE 'Usuario: %, Cantidad: %', usuario_coordinador.nombre, usuario_coordinador.count;
    END LOOP;
END;
$$ LANGUAGE plpgsql;

-- Para llamarlo dentro directamente en la base de dato ejecute: CALL obtener_estadisticas_operaciones();



