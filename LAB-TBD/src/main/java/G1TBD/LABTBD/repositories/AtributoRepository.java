package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.AtributoEntity;

import java.util.List;

public interface AtributoRepository {

    public void crearAtributo(AtributoEntity atributo);

    public List<AtributoEntity> obtenerTodosLosAtributos();

    public AtributoEntity obtenerAtributoPorId(long id);

//    public AtributoEntity conseguirPorAtributo(String atributo);

    public void actualizarAtributo(AtributoEntity atributo);

    public void eliminarAtributo(long id);
}
