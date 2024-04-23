package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.services.EmergencyAttributeService;
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
    private EmergencyAttributeService emergencyAttributeService;

    String homeLinkRedirect = "redirect:/emergenciaAtributo";

    @PostMapping("/crear")
    public String crear(@RequestBody EmergencyAttributeEntity emergenciaAtributo) {
        emergencyAttributeService.create(emergenciaAtributo);
        return homeLinkRedirect;
    }

    @PostMapping("/crearVarios")
    public ResponseEntity<List<EmergencyAttributeEntity>> crearVarios(@RequestBody List<EmergencyAttributeEntity> emergenciasAtributo) {
        List<EmergencyAttributeEntity> creadas = emergencyAttributeService.createVarious(emergenciasAtributo);
        if (creadas != null && !creadas.isEmpty()) {
            return new ResponseEntity<>(creadas, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todo")
    public List<EmergencyAttributeEntity> obtenerTodos() {
        return emergencyAttributeService.getAll();
    }

    @GetMapping("/porId/{id}")
    public EmergencyAttributeEntity obtenerPorId(@PathVariable long id) {
        return emergencyAttributeService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody EmergencyAttributeEntity emergenciaAtributo) {
        return emergencyAttributeService.update(emergenciaAtributo);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable long id) {
        return emergencyAttributeService.delete(id);
    }

    /*
     * @GetMapping("/emergencia/completa")
     * public List<EmergencyEntity> getAllEmergenciasCompletadas(){
     * return emergenciaAtributoService.findAllCompletedEmergency();
     * }
     * 
     */

}
