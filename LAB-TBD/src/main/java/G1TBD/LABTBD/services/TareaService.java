package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.repositories.TareaRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    TareaRepositoryImp tareaRepository;

    public TareaEntity crearTarea(TareaEntity tarea) {
        return tareaRepository.crear(tarea);
    }

    public List<TareaEntity> obtenerTodasLasTareas() {
        return tareaRepository.obtenerTodos();
    }

    public TareaEntity obtenerTareaPorId(long id) {
        return tareaRepository.obtenerPorId(id);
    }

    public boolean actualizarTarea(TareaEntity tarea) {
        return tareaRepository.actualizar(tarea);
    }

    public boolean eliminarTarea(long id) {
        return tareaRepository.eliminar(id);
    }
}
