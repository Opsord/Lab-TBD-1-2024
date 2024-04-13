package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.AtributoEntity;

import java.util.List;

public interface AtributoRepository {

    public AtributoEntity crearAtributo(AtributoEntity atributo);

    public List<AtributoEntity> obtenerTodosLosAtributos();

    public AtributoEntity obtenerAtributoPorId(long id);

//    public AtributoEntity obtenerPorTipoAtributo(String tipoAtributo);

    public void actualizarAtributo(AtributoEntity atributo);

    public void eliminarAtributo(long id);
}
