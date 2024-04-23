package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.data.SingleEmergencyData;
import G1TBD.LABTBD.entities.EmergencyEntity;
import G1TBD.LABTBD.services.EmergencyService;
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
    private EmergencyService emergencyService;


    @PostMapping("/crear")
    public ResponseEntity<EmergencyEntity> crear(@RequestBody EmergencyEntity emergencia) {
        EmergencyEntity emergenciaCreada = emergencyService.create(emergencia);
        return new ResponseEntity<>(emergenciaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/todo")
    public List<EmergencyEntity> obtenerTodos() {
        return emergencyService.getAll();
    }

    @GetMapping("/activas")
    public List<EmergencyEntity> obtenerTodasActivas() {
        return emergencyService.getAllActive();
    }

    @GetMapping("/porId/{id}")
    public EmergencyEntity obtenerPorId(@PathVariable long id) {
        return emergencyService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody EmergencyEntity emergencia) {
        return emergencyService.update(emergencia);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return emergencyService.delete(id);
    }

    @GetMapping("/finalizadas")
    public List<EmergencyEntity> obtenerFinalizadas() {
        return emergencyService.getClosedEmergencies();
    }

    @GetMapping("/datosEmergencias")
    public List<SingleEmergencyData> obtenerDatosEmergencias() {
        return emergencyService.allEmergencyData();
    }

}
