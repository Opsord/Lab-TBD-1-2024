package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VoluntarioEntity;
import G1TBD.LABTBD.services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
@CrossOrigin(origins = "http://localhost:8080/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    String homeLinkRedirect = "redirect:/voluntarios";

    @PostMapping("/crear")
    public String crear(VoluntarioEntity voluntario) {
        voluntarioService.crear(voluntario);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VoluntarioEntity> obtenerTodos() {
        return voluntarioService.obtenerTodos();
    }

    @GetMapping("/porId")
    public VoluntarioEntity obtenerPorId(long id) {
        return voluntarioService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizar(VoluntarioEntity voluntario) {
        return voluntarioService.actualizar(voluntario);
    }

    @PostMapping("/eliminar")
    public boolean eliminar(long id) {
        return voluntarioService.eliminar(id);
    }

}
