package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import G1TBD.LABTBD.repositories.EmergenciaAtributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmergenciaAtributoService {
    
    @Autowired
    private EmergenciaAtributoRepository emergenciaAtributoRepository;

    public EmergenciaAtributoEntity crear(EmergenciaAtributoEntity emergenciaAtributo) {
        return emergenciaAtributoRepository.crear(emergenciaAtributo);
    }

    public List<EmergenciaAtributoEntity> crearVarios(List<EmergenciaAtributoEntity> emergenciasAtributo) {
        List<EmergenciaAtributoEntity> emergenciasCreadas = new ArrayList<>();
        for (EmergenciaAtributoEntity emergenciaAtributo : emergenciasAtributo) {
            EmergenciaAtributoEntity emergenciaCreada = crear(emergenciaAtributo);
            emergenciasCreadas.add(emergenciaCreada);
        }
        return emergenciasCreadas;
    }



    public List<EmergenciaAtributoEntity> obtenerTodos() {
        return emergenciaAtributoRepository.obtenerTodos();
    }

    public EmergenciaAtributoEntity obtenerPorId(long id) {
        return emergenciaAtributoRepository.obtenerPorId(id);
    }

    public boolean actualizar(EmergenciaAtributoEntity voluntarioAtributo) {
        return emergenciaAtributoRepository.actualizar(voluntarioAtributo);
    }

    public boolean eliminar(long id) {
        return emergenciaAtributoRepository.eliminar(id);
    }
}
