package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;

import java.util.List;

public interface TareaRepository {

    public TareaEntity crearTarea(TareaEntity tarea);

    public List<TareaEntity> obtenerTodasLasTareas();

    public TareaEntity obtenerTareaPorId(long id);

    public void actualizarTarea(TareaEntity tarea);

    public void eliminarTarea(long id);
}
