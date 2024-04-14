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

    public AtributoEntity crearAtributo(AtributoEntity atributo) {
        return atributoRepository.crear(atributo);
    }

    public List<AtributoEntity> obtenerTodosLosAtributos() {
        return atributoRepository.obtenerTodos();
    }

    public AtributoEntity obtenerAtributoPorId(long id) {
        return atributoRepository.obtenerPorId(id);
    }

    public boolean actualizarAtributo(AtributoEntity atributo) {
        return atributoRepository.actualizar(atributo);
    }

    public boolean eliminarAtributo(long id) {
        return atributoRepository.eliminar(id);
    }
}
