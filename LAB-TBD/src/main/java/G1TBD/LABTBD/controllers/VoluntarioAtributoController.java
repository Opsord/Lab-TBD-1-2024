package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;
import G1TBD.LABTBD.services.VoluntarioAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:8080/voluntarioatributos")
public class VoluntarioAtributoController {

    @Autowired
    private VoluntarioAtributoService voluntarioAtributoService;

    String homeLinkRedirect = "redirect:/voluntarioatributos";

    @PostMapping("/crear")
    public String crearVoluntarioAtributos( VoluntarioAtributoEntity voluntarioAtributo) {
        voluntarioAtributoService.crear(voluntarioAtributo);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VoluntarioAtributoEntity> obtenerTodosLosVoluntarioAtributos() {
        return voluntarioAtributoService.obtenerTodos();
    }

    @GetMapping("/porId")
    public VoluntarioAtributoEntity obtenerVoluntarioAtributoPorId(long id) {
        return voluntarioAtributoService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizarVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo) {
        return voluntarioAtributoService.actualizar(voluntarioAtributo);
    }

    @PostMapping("/eliminar")
    public boolean eliminarVoluntarioAtributo(long id) {
        return voluntarioAtributoService.eliminar(id);
    }
}
