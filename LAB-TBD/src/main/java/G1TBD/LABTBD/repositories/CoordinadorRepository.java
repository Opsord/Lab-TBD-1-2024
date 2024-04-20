package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;

import java.util.List;

public interface CoordinadorRepository {

    CoordinadorEntity crear(CoordinadorEntity coordinador);

    List<CoordinadorEntity> obtenerTodos();

    CoordinadorEntity obtenerPorRut(String rut);

    boolean actualizar(CoordinadorEntity coordinador);

    boolean eliminar(String rut);
}
