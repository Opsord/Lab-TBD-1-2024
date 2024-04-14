package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;
import G1TBD.LABTBD.entities.VoluntarioEntity;
import G1TBD.LABTBD.services.VoluntarioAtributoService;
import G1TBD.LABTBD.services.VoluntarioService;
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

    @PostMapping("/crear")
    public String crearVoluntarioAtributos( VoluntarioAtributoEntity voluntarioAtributo) {
        voluntarioAtributoService.crearVoluntarioAtributo(voluntarioAtributo);
        return "redirect:/voluntarioatributos";
    }

    @GetMapping("/todo")
    public List<VoluntarioAtributoEntity> obtenerTodosLosVoluntarioAtributos() {
        return voluntarioAtributoService.obtenerTodosLosVoluntarioAtributo();
    }

    @GetMapping("/porId")
    public VoluntarioAtributoEntity obtenerVoluntarioAtributoPorId(long id) {
        return voluntarioAtributoService.obtenerVoluntarioAtributoPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizarVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo) {
        return voluntarioAtributoService.actualizarVoluntarioAtributo(voluntarioAtributo);
    }

    @PostMapping("/eliminar")
    public boolean eliminarVoluntarioAtributo(long id) {
        return voluntarioAtributoService.eliminarVoluntarioAtributo(id);
    }
}
