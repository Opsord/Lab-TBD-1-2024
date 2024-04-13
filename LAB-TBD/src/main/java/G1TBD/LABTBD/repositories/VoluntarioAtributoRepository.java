package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;

import java.util.List;

public interface VoluntarioAtributoRepository {

    VoluntarioAtributoEntity crearVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo);

    List<VoluntarioAtributoEntity> obtenerTodosLosVoluntarioAtributo();

    VoluntarioAtributoEntity obtenerVoluntarioAtributoPorId(long id);

    void actualizarVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo);

    void eliminarVoluntarioAtributo(long id);
}
