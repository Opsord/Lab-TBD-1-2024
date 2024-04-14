package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VoluntarioEntity;

import java.util.List;

public interface VoluntarioRepository {

    VoluntarioEntity crear(VoluntarioEntity voluntario);

    List<VoluntarioEntity> obtenerTodos();

    VoluntarioEntity obtenerPorId(long id);

    boolean actualizar(VoluntarioEntity voluntario);

    boolean eliminar(long id);

}
