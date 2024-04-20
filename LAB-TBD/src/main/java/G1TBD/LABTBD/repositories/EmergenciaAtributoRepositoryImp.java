package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class EmergenciaAtributoRepositoryImp implements EmergenciaAtributoRepository {

    private static final Logger logger = Logger.getLogger(EmergenciaAtributoRepositoryImp.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmergenciaAtributoRepositoryImp.class);

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmergenciaAtributoEntity crear(EmergenciaAtributoEntity emergenciaAtributo) {
        String sql = "INSERT INTO Emergencia_Atributo (idEmergencia, idAtributo, compatibilidad) " +
                "VALUES (:idEmergencia, :idAtributo, :compatibilidad)";

        String idAtributo = java.util.UUID.randomUUID().toString();

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", emergenciaAtributo.getIdEmergencia())
                    .addParameter("idAtributo", emergenciaAtributo.getIdAtributo())
                    .addParameter("compatibilidad", emergenciaAtributo.isCompatibilidad())
                    .executeUpdate();

            emergenciaAtributo.setIdAtributo(java.util.UUID.fromString(idAtributo));

            return emergenciaAtributo;

        } catch (Exception e) {
            logger.severe("Error al crear emergenciaAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergenciaAtributoEntity> obtenerTodos() {
        String sql = "SELECT * FROM Emergencia_Atributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergenciaAtributoEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los emergenciaAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public EmergenciaAtributoEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM Emergencia_Atributo WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeAndFetchFirst(EmergenciaAtributoEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener emergenciaAtributo por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizar(EmergenciaAtributoEntity emergenciaAtributo) {
        String sql = "UPDATE Emergencia_Atributo SET idEmergencia = :idEmergencia, compatibilidad = :compatibilidad WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", emergenciaAtributo.getIdEmergencia())
                    .addParameter("compatibilidad", emergenciaAtributo.isCompatibilidad())
                    .addParameter("idAtributo", emergenciaAtributo.getIdAtributo())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar emergenciaAtributo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(long id){
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
