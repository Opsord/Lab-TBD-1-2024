package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;
import G1TBD.LABTBD.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioAtributoRepositoryImp implements VoluntarioAtributoRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioAtributoEntity crearVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo) {
        String sql = "INSERT INTO VoluntarioAtributo (idVoluntarioAtributo, idVoluntario, idAtributo) " +
                "VALUES (:idVoluntarioAtributo, :idVoluntario, :idAtributo)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", voluntarioAtributo.getIdVoluntarioAtributo())
                    .addParameter("idVoluntario", voluntarioAtributo.getIdVoluntario())
                    .addParameter("idAtributo", voluntarioAtributo.getIdAtributo())
                    .executeUpdate()
                    .getKey();
            voluntarioAtributo.setIdVoluntarioAtributo(id);
            return voluntarioAtributo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioAtributoEntity> obtenerTodosLosVoluntarioAtributo() {
        String sql = "SELECT * FROM VoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(VoluntarioAtributoEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioAtributoEntity obtenerVoluntarioAtributoPorId(long id) {
        String sql = "SELECT * FROM VoluntarioAtributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idvoluntarioatributo", id)
                    .executeAndFetchFirst(VoluntarioAtributoEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizarVoluntarioAtributo(VoluntarioAtributoEntity voluntarioAtributo) {
        String sql = "UPDATE VoluntarioAtributo SET idVoluntarioAtributo = :idVoluntarioAtributo, idVoluntario = :idVoluntario, idAtributo = :idAtributo" +
                "WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", voluntarioAtributo.getIdVoluntarioAtributo())
                    .addParameter("idVoluntario", voluntarioAtributo.getIdVoluntario())
                    .addParameter("idAtributo", voluntarioAtributo.getIdAtributo())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarVoluntarioAtributo(long id) {
        String sql = "DELETE FROM VoluntarioAtributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
