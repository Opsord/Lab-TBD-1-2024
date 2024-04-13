package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping("/tareas")
    public List<TareaEntity> obtenerTodasLasTareas() {
        return tareaService.obtenerTodasLasTareas();
    }
}
