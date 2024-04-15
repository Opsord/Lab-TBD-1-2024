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

    public CoordinadorEntity crear(CoordinadorEntity coordinador) {
        return coordinadorRepository.crear(coordinador);
    }

    public List<CoordinadorEntity> obtenerTodos() {
        return coordinadorRepository.obtenerTodos();
    }

    public CoordinadorEntity obtenerPorId(long id) {
        return coordinadorRepository.obtenerPorId(id);
    }

    public boolean actualizar(CoordinadorEntity coordinador) {
        return coordinadorRepository.actualizar(coordinador);
    }

    public boolean eliminar(long id) {
        return coordinadorRepository.eliminar(id);
    }
}
