package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    public List<TareaEntity> obtenerTodasLasTareas() {
        return tareaRepository.obtenerTodasLasTareas();
    }
}
