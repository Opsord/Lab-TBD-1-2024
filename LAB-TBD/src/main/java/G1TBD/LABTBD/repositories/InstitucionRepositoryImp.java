package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitucionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {

    private static final Logger logger = Logger.getLogger(InstitucionRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public InstitucionEntity crear(InstitucionEntity institucion) {
        String sql = "INSERT INTO Institucion (nombreInstitucion)" +
                "VALUES (:nombreInstitucion)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("nombreInstitucion", institucion.getNombreInstitucion())
                    .executeUpdate()
                    .getKey();

            institucion.setIdInstitucion(id);

            return institucion;

        } catch (Exception e) {
            logger.severe("Error al crear institucion: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<InstitucionEntity> obtenerTodos() {
        String sql = "SELECT * FROM Institucion ORDER BY idInstitucion ASC";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(InstitucionEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las instituciones: " + e.getMessage());
            return null;
        }
    }

    @Override
    public InstitucionEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM Institucion WHERE idInstitucion = :idInstitucion";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idInstitucion", id)
                    .executeAndFetchFirst(InstitucionEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener institucion por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizar(InstitucionEntity institucion) {
        String sql = "UPDATE Institucion SET nombreInstitucion = :nombreInstitucion" +
                "WHERE idInstitucion = :idInstitucion";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idInstitucion", institucion.getIdInstitucion())
                    .addParameter("nombreInstitucion", institucion.getNombreInstitucion())
                    .executeUpdate()
                    .getKey();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar institucion: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(long id){
        String sql = "DELETE FROM Institucion WHERE idInstitucion = :idInstitucion";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idInstitucion", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar institucion: " + e.getMessage());
            return false;
        }
    }
}
