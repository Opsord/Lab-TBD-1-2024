package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VoluntarioEntity;

public interface VoluntarioRepository {

    VoluntarioEntity crearVoluntario(VoluntarioEntity voluntario);

    VoluntarioEntity obtenerVoluntarioPorId(long id);

    void actualizarVoluntario(VoluntarioEntity voluntario);

    void eliminarVoluntario(long id);

}
