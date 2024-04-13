package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.AtributoEntity;

import java.util.List;

public interface AtributoRepository {

    public void create(AtributoEntity atributo);

    public List<AtributoEntity> conseguirTodos();

    public AtributoEntity conseguirPorId(long id);

    public AtributoEntity conseguirPorAtributo(String atributo);

    public void update(AtributoEntity atributo);

    public void delete(long id);
}
