package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;
import G1TBD.LABTBD.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class VoluntarioAtributoRepositoryImp implements VoluntarioAtributoRepository{
    @Autowired
    private Sql2o sql2o;

    private long idVoluntarioAtributo;
    private long idVoluntario;
    private long idAtributo;

    // Crear un VoluntarioAtributo
    @Override
    public void create(VoluntarioAtributoEntity voluntarioAtributo) {
        String sql =
                "INSERT INTO VoluntarioAtributo (idVoluntarioAtributo, idVoluntario, idAtributo) " +
                        "VALUES (:idVoluntarioAtributo, :idVoluntario, :idAtributo)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", voluntarioAtributo.getIdVoluntarioAtributo())
                    .addParameter("idVoluntario", voluntarioAtributo.getIdVoluntario())
                    .addParameter("idAtributo", voluntarioAtributo.getIdAtributo())
                    .executeUpdate();
        }
    }

    //Conseguir voluntarioAtributo por su id
    @Override
    public VoluntarioAtributoEntity conseguirPorId(Integer id) {
        String sql = "SELECT * FROM VoluntarioAtributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idvoluntarioatributo", id)
                    .executeAndFetchFirst(VoluntarioAtributoEntity.class);
        }
    }

    // Actualizar datos de un voluntarioAtributo
    @Override
    public void Update(VoluntarioAtributoEntity voluntarioAtributo) {
        String sql =
                "UPDATE VoluntarioAtributo SET idVoluntarioAtributo = :idVoluntarioAtributo, idVoluntario = :idVoluntario, idAtributo = :idAtributo" +
                        "WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", voluntarioAtributo.getIdVoluntarioAtributo())
                    .addParameter("idVoluntario", voluntarioAtributo.getIdVoluntario())
                    .addParameter("idAtributo", voluntarioAtributo.getIdAtributo())
                    .executeUpdate();
        }
    }

    // Eliminar un voluntarioAtributo
    @Override
    public void Delete(Integer id) {
        String sql = "DELETE FROM VoluntarioAtributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", id)
                    .executeUpdate();
        }
    }
}
