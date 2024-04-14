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

    @PostMapping("/crear")
    public String crearVoluntario(VoluntarioEntity voluntario) {
        voluntarioService.crearVoluntario(voluntario);
        return "redirect:/voluntarios";
    }

    @GetMapping("/todo")
    public List<VoluntarioEntity> obtenerTodosLosVoluntarios() {
        return voluntarioService.obtenerTodosLosVoluntarios();
    }

    @GetMapping("/porId")
    public VoluntarioEntity obtenerVoluntarioPorId(long id) {
        return voluntarioService.obtenerVoluntarioPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizarVoluntario(VoluntarioEntity voluntario) {
        return voluntarioService.actualizarVoluntario(voluntario);
    }

    @PostMapping("/eliminar")
    public boolean eliminarVoluntario(long id) {
        return voluntarioService.eliminarVoluntario(id);
    }

}
