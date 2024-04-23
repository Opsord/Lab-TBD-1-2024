package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VolunteerEntity;
import G1TBD.LABTBD.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
@CrossOrigin(origins = "http://localhost:8090/voluntarios")
public class VoluntarioController {

    @Autowired
    private VolunteerService volunteerService;

    String homeLinkRedirect = "redirect:/voluntarios";

    @PostMapping("/crear")
    public String crear(@RequestBody VolunteerEntity voluntario) {
        volunteerService.create(voluntario);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VolunteerEntity> obtenerTodos() {
        return volunteerService.getAll();
    }

    @GetMapping("/porRut/{rut}")
    public VolunteerEntity obtenerPorRut(@PathVariable String rut) {
        return volunteerService.getByRut(rut);
    }

    @GetMapping("/porEmail/{email}")
    public VolunteerEntity obtenerPorEmail(@PathVariable String email) {
        return volunteerService.getByEmail(email);
    }

    @GetMapping("/porId/{id}")
    public VolunteerEntity obtenerPorId(@PathVariable long id) {
        return volunteerService.getById(id);
    }


    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody VolunteerEntity voluntario) {
        return volunteerService.update(voluntario);
    }

    @DeleteMapping("/eliminar/{rut}")
    public boolean eliminar(@PathVariable String rut) {
        return volunteerService.delete(rut);
    }

}
