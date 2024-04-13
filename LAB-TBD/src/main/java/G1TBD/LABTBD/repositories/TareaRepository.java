package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;

import java.util.List;

public interface TareaRepository {

    public TareaEntity create(TareaEntity tarea);

    public List<TareaEntity> obtenerTodos();

    public TareaEntity obtenerPorId(long id);

    public void update(TareaEntity tarea);

    public void delete(long id);
}
