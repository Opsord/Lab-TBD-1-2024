package G1TBD.LABTBD.repositories;


import G1TBD.LABTBD.entities.AtributoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class AtributoRepositoryImp {
    @Autowired
    private Sql2o sql2o;
    // Crear un Atributo
    public void create(AtributoEntity atributo) {
        String sql =
                "INSERT INTO atributo (atributo) " +
                        "VALUES (:atributo)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("atributo", atributo.getAtributo())
                    .executeUpdate();
            con.commit();
        }
    }

    // Conseguir todos los Atributos
    public List<AtributoEntity> conseguirTodos() {
        String sql = "SELECT * FROM atributo";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(AtributoEntity.class);
        }
    }

    // Conseguir Atributo por su ID
    public AtributoEntity conseguirPorId(long id) {
        String sql = "SELECT * FROM atributo WHERE idAtributo = :idAtributo";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeAndFetchFirst(AtributoEntity.class);
        }
    }

    public AtributoEntity conseguirPorAtributo(String atributo) {
        String sql = "SELECT * FROM atributo WHERE atributo = :atributo";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("atributo", atributo)
                    .executeAndFetchFirst(AtributoEntity.class);
        }
    }

    // Actualizar un Atributo
    public void update(AtributoEntity atributo) {
        String sql =
                "UPDATE atributo SET atributo = :atributo " +
                        "WHERE idAtributo = :idAtributo";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idAtributo", atributo.getIdAtributo())
                    .addParameter("atributo", atributo.getAtributo())
                    .executeUpdate();
            con.commit();
        }
    }

    // Eliminar un Atributo
    public void delete(Integer id) {
        String sql = "DELETE FROM atributo WHERE idAtributo = :idAtributo";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeUpdate();
            con.commit();
        }
    }
}

