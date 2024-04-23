package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CoordinatorRepositoryImp implements CoordinatorRepository {

    private static final Logger logger = Logger.getLogger(CoordinatorRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public CoordinatorEntity create(CoordinatorEntity coordinator) {
        String sql = "INSERT INTO Coordinador (rut, nombre, apellido, email, contrasena, idInstitucion, role) " +
                "VALUES (:rut, :nombre, :apellido, :email, :contrasena, :idInstitucion, :role)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", coordinator.getRut())
                    .addParameter("nombre", coordinator.getName())
                    .addParameter("apellido", coordinator.getLastName())
                    .addParameter("email", coordinator.getEmail())
                    .addParameter("contrasena", coordinator.getPassword())
                    .addParameter("idInstitucion", coordinator.getIdInstitution())
                    .addParameter("role", coordinator.getRole())
                    .executeUpdate();
            return coordinator;
        } catch (Exception e) {
            logger.severe("Error al crear coordinador: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<CoordinatorEntity> getAll() {
        String sql = "SELECT * FROM Coordinador";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(CoordinatorEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los coordinadores: " + e.getMessage());
            return null;
        }
    }

    @Override
    public CoordinatorEntity getByRut(String rut) {
        String sql = "SELECT * FROM Coordinador WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            List<CoordinatorEntity> coordinadores = conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeAndFetch(CoordinatorEntity.class);
            if (coordinadores.isEmpty()) {
                return null;
            }
            return coordinadores.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener coordinador por rut: " + e.getMessage());
            return null;
        }
    }

    @Override
    public CoordinatorEntity getByEmail(String email) {
        String sql = "SELECT * FROM Coordinador WHERE email = :email";

        try (Connection conn = sql2o.open()) {
            List<CoordinatorEntity> coordinadores = conn.createQuery(sql)
                    .addParameter("email", email)
                    .executeAndFetch(CoordinatorEntity.class);
            if (coordinadores.isEmpty()) {
                return null;
            }
            return coordinadores.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener coordinador por email: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(CoordinatorEntity coordinator) {
        String sql = "UPDATE Coordinador SET rut = :rut, nombre = :nombre, " +
                "apellido = :apellido, email = :email, contrasena = :contrasena, idInstitucion = :idInstitucion " +
                "WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", coordinator.getRut())
                    .addParameter("nombre", coordinator.getName())
                    .addParameter("apellido", coordinator.getLastName())
                    .addParameter("email", coordinator.getEmail())
                    .addParameter("contrasena", coordinator.getPassword())
                    .addParameter("idInstitucion", coordinator.getIdInstitution())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar coordinador: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String rut) {
        String sql = "DELETE FROM Coordinador WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar coordinador: " + e.getMessage());
            return false;
        }
    }
}
