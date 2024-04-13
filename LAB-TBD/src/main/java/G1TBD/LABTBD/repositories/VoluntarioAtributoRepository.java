package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;

public interface VoluntarioAtributoRepository {

    void create(VoluntarioAtributoEntity voluntarioAtributo);

    VoluntarioAtributoEntity conseguirPorId(Integer id);

    void update(VoluntarioAtributoEntity voluntarioAtributo);

    void delete(Integer id);
}
