package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;

import java.util.List;

public interface TareaRepository {
    public TareaEntity crearTarea(TareaEntity tarea);

    public List<TareaEntity> obtenerTodasLasTareas();

    public TareaEntity obtenerPorId(long id);

    public void actualizarTarea(TareaEntity tarea);

    public void eliminarTarea(long id);
}
