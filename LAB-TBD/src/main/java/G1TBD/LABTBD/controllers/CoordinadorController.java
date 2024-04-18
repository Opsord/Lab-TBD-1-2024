package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import G1TBD.LABTBD.services.CoordinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordinadores")
@CrossOrigin(origins = "http://localhost:8090/coordinadores")
public class CoordinadorController {

    @Autowired
    private CoordinadorService coordinadorService;

    String homeLinkRedirect = "redirect:/coordinadores";

    @PostMapping("/crear")
    public String crear(CoordinadorEntity coordinador) {
        coordinadorService.crear(coordinador);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<CoordinadorEntity> obtenerTodos() {
        return coordinadorService.obtenerTodos();
    }

    @GetMapping("/porId/{id}")
    public CoordinadorEntity obtenerPorId(@PathVariable long id) {
        return coordinadorService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(CoordinadorEntity coordinador) {
        return coordinadorService.actualizar(coordinador);
    }

    @DeleteMapping("/eliminar")
    public boolean eliminar(long id) {
        return coordinadorService.eliminar(id);
    }
}
