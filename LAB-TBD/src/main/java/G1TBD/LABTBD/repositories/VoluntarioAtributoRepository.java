package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;

public interface VoluntarioAtributoRepository {

    VoluntarioAtributoEntity crearVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo);

    VoluntarioAtributoEntity obtenerVoluntarioAtributoPorId(long id);

    void actualizarVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo);

    void eliminarVoluntarioAtributo(long id);
}
