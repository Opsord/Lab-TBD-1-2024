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

    @PostMapping("/crear")
    public String crearInstitucion(InstitucionEntity institucion) {
        institucionService.crearInstitucion(institucion);
        return "redirect:/instituciones";
    }

    @GetMapping("/todo")
    public List<InstitucionEntity> obtenerTodasLasInstituciones() {
        return institucionService.obtenerTodasLasInstituciones();
    }

    @GetMapping("/porId")
    public InstitucionEntity obtenerInstitucionPorId(long id) {
        return institucionService.obtenerInstitucionPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizarInstitucion(InstitucionEntity institucion) {
        return institucionService.actualizarInstitucion(institucion);
    }

    @PostMapping("/eliminar")
    public boolean eliminarInstitucion(long id) {
        return institucionService.eliminarInstitucion(id);
    }
}
