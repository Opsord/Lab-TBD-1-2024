package G1TBD.LABTBD.repositories;


import G1TBD.LABTBD.entities.AtributoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class AtributoRepositoryImp implements AtributoRepository{

    @Autowired
    private Sql2o sql2o;

    // Crear un Atributo
    @Override
    public void crearAtributo(AtributoEntity atributo) {
        String sql =
                "INSERT INTO atributo (atributo) " +
                        "VALUES (:atributo)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("atributo", atributo.getTipoAtributo())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public List<AtributoEntity> obtenerTodosLosAtributos() {
        String sql = "SELECT * FROM atributo";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(AtributoEntity.class);
        }
    }

    @Override
    public AtributoEntity obtenerAtributoPorId(long id) {
        String sql = "SELECT * FROM atributo WHERE idAtributo = :idAtributo";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeAndFetchFirst(AtributoEntity.class);
        }
    }

//    @Override
//    public AtributoEntity obtenerPorTipoAtributo(String tipoAtributo) {
//        String sql = "SELECT * FROM atributo WHERE atributo = :atributo";
//
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql)
//                    .addParameter("atributo", atributo)
//                    .executeAndFetchFirst(AtributoEntity.class);
//        }
//    }

    @Override
    public void actualizarAtributo(AtributoEntity atributo) {
        String sql =
                "UPDATE atributo SET atributo = :atributo " +
                        "WHERE idAtributo = :idAtributo";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idAtributo", atributo.getIdAtributo())
                    .addParameter("atributo", atributo.getTipoAtributo())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void eliminarAtributo(long id) {
        String sql = "DELETE FROM atributo WHERE idAtributo = :idAtributo";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeUpdate();
            con.commit();
        }
    }
}

