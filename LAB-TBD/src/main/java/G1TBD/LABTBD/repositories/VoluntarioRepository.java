package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VoluntarioEntity;

public interface VoluntarioRepository {
    // Crear un voluntario
    void create(VoluntarioEntity voluntario);

    // Conseguir voluntario por su id
    VoluntarioEntity conseguirPorId(Integer id);

    // Actualizar datos de un voluntario
    void Update(VoluntarioEntity voluntario);

    // Eliminar un Coordinador
    void Delete(Integer id);

}
