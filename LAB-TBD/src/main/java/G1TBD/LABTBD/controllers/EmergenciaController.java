package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.dtos.datosEmergencia;
import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencias")
@CrossOrigin(origins = "http://localhost:8090/emergencias")
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    String homeLinkRedirect = "redirect:/emergencias";

    @PostMapping("/crear")
    public ResponseEntity<EmergenciaEntity> crear(@RequestBody EmergenciaEntity emergencia) {
        EmergenciaEntity emergenciaCreada = emergenciaService.crear(emergencia);
        return new ResponseEntity<>(emergenciaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/todo")
    public List<EmergenciaEntity> obtenerTodos() {
        return emergenciaService.obtenerTodos();
    }

    @GetMapping("/porId/{id}")
    public EmergenciaEntity obtenerPorId(@PathVariable long id) {
        return emergenciaService.obtenerPorId(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody EmergenciaEntity emergencia) {
        return emergenciaService.actualizar(emergencia);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return emergenciaService.eliminar(id);
    }

    @GetMapping("/finalizadas")
    public List<EmergenciaEntity> obtenerFinalizadas() {
        return emergenciaService.emergenciasFinalizadas();
    }

    @GetMapping("/datosEmergencias")
    public List<datosEmergencia> obtenerDatosEmergencias() {
        return emergenciaService.datosEmergencias();
    }

}
