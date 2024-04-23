package G1TBD.LABTBD.services;

import G1TBD.LABTBD.dtos.datosEmergencia;
import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.entities.VoluntarioEntity;
import G1TBD.LABTBD.repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;
    @Autowired
    private TareaService tareaService;
    @Autowired
    private VoluntarioService voluntarioService;

    public EmergenciaEntity crear(EmergenciaEntity emergencia) {
        return emergenciaRepository.crear(emergencia);
    }

    public List<EmergenciaEntity> obtenerTodos() {
        return emergenciaRepository.obtenerTodos();
    }

    public List<EmergenciaEntity> obtenerTodasActivas() {
        return emergenciaRepository.obtenerTodasActivas();
    }

    public EmergenciaEntity obtenerPorId(long id) {
        return emergenciaRepository.obtenerPorId(id);
    }

    public boolean actualizar(EmergenciaEntity emergencia) {
        return emergenciaRepository.actualizar(emergencia);
    }

    public boolean eliminar(long id) {
        return emergenciaRepository.eliminar(id);
    }

    public List<EmergenciaEntity> emergenciasFinalizadas() {
        return emergenciaRepository.encontrarEmergenciasFinalizadas();
    }

    //Funcionalidad SQL 48
    public List<datosEmergencia> datosEmergencias() {
        List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
        List<datosEmergencia> datosEmergencias = new ArrayList<>();

        for (EmergenciaEntity emergencia : emergenciasFinalizadas) {
            long idEmergencia = emergencia.getIdEmergencia();
            List<TareaEntity> cantidadTareas = tareaService.obtenerPorIdEmergencia(idEmergencia);
            List<VoluntarioEntity> cantidadVoluntarios = voluntarioService.obtenerPorIdEmergencia(idEmergencia);

            datosEmergencia datosEmergencia = new datosEmergencia(emergencia.getTituloEmergencia(), cantidadVoluntarios.size(), cantidadTareas.size());
            datosEmergencias.add(datosEmergencia);
        }

        return datosEmergencias;
    }
}
