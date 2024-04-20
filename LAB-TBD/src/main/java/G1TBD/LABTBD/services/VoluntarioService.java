package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.VoluntarioEntity;
import G1TBD.LABTBD.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public VoluntarioEntity crear(VoluntarioEntity voluntario) {
        return voluntarioRepository.crear(voluntario);
    }

    public List<VoluntarioEntity> obtenerTodos() {
        return voluntarioRepository.obtenerTodos();
    }

    public VoluntarioEntity obtenerPorRut(String rut) {
        return voluntarioRepository.obtenerPorRut(rut);
    }

    public boolean actualizar(VoluntarioEntity voluntario) {
        return voluntarioRepository.actualizar(voluntario);
    }

    public boolean eliminar(String rut) {
        return voluntarioRepository.eliminar(rut);
    }
}
