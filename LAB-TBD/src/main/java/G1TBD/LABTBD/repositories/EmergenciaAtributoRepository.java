package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;

import java.util.List;

public interface EmergenciaAtributoRepository {

    EmergenciaAtributoEntity crear(EmergenciaAtributoEntity emergenciaAtributo);

    List<EmergenciaAtributoEntity> obtenerTodos();

    EmergenciaAtributoEntity obtenerPorId(long id);

    boolean actualizar(EmergenciaAtributoEntity emergenciaAtributo);

    boolean eliminar(long id);
}
