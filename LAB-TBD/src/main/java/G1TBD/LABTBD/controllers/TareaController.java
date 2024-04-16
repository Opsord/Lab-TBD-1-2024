package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    String homeLinkRedirect = "redirect:/tareas";

    @PostMapping("/crear")
    public String crear(TareaEntity tarea) {
        tareaService.crear(tarea);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<TareaEntity> obtenerTodos() {
        return tareaService.obtenerTodos();
    }

    @GetMapping("/porId")
    public TareaEntity obtenerPorId(long id) {
        return tareaService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizar(TareaEntity tarea) {
        return tareaService.actualizar(tarea);
    }

    @PostMapping("/eliminar")
    public boolean eliminar(long id) {
        return tareaService.eliminar(id);
    }

}
