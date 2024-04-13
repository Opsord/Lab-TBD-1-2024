package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface EmergenciaRepository {

    EmergenciaEntity crearEmergencia(EmergenciaEntity emergencia);

    List<EmergenciaEntity> obtenerTodasLasEmergencias();

    EmergenciaEntity obtenerEmergenciaPorId(long id);

//    List<EmergenciaEntity> obtenerEmergenciaPorEstado();

    boolean actualizarEmergencia(EmergenciaEntity emergencia);

    boolean eliminarEmergencia(long id);
}
