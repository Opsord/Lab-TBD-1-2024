package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;

public interface CoordinadorRepository {
    // Crear un Coordinador
    void create(CoordinadorEntity coordinador);

    // Conseguir coordinador por su id
    CoordinadorEntity conseguirPorId(Integer id);

    // Actualizar datos de un coordinador
    void Update(CoordinadorEntity coordinador);

    // Eliminar un Coordinador
    void Delete(Integer id);
}
