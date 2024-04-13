package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VoluntarioEntity;

import java.util.List;

public interface VoluntarioRepository {

    VoluntarioEntity crearVoluntario(VoluntarioEntity voluntario);

    List<VoluntarioEntity> obtenerTodosLosVoluntarios();

    VoluntarioEntity obtenerVoluntarioPorId(long id);

    boolean actualizarVoluntario(VoluntarioEntity voluntario);

    boolean eliminarVoluntario(long id);

}
