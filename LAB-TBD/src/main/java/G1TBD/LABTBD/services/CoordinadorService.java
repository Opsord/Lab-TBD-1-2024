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

    public CoordinadorEntity obtenerPorRut(String rut) {
        return coordinadorRepository.obtenerPorRut(rut);
    }

    public CoordinadorEntity obtenerPorEmail(String email) {
        return coordinadorRepository.obtenerPorEmail(email);
    }

    public boolean actualizar(CoordinadorEntity coordinador) {
        return coordinadorRepository.actualizar(coordinador);
    }

    public boolean eliminar(String rut) {
        return coordinadorRepository.eliminar(rut);
    }
}
