package G1TBD.LABTBD.repositories;


import G1TBD.LABTBD.entities.InstitucionEntity;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class InstitucionRepositoryImp implements InstitucionRepository {

    private Sql2o sql2o;

    public InstitucionRepositoryImp(Sql2o sql2o){this.sql2o = sql2o;}

    @Override
    public void create(InstitucionEntity institucion) {
        String sql =
                "INSERT INTO Intitucion (nombreInstitucion)" +
                        "VALUES (:nombreInstitucion)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("nombreInstitucion", institucion.getNombreInstitucion())
                    .executeUpdate();
        }

    }

    @Override
    public List<InstitucionEntity> conseguirTodo(InstitucionEntity institucion) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Institucion ORDER BY idInstitucion ASC")
                    .executeAndFetch(InstitucionEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void update(InstitucionEntity institucion) {
        String sql =
                "UPDATE Institucion SET nombreInstitucion = :nombreInstitucion" +
                        "WHERE idInstitucion = :idInstitucion";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idInstitucion", institucion.getIdInstitucion())
                    .addParameter("nombreInstitucion", institucion.getNombreInstitucion())
                    .executeUpdate();
        }
    }

    @Override
    public void delete(Integer id){
        String sql = "DELETE FROM Institucion WHERE idInstitucion = :idInstitucion";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idInstitucion", id)
                    .executeUpdate();
        }


    }




}
