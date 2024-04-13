package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;

import java.util.List;

public interface CoordinadorRepository {

    void create(CoordinadorEntity coordinador);

    List<CoordinadorEntity> conseguirTodos();

    CoordinadorEntity conseguirPorId(Integer id);

    void update(CoordinadorEntity coordinador);

    void delete(long id);
}
