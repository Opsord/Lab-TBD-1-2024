package G1TBD.LABTBD.services;

import G1TBD.LABTBD.dtos.datosEmergencia;
import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.repositories.EmergenciaRepository;
import G1TBD.LABTBD.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;
    @Autowired
    private TareaService tareaService;

    public EmergenciaEntity crear(EmergenciaEntity emergencia) {
        return emergenciaRepository.crear(emergencia);
    }

    public List<EmergenciaEntity> obtenerTodos() {
        return emergenciaRepository.obtenerTodos();
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



    public List<EmergenciaEntity> emergenciasFinalizadas(){
        return emergenciaRepository.encontrarEmergenciasFinalizadas();
    }


/*
    public List<datosEmergencia> datosEmergencias() {
        List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
        List<Integer> ides = new ArrayList<>();
        for(EmergenciaEntity emergencia : emergenciasFinalizadas){
            ides.add(emergencia.getIdEmergencia());
        }
        return ides;
    }

 */

    public datosEmergencia datosEmergencias() {
        List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
        List<Integer> ides = new ArrayList<>();
        List<TareaEntity> tareas = new ArrayList<>();
        for(EmergenciaEntity emergencia : emergenciasFinalizadas){
            ides.add((int) emergencia.getIdEmergencia());
        }
        int cantidadTareasTotal = 0;
        int cantidadVoluntariosTotal = 0;
        for(Integer id : ides){
            List<TareaEntity> tareasPorEmergencia = tareaService.obtenerTareasPorIdEmergencia(id);
            if(tareasPorEmergencia != null) {
                tareas.addAll(tareasPorEmergencia);
                cantidadTareasTotal += tareasPorEmergencia.size();
                // Supongamos que hay un método para obtener la cantidad de voluntarios para una emergencia
                cantidadVoluntariosTotal += 5;
            }
        }

        datosEmergencia datosEmergenciaa = new datosEmergencia();
        datosEmergenciaa.setTituloEmergencia("a");
        datosEmergenciaa.setCantidadTareas(cantidadTareasTotal);
        datosEmergenciaa.setCantidadVoluntarios(cantidadVoluntariosTotal);
        return datosEmergenciaa;
    }



/*

    public datosEmergencia datosEmergencias() {
        List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
        List<Integer> ides = new ArrayList<>();
        List<TareaEntity> tareas = new ArrayList<>();
        for(EmergenciaEntity emergencia : emergenciasFinalizadas){
            ides.add((int) emergencia.getIdEmergencia());
        }
        int cantidadTareasTotal = 0;
        int cantidadVoluntariosTotal = 0;
        for(Integer id : ides){
            List<TareaEntity> tareasPorEmergencia = tareaService.obtenerTareasPorIdEmergencia(id);
            if(tareasPorEmergencia != null) {
                tareas.addAll(tareasPorEmergencia);
                cantidadTareasTotal += tareasPorEmergencia.size();
                // Supongamos que hay un método para obtener la cantidad de voluntarios para una emergencia
                cantidadVoluntariosTotal += 5;
            }
        }

        datosEmergencia datosEmergenciaa = new datosEmergencia();
        datosEmergenciaa.setTituloEmergencia("a");
        datosEmergenciaa.setCantidadTareas(cantidadTareasTotal);
        datosEmergenciaa.setCantidadVoluntarios(cantidadVoluntariosTotal);
        return datosEmergenciaa;
    }

 */







/*
    public List<EmergenciaEntity> datosEmergencias() {
        return emergenciasFinalizadas();
    }

 */
}
