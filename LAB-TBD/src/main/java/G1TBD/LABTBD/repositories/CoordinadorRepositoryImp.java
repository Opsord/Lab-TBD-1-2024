package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CoordinadorRepositoryImp implements CoordinadorRepository {

    private static final Logger logger = Logger.getLogger(CoordinadorRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public CoordinadorEntity crear(CoordinadorEntity coordinador) {
        String sql = "INSERT INTO Coordinador (rut, nombre, apellido, email, contrasena, idInstitucion, role) " +
                "VALUES (:rut, :nombre, :apellido, :email, :contrasena, :idInstitucion, :role)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", coordinador.getRut())
                    .addParameter("nombre", coordinador.getNombre())
                    .addParameter("apellido", coordinador.getApellido())
                    .addParameter("email", coordinador.getEmail())
                    .addParameter("contrasena", coordinador.getContrasena())
                    .addParameter("idInstitucion", coordinador.getIdInstitucion())
                    .addParameter("role", coordinador.getRole())
                    .executeUpdate();
            return coordinador;
        } catch (Exception e) {
            logger.severe("Error al crear coordinador: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<CoordinadorEntity> obtenerTodos() {
        String sql = "SELECT * FROM Coordinador";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(CoordinadorEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los coordinadores: " + e.getMessage());
            return null;
        }
    }

    @Override
    public CoordinadorEntity obtenerPorRut(String rut) {
        String sql = "SELECT * FROM Coordinador WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            List<CoordinadorEntity> coordinadores = conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeAndFetch(CoordinadorEntity.class);
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
    public CoordinadorEntity obtenerPorEmail(String email) {
        String sql = "SELECT * FROM Coordinador WHERE email = :email";

        try (Connection conn = sql2o.open()) {
            List<CoordinadorEntity> coordinadores = conn.createQuery(sql)
                    .addParameter("email", email)
                    .executeAndFetch(CoordinadorEntity.class);
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
    public boolean actualizar(CoordinadorEntity coordinador) {
        String sql = "UPDATE Coordinador SET rut = :rut, nombre = :nombre, " +
                "apellido = :apellido, email = :email, contrasena = :contrasena, idInstitucion = :idInstitucion " +
                "WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", coordinador.getRut())
                    .addParameter("nombre", coordinador.getNombre())
                    .addParameter("apellido", coordinador.getApellido())
                    .addParameter("email", coordinador.getEmail())
                    .addParameter("contrasena", coordinador.getContrasena())
                    .addParameter("idInstitucion", coordinador.getIdInstitucion())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar coordinador: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String rut) {
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
