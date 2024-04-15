package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VoluntarioEntity;
import G1TBD.LABTBD.services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    String homeLinkRedirect = "redirect:/voluntarios";

    @PostMapping("/crear")
    public String crearVoluntario(VoluntarioEntity voluntario) {
        voluntarioService.crear(voluntario);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VoluntarioEntity> obtenerTodosLosVoluntarios() {
        return voluntarioService.obtenerTodos();
    }

    @GetMapping("/porId")
    public VoluntarioEntity obtenerVoluntarioPorId(long id) {
        return voluntarioService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizarVoluntario(VoluntarioEntity voluntario) {
        return voluntarioService.actualizar(voluntario);
    }

    @PostMapping("/eliminar")
    public boolean eliminarVoluntario(long id) {
        return voluntarioService.eliminar(id);
    }

}
