package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.CoordinatorEntity;
import G1TBD.LABTBD.services.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/coordinadores")
@CrossOrigin(origins = "http://localhost:8090/coordinadores")
public class CoordinadorController {

    private static final Logger logger = Logger.getLogger(CoordinadorController.class.getName());

    @Autowired
    private CoordinatorService coordinatorService;

    String homeLinkRedirect = "redirect:/coordinadores";

    @PostMapping("/crear")
    public String crear(@RequestBody CoordinatorEntity coordinador) {
        logger.info("Creando coordinador: " + coordinador.toString());
        coordinatorService.create(coordinador);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<CoordinatorEntity> obtenerTodos() {
        return coordinatorService.getAll();
    }

    @GetMapping("/porRut/{rut}")
    public CoordinatorEntity obtenerPorRut(@PathVariable String rut) {
        return coordinatorService.getByRut(rut);
    }

    @GetMapping("/porEmail/{email}")
    public CoordinatorEntity obtenerPorEmail(@PathVariable String email) {
        return coordinatorService.getByEmail(email);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody CoordinatorEntity coordinador) {
        return coordinatorService.update(coordinador);
    }

    @DeleteMapping("/eliminar/{rut}")
    public boolean eliminar(@PathVariable String rut) {
        return coordinatorService.delete(rut);
    }
}
