CREATE OR REPLACE PROCEDURE ReporteUsuariosActivos()
LANGUAGE plpgsql
AS $$
DECLARE
    usuario_con_mas_insert_coordinador RECORD;
    usuario_con_mas_insert_voluntario RECORD;
    usuario_con_mas_update_coordinador RECORD;
    usuario_con_mas_update_voluntario RECORD;
    usuario_coordinador RECORD;
    usuario_voluntario RECORD;
    total_insert_coordinador INT;
    total_insert_voluntario INT;
    total_update_coordinador INT;
    total_update_voluntario INT;
BEGIN
    CREATE TEMP TABLE temp_ranked_logs AS
    SELECT rutCoordinador AS usuario, operacion, fecha_hora AS fecha, 'Coordinador' AS tipo_usuario
    FROM coordinador_disparador
    UNION ALL
    SELECT rutVoluntario AS usuario, operacion, fecha_hora AS fecha, 'Voluntario' AS tipo_usuario
    FROM voluntario_disparador;

    -- Obtener el usuario coordinador con más operaciones de INSERT y su total
    SELECT INTO usuario_con_mas_insert_coordinador usuario, COUNT(*) AS total_insert_coordinador
    FROM temp_ranked_logs
    WHERE operacion = 'INSERT' AND tipo_usuario = 'Coordinador'
    GROUP BY usuario
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    -- Obtener el usuario voluntario con más operaciones de INSERT y su total
    SELECT INTO usuario_con_mas_insert_voluntario usuario, COUNT(*) AS total_insert_voluntario
    FROM temp_ranked_logs
    WHERE operacion = 'INSERT' AND tipo_usuario = 'Voluntario'
    GROUP BY usuario
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    -- Obtener el usuario coordinador con más operaciones de UPDATE y su total
    SELECT INTO usuario_con_mas_update_coordinador usuario, COUNT(*) AS total_update_coordinador
    FROM temp_ranked_logs
    WHERE operacion = 'UPDATE' AND tipo_usuario = 'Coordinador'
    GROUP BY usuario
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    -- Obtener el usuario voluntario con más operaciones de UPDATE y su total
    SELECT INTO usuario_con_mas_update_voluntario usuario, COUNT(*) AS total_update_voluntario
    FROM temp_ranked_logs
    WHERE operacion = 'UPDATE' AND tipo_usuario = 'Voluntario'
    GROUP BY usuario
    ORDER BY COUNT(*) DESC
    LIMIT 1;

    -- Obtener al menos un usuario coordinador
    SELECT INTO usuario_coordinador usuario
    FROM temp_ranked_logs
    WHERE tipo_usuario = 'Coordinador'
    LIMIT 1;

    -- Obtener al menos un usuario voluntario
    SELECT INTO usuario_voluntario usuario
    FROM temp_ranked_logs
    WHERE tipo_usuario = 'Voluntario'
    LIMIT 1;

    -- Imprimir los datos del usuario coordinador con más operaciones de INSERT
    RAISE NOTICE 'Usuario con más INSERT (Coordinador): Rut: %, Cantidad total: %, Operación: INSERT', usuario_con_mas_insert_coordinador.usuario, usuario_con_mas_insert_coordinador.total_insert_coordinador;

    -- Imprimir los datos del usuario voluntario con más operaciones de INSERT
    RAISE NOTICE 'Usuario con más INSERT (Voluntario): Rut: %, Cantidad total: %, Operación: INSERT', usuario_con_mas_insert_voluntario.usuario, usuario_con_mas_insert_voluntario.total_insert_voluntario;

    -- Imprimir los datos del usuario coordinador con más operaciones de UPDATE
    RAISE NOTICE 'Usuario con más UPDATE (Coordinador): Rut: %, Cantidad total: %, Operación: UPDATE', usuario_con_mas_update_coordinador.usuario, usuario_con_mas_update_coordinador.total_update_coordinador;

    -- Imprimir los datos del usuario voluntario con más operaciones de UPDATE
    RAISE NOTICE 'Usuario con más UPDATE (Voluntario): Rut: %, Cantidad total: %, Operación: UPDATE', usuario_con_mas_update_voluntario.usuario, usuario_con_mas_update_voluntario.total_update_voluntario;

 

    DROP TABLE IF EXISTS temp_ranked_logs;
END;
$$;


--Para llamarlo desde ls base de dato use: CALL ReporteUsuariosActivos();
--Falta que genere el reporte para los delete
