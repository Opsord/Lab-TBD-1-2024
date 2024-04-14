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

    public VoluntarioEntity crearVoluntario(VoluntarioEntity voluntario) {
        return voluntarioRepository.crearVoluntario(voluntario);
    }

    public List<VoluntarioEntity> obtenerTodosLosVoluntarios() {
        return voluntarioRepository.obtenerTodosLosVoluntarios();
    }

    public VoluntarioEntity obtenerVoluntarioPorId(long id) {
        return voluntarioRepository.obtenerVoluntarioPorId(id);
    }

    public boolean actualizarVoluntario(VoluntarioEntity voluntario) {
        return voluntarioRepository.actualizarVoluntario(voluntario);
    }

    public boolean eliminarVoluntario(long id) {
        return voluntarioRepository.eliminarVoluntario(id);
    }
}
