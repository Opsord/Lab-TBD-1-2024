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

    @PostMapping("/crear")
    public String crearCoordinador(CoordinadorEntity coordinador) {
        coordinadorService.crearCoordinador(coordinador);
        return "redirect:/coordinadores";
    }

    @GetMapping("/todo")
    public List<CoordinadorEntity> obtenerTodosLosCoordinadores() {
        return coordinadorService.obtenerTodosLosCoordinadores();
    }

    @GetMapping("/porId")
    public CoordinadorEntity obtenerCoordinadorPorId(long id) {
        return coordinadorService.obtenerCoordinadorPorId(id);
    }

    @PostMapping("/actualizar")
    public String actualizarCoordinador(CoordinadorEntity coordinador) {
        coordinadorService.actualizarCoordinador(coordinador);
        return "redirect:/coordinadores";
    }

    @PostMapping("/eliminar")
    public String eliminarCoordinador(long id) {
        coordinadorService.eliminarCoordinador(id);
        return "redirect:/coordinadores";
    }
}
