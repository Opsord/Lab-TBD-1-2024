package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitucionEntity;

import java.util.List;

public interface InstitucionRepository {



    //Crear intitucion
    void create(InstitucionEntity institucion);

    //Leer instituciones
    public List<InstitucionEntity> conseguirTodo(InstitucionEntity institucion);


    //Actualizar institucion
    void update(InstitucionEntity institucion);

    //Eliminar intitucion
    void delete(Integer id);
}
