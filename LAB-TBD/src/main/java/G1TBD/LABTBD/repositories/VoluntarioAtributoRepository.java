package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;

import java.util.List;

public interface VoluntarioAtributoRepository {

    VoluntarioAtributoEntity crearVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo);

    List<VoluntarioAtributoEntity> obtenerTodosLosVoluntarioAtributo();

    VoluntarioAtributoEntity obtenerVoluntarioAtributoPorId(long id);

    boolean actualizarVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo);

    boolean eliminarVoluntarioAtributo(long id);
}
