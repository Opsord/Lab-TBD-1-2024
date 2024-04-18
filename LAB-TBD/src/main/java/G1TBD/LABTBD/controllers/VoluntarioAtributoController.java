package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;
import G1TBD.LABTBD.services.VoluntarioAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/voluntarioatributo")
@CrossOrigin(origins = "http://localhost:8090/voluntarioatributos")
public class VoluntarioAtributoController {

    @Autowired
    private VoluntarioAtributoService voluntarioAtributoService;

    String homeLinkRedirect = "redirect:/voluntarioatributos";

    @PostMapping("/crear")
    public String crear(VoluntarioAtributoEntity voluntarioAtributo) {
        voluntarioAtributoService.crear(voluntarioAtributo);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VoluntarioAtributoEntity> obtenerTodos() {
        return voluntarioAtributoService.obtenerTodos();
    }

    @GetMapping("/porId/{id}")
    public VoluntarioAtributoEntity obtenerPorId(@PathVariable long id) {
        return voluntarioAtributoService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody VoluntarioAtributoEntity voluntarioAtributo) {
        return voluntarioAtributoService.actualizar(voluntarioAtributo);
    }

    @DeleteMapping("/eliminar{id}")
    public boolean eliminar(@PathVariable long id) {
        return voluntarioAtributoService.eliminar(id);
    }
}
