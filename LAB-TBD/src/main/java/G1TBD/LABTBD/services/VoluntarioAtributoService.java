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

    public VoluntarioAtributoEntity crear(VoluntarioAtributoEntity voluntarioAtributo) {
        return voluntarioAtributoRepository.crear(voluntarioAtributo);
    }

    public List<VoluntarioAtributoEntity> obtenerTodos() {
        return voluntarioAtributoRepository.obtenerTodos();
    }

    public VoluntarioAtributoEntity obtenerPorId(long id) {
        return voluntarioAtributoRepository.obtenerPorId(id);
    }

    public boolean actualizar(VoluntarioAtributoEntity voluntarioAtributo) {
        return voluntarioAtributoRepository.actualizar(voluntarioAtributo);
    }

    public boolean eliminar(long id) {
        return voluntarioAtributoRepository.eliminar(id);
    }
}
