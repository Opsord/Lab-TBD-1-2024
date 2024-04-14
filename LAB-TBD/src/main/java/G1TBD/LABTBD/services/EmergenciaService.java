package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    public EmergenciaEntity crearEmergencia(EmergenciaEntity emergencia) {
        return emergenciaRepository.crearEmergencia(emergencia);
    }

    public List<EmergenciaEntity> obtenerTodasLasEmergencias() {
        return emergenciaRepository.obtenerTodasLasEmergencias();
    }

    public EmergenciaEntity obtenerEmergenciaPorId(long id) {
        return emergenciaRepository.obtenerEmergenciaPorId(id);
    }

    public boolean actualizarEmergencia(EmergenciaEntity emergencia) {
        return emergenciaRepository.actualizarEmergencia(emergencia);
    }

    public boolean eliminarEmergencia(long id) {
        return emergenciaRepository.eliminarEmergencia(id);
    }
}
