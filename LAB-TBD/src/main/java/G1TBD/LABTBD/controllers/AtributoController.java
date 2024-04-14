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

    @PostMapping("/crear")
    public String crearAtributo(AtributoEntity atributo) {
        atributoService.crearAtributo(atributo);
        return "redirect:/atributos";
    }

    @PostMapping("/todo")
    public List<AtributoEntity> obtenerTodosLosAtributos() {
        return atributoService.obtenerTodosLosAtributos();
    }

    @PostMapping("/porId")
    public AtributoEntity obtenerAtributoPorId(long id) {
        return atributoService.obtenerAtributoPorId(id);
    }

    @PostMapping("/actualizar")
    public String  actualizarAtributo(AtributoEntity atributo) {
        atributoService.actualizarAtributo(atributo);
        return "redirect:/atributos";
    }

    @PostMapping("/eliminar")
    public String eliminarAtributo(long id) {
        atributoService.eliminarAtributo(id);
        return "redirect:/atributos";
    }
}
