package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.AtributoEntity;
import G1TBD.LABTBD.services.AtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/atributos")
public class AtributoController {

    @Autowired
    private AtributoService atributoService;

    String homeLinkRedirect = "redirect:/atributos";

    @PostMapping("/crear")
    public String crear(AtributoEntity atributo) {
        atributoService.crear(atributo);
        return homeLinkRedirect;
    }

    @PostMapping("/todo")
    public List<AtributoEntity> obtenerTodos() {
        return atributoService.obtenerTodos();
    }

    @PostMapping("/porId")
    public AtributoEntity obtenerPorId(long id) {
        return atributoService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizar(AtributoEntity atributo) {
        return atributoService.actualizar(atributo);
    }

    @PostMapping("/eliminar")
    public boolean eliminar(long id) {
        return atributoService.eliminar(id);
    }
}
