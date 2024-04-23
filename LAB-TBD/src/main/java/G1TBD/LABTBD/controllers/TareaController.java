package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.TaskEntity;
import G1TBD.LABTBD.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@CrossOrigin
public class TareaController {

    @Autowired
    private TaskService taskService;

    String homeLinkRedirect = "redirect:/tareas";

    @PostMapping("/crear")
    public String crear(@RequestBody TaskEntity tarea) {
        taskService.create(tarea);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<TaskEntity> obtenerTodos() {
        return taskService.getAll();
    }

    @GetMapping("/porId/{id}")
    public TaskEntity obtenerPorId(@PathVariable long id) {
        return taskService.getById(id);
    }


    @GetMapping("/porIdEmergencia/{id}")
    public List<TaskEntity> obtenerPorIdEmergencia(@PathVariable long id) {
        return taskService.getByEmergencyId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody TaskEntity tarea) {
        return taskService.update(tarea);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return taskService.delete(id);
    }

}
