package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;

import java.util.List;

public interface TareaRepository {

    TareaEntity crearTarea(TareaEntity tarea);

    List<TareaEntity> obtenerTodasLasTareas();

    TareaEntity obtenerTareaPorId(long id);

    boolean actualizarTarea(TareaEntity tarea);

    boolean eliminarTarea(long id);
}
