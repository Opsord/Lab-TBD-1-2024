package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.InstitutionEntity;
import G1TBD.LABTBD.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institucion")
@CrossOrigin
public class InstitucionController {

    @Autowired
    private InstitutionService institutionService;

    String homeLinkRedirect = "redirect:/instituciones";

    @PostMapping("/crear")
    public String crear(@RequestBody InstitutionEntity institucion) {
        institutionService.create(institucion);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<InstitutionEntity> obtenerTodos() {
        return institutionService.getAll();
    }

    @GetMapping("/porId/{id}")
    public InstitutionEntity obtenerPorId(@PathVariable long id) {
        return institutionService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody InstitutionEntity institucion) {
        return institutionService.update(institucion);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return institutionService.delete(id);
    }
}
