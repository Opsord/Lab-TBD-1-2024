package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class EmergencyAttributeRepositoryImp implements EmergencyAttributeRepository {

    private static final Logger logger = Logger.getLogger(EmergencyAttributeRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmergencyAttributeEntity create(EmergencyAttributeEntity emergencyAttribute) {
        String sql = "INSERT INTO Emergencia_Atributo (idEmergencia,idAtributo, compatibilidad) " +
                "VALUES (:idEmergencia, :idAtributo, :compatibilidad)";


        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idEmergencia", emergencyAttribute.getIdEmergency())
                    .addParameter("idAtributo", emergencyAttribute.getIdAttribute())
                    .addParameter("compatibilidad", emergencyAttribute.isCompatibility())
                    .executeUpdate()
                    .getKey();

            emergencyAttribute.setIdAttribute(id);

            return emergencyAttribute;

        } catch (Exception e) {
            logger.severe("Error al crear emergenciaAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergencyAttributeEntity> getAll() {
        String sql = "SELECT * FROM Emergencia_Atributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergencyAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los emergenciaAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public EmergencyAttributeEntity getById(long id) {
        String sql = "SELECT * FROM Emergencia_Atributo WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeAndFetchFirst(EmergencyAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener emergenciaAtributo por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(EmergencyAttributeEntity emergencyAttribute) {
        String sql = "UPDATE Emergencia_Atributo SET idEmergencia = :idEmergencia, compatibilidad = :compatibilidad WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", emergencyAttribute.getIdEmergency())
                    .addParameter("compatibilidad", emergencyAttribute.isCompatibility())
                    .addParameter("idAtributo", emergencyAttribute.getIdAttribute())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar emergenciaAtributo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM Emergencia_Atributo WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar emergenciaAtributo: " + e.getMessage());
            return false;
        }
    }
}
