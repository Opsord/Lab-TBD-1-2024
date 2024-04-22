package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VoluntarioEntity;
import G1TBD.LABTBD.services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
@CrossOrigin(origins = "http://localhost:8090/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    String homeLinkRedirect = "redirect:/voluntarios";

    @PostMapping("/crear")
    public String crear(@RequestBody VoluntarioEntity voluntario) {
        voluntarioService.crear(voluntario);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VoluntarioEntity> obtenerTodos() {
        return voluntarioService.obtenerTodos();
    }

    @GetMapping("/porRut/{rut}")
    public VoluntarioEntity obtenerPorRut(@PathVariable String rut) {
        return voluntarioService.obtenerPorRut(rut);
    }

    @GetMapping("/porId/{id}")
    public VoluntarioEntity obtenerPorId(@PathVariable long id) {
        return voluntarioService.obtenerPorId(id);
    }


    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody VoluntarioEntity voluntario) {
        return voluntarioService.actualizar(voluntario);
    }

    @DeleteMapping("/eliminar/{rut}")
    public boolean eliminar(@PathVariable String rut) {
        return voluntarioService.eliminar(rut);
    }

}
