package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VolunteerAttributeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class VolunteerAttributeRepositoryImp implements VolunteerAttributeRepository {

    private static final Logger logger = Logger.getLogger(VolunteerAttributeRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public VolunteerAttributeEntity create(VolunteerAttributeEntity volunteerAttribute) {
        String sql = "INSERT INTO Voluntario_Atributo ( idVoluntario, idAtributo)" +
                "VALUES (:idVoluntario, :idAtributo)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idVoluntario", volunteerAttribute.getIdAttribute())
                    .addParameter("idAtributo", volunteerAttribute.getIdAttribute())
                    .executeUpdate()
                    .getKey();

            volunteerAttribute.setIdVolunteerAttribute(id);

            return volunteerAttribute;
        } catch (Exception e) {
            logger.severe("Error al crear voluntarioAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerAttributeEntity> getAll() {
        String sql = "SELECT * FROM Voluntario_Atributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(VolunteerAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los voluntarioAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public VolunteerAttributeEntity getById(long id) {
        String sql = "SELECT * FROM Voluntario_Atributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", id)
                    .executeAndFetchFirst(VolunteerAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntarioAtributo por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(VolunteerAttributeEntity volunteerAttribute) {
        String sql = "UPDATE Voluntario_Atributo SET idVoluntarioAtributo = :idVoluntarioAtributo, idVoluntario = :idVoluntario, idAtributo = :idAtributo" +
                "WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", volunteerAttribute.getIdVolunteerAttribute())
                    .addParameter("idVoluntario", volunteerAttribute.getIdVolunteer())
                    .addParameter("idAtributo", volunteerAttribute.getIdAttribute())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar voluntarioAtributo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM Voluntario_Atributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar voluntarioAtributo: " + e.getMessage());
            return false;
        }
    }
}
