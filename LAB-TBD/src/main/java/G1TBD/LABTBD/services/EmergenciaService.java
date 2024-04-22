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


    /*
     * public List<datosEmergencia> datosEmergencias() {
     * List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
     * List<Integer> ides = new ArrayList<>();
     * for(EmergenciaEntity emergencia : emergenciasFinalizadas){
     * ides.add(emergencia.getIdEmergencia());
     * }
     * return ides;
     * }
     * 
     */

//    public List<datosEmergencia> datosEmergencias() {
//        List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
//        List<UUID> ides = new ArrayList<>();
//        List<datosEmergencia> datosEmergencias = new ArrayList<>();
//        for (EmergenciaEntity emergencia : emergenciasFinalizadas) {
//            ides.add(emergencia.getIdEmergencia());
//        }
//        for (UUID id : ides) {
//            List<TareaEntity> tareasPorEmergencia = tareaService.obtenerTareasPorIdEmergencia(id);
//            datosEmergencia datosEmergenciaa = new datosEmergencia("a", tareasPorEmergencia.size(), 5);
//            datosEmergencias.add(datosEmergenciaa);
//        }
//        return datosEmergencias;
//    }

    /*
     * 
     * public datosEmergencia datosEmergencias() {
     * List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
     * List<Integer> ides = new ArrayList<>();
     * List<TareaEntity> tareas = new ArrayList<>();
     * for(EmergenciaEntity emergencia : emergenciasFinalizadas){
     * ides.add((int) emergencia.getIdEmergencia());
     * }
     * int cantidadTareasTotal = 0;
     * int cantidadVoluntariosTotal = 0;
     * for(Integer id : ides){
     * List<TareaEntity> tareasPorEmergencia =
     * tareaService.obtenerTareasPorIdEmergencia(id);
     * if(tareasPorEmergencia != null) {
     * tareas.addAll(tareasPorEmergencia);
     * cantidadTareasTotal += tareasPorEmergencia.size();
     * // Supongamos que hay un método para obtener la cantidad de voluntarios para
     * una emergencia
     * cantidadVoluntariosTotal += 5;
     * }
     * }
     * 
     * datosEmergencia datosEmergenciaa = new datosEmergencia();
     * datosEmergenciaa.setTituloEmergencia("a");
     * datosEmergenciaa.setCantidadTareas(cantidadTareasTotal);
     * datosEmergenciaa.setCantidadVoluntarios(cantidadVoluntariosTotal);
     * return datosEmergenciaa;
     * }
     * 
     */

    /*
     * public List<EmergenciaEntity> datosEmergencias() {
     * return emergenciasFinalizadas();
     * }
     * 
     */


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
/*
     public List<datosEmergencia> datosEmergencias() {
            List<EmergenciaEntity> emergenciasFinalizadas = emergenciasFinalizadas();
            List<Integer> ides = new ArrayList<>();
            List<datosEmergencia> datosEmergencias = new ArrayList<>();
            for (EmergenciaEntity emergencia : emergenciasFinalizadas) {
                ides.add((int) emergencia.getIdEmergencia());
            }
            for (Integer id : ides) {
                List<TareaEntity> tareasPorEmergencia = tareaService.obtenerPorIdEmergencia(id);
                List<VoluntarioEntity> voluntariosPorEmergencia = voluntarioService.obtenerPorIdEmergencia(id);
                datosEmergencia datosEmergenciaa = new datosEmergencia("a", voluntariosPorEmergencia.size(),tareasPorEmergencia.size());
                datosEmergencias.add(datosEmergenciaa);
            }
            return datosEmergencias;
    }

 */

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
