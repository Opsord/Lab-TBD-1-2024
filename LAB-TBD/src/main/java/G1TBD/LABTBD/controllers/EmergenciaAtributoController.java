package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import G1TBD.LABTBD.entities.InstitucionEntity;
import G1TBD.LABTBD.repositories.EmergenciaAtributoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/emergenciaAtributo")
public class EmergenciaAtributoController {
    @Autowired
    private EmergenciaAtributoRepository emergenciaAtributoRepository;
    @PostMapping("/crear")
    public String crearInstitucion(EmergenciaAtributoEntity emergenciaAtributo) {
        emergenciaAtributoRepository.crear(emergenciaAtributo);
        return "redirect:/emergenciaAtributo";
    }
    @GetMapping("/todo")
    public List<EmergenciaAtributoEntity> obtenerTodasEmergenciaAtributo(){
        return emergenciaAtributoRepository.obtenerTodos();

    }
    @GetMapping("/porId")
    public EmergenciaAtributoEntity obtenerEmergenciaAtributoPorId(long id){
        return emergenciaAtributoRepository.obtenerEmergenciaAtributoPorId(id);
    }

    @PostMapping("/actualizar")
    public boolean actualizarEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo){
        return emergenciaAtributoRepository.actualizarEmergenciaAtributo(emergenciaAtributo);

    }
    @PostMapping("/eliminar")
    public boolean eliminarEmergenciaAtributo(long id){
        return emergenciaAtributoRepository.eliminarEmergenciaAtributo(id);
    }




}
