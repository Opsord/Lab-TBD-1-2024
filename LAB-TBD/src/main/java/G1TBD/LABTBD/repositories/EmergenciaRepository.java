package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;

import java.util.List;

public interface EmergenciaRepository {

    EmergenciaEntity crear(EmergenciaEntity emergencia);

    List<EmergenciaEntity> obtenerTodos();
    List<EmergenciaEntity> obtenerTodasActivas();

    EmergenciaEntity obtenerPorId(long id);


    boolean actualizar(EmergenciaEntity emergencia);

    boolean eliminar(long id);

    List<EmergenciaEntity> encontrarEmergenciasFinalizadas();
}

