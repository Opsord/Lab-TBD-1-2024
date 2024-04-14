package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface InstitucionRepository {

    InstitucionEntity crear(InstitucionEntity institucion);

    List<InstitucionEntity> obtenerTodos();

    InstitucionEntity obtenerPorId(long id);

    boolean actualizar(InstitucionEntity institucion);

    boolean eliminar(long id);
}
