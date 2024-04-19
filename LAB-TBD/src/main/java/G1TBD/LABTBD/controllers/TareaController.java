package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@CrossOrigin(origins = "http://localhost:8090/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    String homeLinkRedirect = "redirect:/tareas";

    @PostMapping("/crear")
    public String crear(@RequestBody TareaEntity tarea) {
        tareaService.crear(tarea);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<TareaEntity> obtenerTodos() {
        return tareaService.obtenerTodos();
    }

    @GetMapping("/porId/{id}")
    public TareaEntity obtenerPorId(@PathVariable long id) {
        return tareaService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody TareaEntity tarea) {
        return tareaService.actualizar(tarea);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return tareaService.eliminar(id);
    }

}
