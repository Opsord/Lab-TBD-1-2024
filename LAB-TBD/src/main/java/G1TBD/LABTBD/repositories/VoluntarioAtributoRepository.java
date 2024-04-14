package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;

import java.util.List;

public interface VoluntarioAtributoRepository {

    VoluntarioAtributoEntity crear(VoluntarioAtributoEntity voluntarioAtributo);

    List<VoluntarioAtributoEntity> obtenerTodos();

    VoluntarioAtributoEntity obtenerPorId(long id);

    boolean actualizar(VoluntarioAtributoEntity voluntarioAtributo);

    boolean eliminar(long id);
}
