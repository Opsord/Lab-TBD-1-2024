package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import G1TBD.LABTBD.services.CoordinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/coordinadores")
@CrossOrigin(origins = "http://localhost:8090/coordinadores")
public class CoordinadorController {

    private static final Logger logger = Logger.getLogger(CoordinadorController.class.getName());

    @Autowired
    private CoordinadorService coordinadorService;

    String homeLinkRedirect = "redirect:/coordinadores";

    @PostMapping("/crear")
    public String crear(@RequestBody CoordinadorEntity coordinador) {
        logger.info("Creando coordinador: " + coordinador.toString());
        coordinadorService.crear(coordinador);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<CoordinadorEntity> obtenerTodos() {
        return coordinadorService.obtenerTodos();
    }

    @GetMapping("/porRut/{rut}")
    public CoordinadorEntity obtenerPorRut(@PathVariable String rut) {
        return coordinadorService.obtenerPorRut(rut);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody CoordinadorEntity coordinador) {
        return coordinadorService.actualizar(coordinador);
    }

    @DeleteMapping("/eliminar/{rut}")
    public boolean eliminar(@PathVariable String rut) {
        return coordinadorService.eliminar(rut);
    }
}
