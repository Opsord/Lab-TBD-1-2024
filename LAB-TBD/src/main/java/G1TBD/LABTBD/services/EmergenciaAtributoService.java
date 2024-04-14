package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import G1TBD.LABTBD.repositories.EmergenciaAtributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaAtributoService {
    @Autowired
    private EmergenciaAtributoRepository emergenciaAtributoRepository;

    public EmergenciaAtributoEntity crearEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo) {
        return emergenciaAtributoRepository.crear(emergenciaAtributo);
    }

    public List<EmergenciaAtributoEntity> obtenerTodasLasEmergenciaAtributo() {
        return emergenciaAtributoRepository.obtenerTodos();
    }

    public EmergenciaAtributoEntity obtenerEmergenciaAtributoPorId(long id) {
        return emergenciaAtributoRepository.obtenerPorId(id);
    }

    public boolean actualizarEmergenciaAtributo(EmergenciaAtributoEntity voluntarioAtributo) {
        return emergenciaAtributoRepository.actualizar(voluntarioAtributo);
    }

    public boolean eliminarEmargenciaAtributo(long id) {
        return emergenciaAtributoRepository.eliminar(id);
    }
}
