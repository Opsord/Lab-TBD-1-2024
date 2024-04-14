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

    @PostMapping("/crear")
    public String crearTarea(TareaEntity tarea) {
        tareaService.crearTarea(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/todo")
    public List<TareaEntity> obtenerTodasLasTareas() {
        return tareaService.obtenerTodasLasTareas();
    }

    @GetMapping("/porId")
    public TareaEntity obtenerTareaPorId(long id) {
        return tareaService.obtenerTareaPorId(id);
    }

    @PostMapping("/actualizar")
    public String actualizarTarea(TareaEntity tarea) {
        tareaService.actualizarTarea(tarea);
        return "redirect:/tareas";
    }

    @PostMapping("/eliminar")
    public String eliminarTarea(long id) {
        tareaService.eliminarTarea(id);
        return "redirect:/tareas";
    }

}
