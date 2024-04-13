package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;

import java.util.List;

public interface CoordinadorRepository {

    void crearCoordinador(CoordinadorEntity coordinador);

    List<CoordinadorEntity> obtenerTodosLosCoordinadores();

    CoordinadorEntity obtenerCoordinadorPorId(long id);

    void actualizarCoordinador(CoordinadorEntity coordinador);

    void eliminarCoordinador(long id);
}
