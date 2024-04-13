package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;

public interface VoluntarioAtributoRepository {
    // Crear un voluntarioAtributo
    void create(VoluntarioAtributoEntity voluntarioAtributo);

    // Conseguir voluntarioAtributo por su id
    VoluntarioAtributoEntity conseguirPorId(Integer id);

    // Actualizar datos de un voluntarioAtributo
    void Update(VoluntarioAtributoEntity voluntarioAtributo);

    // Eliminar un VoluntarioAtributo
    void Delete(Integer id);
}
