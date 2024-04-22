package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;

import java.util.List;

public interface EmergenciaRepository {

    EmergenciaEntity crear(EmergenciaEntity emergencia);

    List<EmergenciaEntity> obtenerTodos();
    List<EmergenciaEntity> obtenerTodasActivas();
    List<EmergenciaEntity> obtenerTodasFinalizadas();

    EmergenciaEntity obtenerPorId(long id);

//    List<EmergenciaEntity> obtenerEmergenciaPorEstado();

    boolean actualizar(EmergenciaEntity emergencia);

    boolean eliminar(long id);

    List<EmergenciaEntity> encontrarEmergenciasFinalizadas();
}

