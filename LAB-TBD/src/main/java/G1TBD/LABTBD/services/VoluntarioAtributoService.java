package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;
import G1TBD.LABTBD.repositories.VoluntarioAtributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioAtributoService {
    @Autowired
    private VoluntarioAtributoRepository voluntarioAtributoRepository;

    public VoluntarioAtributoEntity crearVoluntariAtributo(VoluntarioAtributoEntity voluntarioAtributo) {
        return voluntarioAtributoRepository.crearVoluntarioAtributo(voluntarioAtributo);
    }

    public List<VoluntarioAtributoEntity> obtenerTodosLosVoluntarioAtributo() {
        return voluntarioAtributoRepository.obtenerTodosLosVoluntarioAtributo();
    }

    public VoluntarioAtributoEntity obtenerVoluntarioAtributoPorId(long id) {
        return voluntarioAtributoRepository.obtenerVoluntarioAtributoPorId(id);
    }

    public boolean actualizarVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo) {
        return voluntarioAtributoRepository.actualizarVoluntarioAtributo(voluntarioAtributo);
    }

    public boolean eliminarVoluntarioAtributo(long id) {
        return voluntarioAtributoRepository.eliminarVoluntarioAtributo(id);
    }
}
