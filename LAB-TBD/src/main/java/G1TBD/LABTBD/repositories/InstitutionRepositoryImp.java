package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitutionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class InstitutionRepositoryImp implements InstitutionRepository {

    private static final Logger logger = Logger.getLogger(InstitutionRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public InstitutionEntity create(InstitutionEntity institucion) {
        String sql = "INSERT INTO Institucion (nombreInstitucion)" +
                "VALUES (:nombreInstitucion)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("nombreInstitucion", institucion.getName())
                    .executeUpdate()
                    .getKey();

            institucion.setIdInstitution(id);

            return institucion;

        } catch (Exception e) {
            logger.severe("Error al crear institucion: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<InstitutionEntity> getAll() {
        String sql = "SELECT * FROM Institucion ORDER BY idInstitucion ASC";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(InstitutionEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las instituciones: " + e.getMessage());
            return null;
        }
    }

    @Override
    public InstitutionEntity getById(long id) {
        String sql = "SELECT * FROM Institucion WHERE idInstitucion = :idInstitucion";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idInstitucion", id)
                    .executeAndFetchFirst(InstitutionEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener institucion por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(InstitutionEntity institucion) {
        String sql = "UPDATE Institucion SET nombreInstitucion = :nombreInstitucion" +
                "WHERE idInstitucion = :idInstitucion";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idInstitucion", institucion.getIdInstitution())
                    .addParameter("nombreInstitucion", institucion.getName())
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
    public boolean delete(long id){
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
