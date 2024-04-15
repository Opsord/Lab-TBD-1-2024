package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import G1TBD.LABTBD.services.CoordinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/coordinadores")
public class CoordinadorController {

    @Autowired
    private CoordinadorService coordinadorService;

    String homeLinkRedirect = "redirect:/coordinadores";

    @PostMapping("/crear")
    public String crearCoordinador(CoordinadorEntity coordinador) {
        coordinadorService.crear(coordinador);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<CoordinadorEntity> obtenerTodosLosCoordinadores() {
        return coordinadorService.obtenerTodos();
    }

    @GetMapping("/porId")
    public CoordinadorEntity obtenerCoordinadorPorId(long id) {
        return coordinadorService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizarCoordinador(CoordinadorEntity coordinador) {
        return coordinadorService.actualizar(coordinador);
    }

    @PostMapping("/eliminar")
    public boolean eliminarCoordinador(long id) {
        return coordinadorService.eliminar(id);
    }
}
