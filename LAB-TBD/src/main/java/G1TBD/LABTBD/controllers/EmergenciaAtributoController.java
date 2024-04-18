package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.services.EmergenciaAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergenciaAtributo")
@CrossOrigin(origins = "http://localhost:8090/emergenciaAtributo")
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

    @GetMapping("/porId/{id}")
    public EmergenciaAtributoEntity obtenerPorId(@PathVariable long id){
        return emergenciaAtributoService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody EmergenciaAtributoEntity emergenciaAtributo){
        return emergenciaAtributoService.actualizar(emergenciaAtributo);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id){
        return emergenciaAtributoService.eliminar(id);
    }

    /*
    @GetMapping("/emergencia/completa")
    public List<EmergenciaEntity> getAllEmergenciasCompletadas(){
        return emergenciaAtributoService.findAllCompletedEmergency();
    }

     */

}
