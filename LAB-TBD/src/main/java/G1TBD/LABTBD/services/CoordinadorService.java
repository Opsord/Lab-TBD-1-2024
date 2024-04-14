package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import G1TBD.LABTBD.repositories.CoordinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinadorService {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    public CoordinadorEntity crearCoordinador(CoordinadorEntity coordinador) {
        return coordinadorRepository.crear(coordinador);
    }

    public List<CoordinadorEntity> obtenerTodosLosCoordinadores() {
        return coordinadorRepository.obtenerTodos();
    }

    public CoordinadorEntity obtenerCoordinadorPorId(long id) {
        return coordinadorRepository.obtenerPorId(id);
    }

    public boolean actualizarCoordinador(CoordinadorEntity coordinador) {
        return coordinadorRepository.actualizar(coordinador);
    }

    public boolean eliminarCoordinador(long id) {
        return coordinadorRepository.eliminar(id);
    }
}
