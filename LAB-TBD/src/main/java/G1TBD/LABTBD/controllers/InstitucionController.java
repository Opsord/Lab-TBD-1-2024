package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.InstitucionEntity;
import G1TBD.LABTBD.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/instituciones")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    String homeLinkRedirect = "redirect:/instituciones";

    @PostMapping("/crear")
    public String crear(InstitucionEntity institucion) {
        institucionService.crear(institucion);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<InstitucionEntity> obtenerTodos() {
        return institucionService.obtenerTodos();
    }

    @GetMapping("/porId")
    public InstitucionEntity obtenerPorId(long id) {
        return institucionService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizar(InstitucionEntity institucion) {
        return institucionService.actualizar(institucion);
    }

    @PostMapping("/eliminar")
    public boolean eliminar(long id) {
        return institucionService.eliminar(id);
    }
}
