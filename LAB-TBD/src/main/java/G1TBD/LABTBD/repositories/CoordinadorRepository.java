package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;

import java.util.List;

public interface CoordinadorRepository {

    CoordinadorEntity crearCoordinador(CoordinadorEntity coordinador);

    List<CoordinadorEntity> obtenerTodosLosCoordinadores();

    CoordinadorEntity obtenerCoordinadorPorId(long id);

    boolean actualizarCoordinador(CoordinadorEntity coordinador);

    boolean eliminarCoordinador(long id);
}
