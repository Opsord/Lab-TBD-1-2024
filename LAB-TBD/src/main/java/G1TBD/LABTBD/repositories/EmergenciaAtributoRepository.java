package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;

import java.util.List;

public interface EmergenciaAtributoRepository {

    EmergenciaAtributoEntity crear(EmergenciaAtributoEntity emergenciaAtributo);

    List<EmergenciaAtributoEntity> obtenerTodos();

    EmergenciaAtributoEntity obtenerEmergenciaAtributoPorId(long id);

    boolean actualizarEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo);

    boolean eliminarEmergenciaAtributo(long id);
}
