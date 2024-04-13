package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;

import java.util.List;

public interface EmergenciaAtributoRepository {

    public void create(EmergenciaAtributoEntity emergenciaAtributo);

    public List<EmergenciaAtributoEntity> conseguirTodos();

    public EmergenciaAtributoEntity obtenerPorId(Long id);

    public void update(EmergenciaAtributoEntity emergenciaAtributo);

    public void delete(EmergenciaAtributoEntity emergenciaAtributo);
}
