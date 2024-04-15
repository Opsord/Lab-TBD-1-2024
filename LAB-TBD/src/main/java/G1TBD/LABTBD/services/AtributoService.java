package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.AtributoEntity;
import G1TBD.LABTBD.repositories.AtributoRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtributoService {

    @Autowired
    private AtributoRepositoryImp atributoRepository;

    public AtributoEntity crear(AtributoEntity atributo) {
        return atributoRepository.crear(atributo);
    }

    public List<AtributoEntity> obtenerTodos() {
        return atributoRepository.obtenerTodos();
    }

    public AtributoEntity obtenerPorId(long id) {
        return atributoRepository.obtenerPorId(id);
    }

    public boolean actualizar(AtributoEntity atributo) {
        return atributoRepository.actualizar(atributo);
    }

    public boolean eliminar(long id) {
        return atributoRepository.eliminar(id);
    }
}
