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
        return coordinadorRepository.crearCoordinador(coordinador);
    }

    public List<CoordinadorEntity> obtenerTodosLosCoordinadores() {
        return coordinadorRepository.obtenerTodosLosCoordinadores();
    }

    public CoordinadorEntity obtenerCoordinadorPorId(long id) {
        return coordinadorRepository.obtenerCoordinadorPorId(id);
    }

    public boolean actualizarCoordinador(CoordinadorEntity coordinador) {
        return coordinadorRepository.actualizarCoordinador(coordinador);
    }

    public boolean eliminarCoordinador(long id) {
        return coordinadorRepository.eliminarCoordinador(id);
    }
}
