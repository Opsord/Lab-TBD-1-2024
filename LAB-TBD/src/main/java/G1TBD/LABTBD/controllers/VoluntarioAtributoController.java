package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VolunteerAttributeEntity;
import G1TBD.LABTBD.services.VolunteerAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/voluntarioatributo")
@CrossOrigin(origins = "http://localhost:8090/voluntarioatributos")
public class VoluntarioAtributoController {

    @Autowired
    private VolunteerAttributeService volunteerAttributeService;

    String homeLinkRedirect = "redirect:/voluntarioatributos";

    @PostMapping("/crear")
    public String crear(@RequestBody VolunteerAttributeEntity voluntarioAtributo) {
        volunteerAttributeService.create(voluntarioAtributo);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VolunteerAttributeEntity> obtenerTodos() {
        return volunteerAttributeService.getAll();
    }

    @GetMapping("/porId/{id}")
    public VolunteerAttributeEntity obtenerPorId(@PathVariable long id) {
        return volunteerAttributeService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody VolunteerAttributeEntity voluntarioAtributo) {
        return volunteerAttributeService.update(voluntarioAtributo);
    }

    @DeleteMapping("/eliminar{id}")
    public boolean eliminar(@PathVariable long id) {
        return volunteerAttributeService.delete(id);
    }
}
