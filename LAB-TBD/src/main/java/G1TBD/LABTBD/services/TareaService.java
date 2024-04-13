package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.repositories.TareaRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    TareaRepositoryImp tareaRepository;

    public List<TareaEntity> obtenerTodasLasTareas() {
        return tareaRepository.obtenerTodasLasTareas();
    }
}
