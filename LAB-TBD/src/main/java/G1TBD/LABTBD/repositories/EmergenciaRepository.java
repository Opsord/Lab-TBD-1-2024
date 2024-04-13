package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface EmergenciaRepository {

    //Crear emergecia
    void create(EmergenciaEntity emergencia);

    //Conseguir todas las emergencias
    //Conseguir emergencia por id
    //Conseguir emergencias activas

    //Actualizar emergencia
    void update(EmergenciaEntity emergencia);

    //Eliminar emergencia
    void delete(Integer id);
}
