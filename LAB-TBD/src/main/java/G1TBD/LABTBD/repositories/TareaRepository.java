package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;

import java.util.List;
import java.util.UUID;

public interface TareaRepository {

    TareaEntity crear(TareaEntity tarea);

    List<TareaEntity> obtenerTodos();

    TareaEntity obtenerPorId(long id);

    boolean actualizar(TareaEntity tarea);

    boolean eliminar(long id);

    List<TareaEntity> obtenerTareasPorIdEmergencia(long idEmergencia);
}
