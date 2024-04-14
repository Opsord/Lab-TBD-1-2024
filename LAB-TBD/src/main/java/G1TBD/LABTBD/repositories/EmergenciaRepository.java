package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;

import java.util.List;

public interface EmergenciaRepository {

    EmergenciaEntity crear(EmergenciaEntity emergencia);

    List<EmergenciaEntity> obtenerTodos();

    EmergenciaEntity obtenerPorId(long id);

//    List<EmergenciaEntity> obtenerEmergenciaPorEstado();

    boolean actualizar(EmergenciaEntity emergencia);

    boolean eliminar(long id);
}

