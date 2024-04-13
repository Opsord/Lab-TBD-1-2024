package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;

import java.util.List;

public interface EmergenciaAtributoRepository {

    public void crearEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo);

    public List<EmergenciaAtributoEntity> obtenerTodosLosEmergenciaAtributo();

    public EmergenciaAtributoEntity obtenerEmergenciaAtributoPorId(long id);

    public void actualizarEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo);

    public void eliminarEmergenciaAtributo(long id);
}
