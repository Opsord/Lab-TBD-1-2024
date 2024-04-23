package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.AttributeEntity;
import G1TBD.LABTBD.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atributos")
@CrossOrigin

public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    String homeLinkRedirect = "redirect:/atributos";

    @PostMapping("/crear")
    public String crear(@RequestBody AttributeEntity atributo) {
        attributeService.create(atributo);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<AttributeEntity> obtenerTodos() {
        return attributeService.getAll();
    }

    @GetMapping("/porId/{id}")
    public AttributeEntity obtenerPorId(@PathVariable long id) {
        return attributeService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody AttributeEntity atributo) {
        return attributeService.update(atributo);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return attributeService.delete(id);
    }

}
