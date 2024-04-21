package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import G1TBD.LABTBD.services.EmergenciaAtributoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergenciaAtributo")
@CrossOrigin
public class EmergenciaAtributoController {

    @Autowired
    private EmergenciaAtributoService emergenciaAtributoService;

    String homeLinkRedirect = "redirect:/emergenciaAtributo";

    @PostMapping("/crear")
    public String crear(@RequestBody EmergenciaAtributoEntity emergenciaAtributo) {
        emergenciaAtributoService.crear(emergenciaAtributo);
        return homeLinkRedirect;
    }

    @PostMapping("/crearVarios")
    public ResponseEntity<List<EmergenciaAtributoEntity>> crearVarios(@RequestBody List<EmergenciaAtributoEntity> emergenciasAtributo) {
        List<EmergenciaAtributoEntity> creadas = emergenciaAtributoService.crearVarios(emergenciasAtributo);
        if (creadas != null && !creadas.isEmpty()) {
            return new ResponseEntity<>(creadas, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todo")
    public List<EmergenciaAtributoEntity> obtenerTodos() {
        return emergenciaAtributoService.obtenerTodos();
    }

    @GetMapping("/porId/{id}")
    public EmergenciaAtributoEntity obtenerPorId(@PathVariable long id) {
        return emergenciaAtributoService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody EmergenciaAtributoEntity emergenciaAtributo) {
        return emergenciaAtributoService.actualizar(emergenciaAtributo);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return emergenciaAtributoService.eliminar(id);
    }

    /*
     * @GetMapping("/emergencia/completa")
     * public List<EmergenciaEntity> getAllEmergenciasCompletadas(){
     * return emergenciaAtributoService.findAllCompletedEmergency();
     * }
     * 
     */

}
