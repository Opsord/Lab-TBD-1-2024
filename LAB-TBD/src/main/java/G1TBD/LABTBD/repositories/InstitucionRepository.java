package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface InstitucionRepository {

    void create(InstitucionEntity institucion);

    public List<InstitucionEntity> conseguirTodos(InstitucionEntity institucion);

    void update(InstitucionEntity institucion);

    void delete(Integer id);
}
