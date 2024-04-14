package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.AtributoEntity;

import java.util.List;

public interface AtributoRepository {

    AtributoEntity crear(AtributoEntity atributo);

    List<AtributoEntity> obtenerTodos();

    AtributoEntity obtenerPorId(long id);

//    public AtributoEntity obtenerPorTipoAtributo(String tipoAtributo);

    boolean actualizar(AtributoEntity atributo);

    boolean eliminar(long id);
}
