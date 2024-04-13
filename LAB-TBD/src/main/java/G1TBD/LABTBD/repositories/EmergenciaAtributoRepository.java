package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;

import java.util.List;

public interface EmergenciaAtributoRepository {

    EmergenciaAtributoEntity crearEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo);

    List<EmergenciaAtributoEntity> obtenerTodosLosEmergenciaAtributo();

    EmergenciaAtributoEntity obtenerEmergenciaAtributoPorId(long id);

    void actualizarEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo);

    void eliminarEmergenciaAtributo(long id);
}
