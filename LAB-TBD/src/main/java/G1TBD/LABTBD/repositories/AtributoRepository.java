package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.AtributoEntity;

import java.util.List;

public interface AtributoRepository {

    AtributoEntity crearAtributo(AtributoEntity atributo);

    List<AtributoEntity> obtenerTodosLosAtributos();

    AtributoEntity obtenerAtributoPorId(long id);

//    public AtributoEntity obtenerPorTipoAtributo(String tipoAtributo);

    boolean actualizarAtributo(AtributoEntity atributo);

    boolean eliminarAtributo(long id);
}
