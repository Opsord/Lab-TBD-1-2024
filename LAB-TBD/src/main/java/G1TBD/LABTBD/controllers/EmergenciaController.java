package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/emergencias")
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @PostMapping("/crear")
    public String crearEmergencia(EmergenciaEntity emergencia) {
        emergenciaService.crearEmergencia(emergencia);
        return "redirect:/emergencias";
    }

    @PostMapping("/todo")
    public List<EmergenciaEntity> obtenerTodasLasEmergencias() {
        return emergenciaService.obtenerTodasLasEmergencias();
    }

    @PostMapping("/porId")
    public EmergenciaEntity obtenerEmergenciaPorId(long id) {
        return emergenciaService.obtenerEmergenciaPorId(id);
    }

    @PostMapping("/actualizar")
    public String actualizarEmergencia(EmergenciaEntity emergencia) {
        emergenciaService.actualizarEmergencia(emergencia);
        return "redirect:/emergencias";
    }

    @PostMapping("/eliminar")
    public String eliminarEmergencia(long id) {
        emergenciaService.eliminarEmergencia(id);
        return "redirect:/emergencias";
    }
}
