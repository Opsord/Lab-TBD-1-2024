package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.InstitucionEntity;
import G1TBD.LABTBD.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institucion")
@CrossOrigin
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    String homeLinkRedirect = "redirect:/instituciones";

    @PostMapping("/crear")
    public String crear(@RequestBody InstitucionEntity institucion) {
        institucionService.crear(institucion);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<InstitucionEntity> obtenerTodos() {
        return institucionService.obtenerTodos();
    }

    @GetMapping("/porId/{id}")
    public InstitucionEntity obtenerPorId(@PathVariable long id) {
        return institucionService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody InstitucionEntity institucion) {
        return institucionService.actualizar(institucion);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return institucionService.eliminar(id);
    }
}
