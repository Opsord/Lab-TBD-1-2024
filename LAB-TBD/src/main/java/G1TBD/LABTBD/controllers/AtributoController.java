package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.AtributoEntity;
import G1TBD.LABTBD.services.AtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/atributos")
@CrossOrigin(origins = "http://localhost:8090/atributos")
    
    
public class AtributoController {

    @Autowired
    private AtributoService atributoService;

    String homeLinkRedirect = "redirect:/atributos";

    @PostMapping("/crear")
    public String crear(@RequestBody AtributoEntity atributo) {
        atributoService.crear(atributo);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<AtributoEntity> obtenerTodos() {
        return atributoService.obtenerTodos();
    }

    @GetMapping("/porId/{id}")
    public AtributoEntity obtenerPorId(@PathVariable long id) {
        return atributoService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody AtributoEntity atributo) {
        return atributoService.actualizar(atributo);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return atributoService.eliminar(id);
    }

}
