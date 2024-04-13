package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface EmergenciaRepository {

    void create(EmergenciaEntity emergencia);

    List<EmergenciaEntity> conseguirTodos();

    EmergenciaEntity conseguirPorId(Integer id);

    List<EmergenciaEntity> conseguirPorEmergenciasActivas();

    void update(EmergenciaEntity emergencia);

    void delete(Integer id);
}
