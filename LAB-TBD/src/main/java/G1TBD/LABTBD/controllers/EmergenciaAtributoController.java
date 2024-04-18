package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import G1TBD.LABTBD.services.EmergenciaAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emergenciaAtributo")
@CrossOrigin(origins = "http://localhost:8080/emergenciaAtributo")
public class EmergenciaAtributoController {

    @Autowired
    private EmergenciaAtributoService emergenciaAtributoService;

    String homeLinkRedirect = "redirect:/emergenciaAtributo";

    @PostMapping("/crear")
    public String crear(EmergenciaAtributoEntity emergenciaAtributo) {
        emergenciaAtributoService.crear(emergenciaAtributo);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<EmergenciaAtributoEntity> obtenerTodos(){
        return emergenciaAtributoService.obtenerTodos();
    }

    @GetMapping("/porId")
    public EmergenciaAtributoEntity obtenerPorId(long id){
        return emergenciaAtributoService.obtenerPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizar(EmergenciaAtributoEntity emergenciaAtributo){
        return emergenciaAtributoService.actualizar(emergenciaAtributo);
    }

    @PostMapping("/eliminar")
    public boolean eliminar(long id){
        return emergenciaAtributoService.eliminar(id);
    }

}
