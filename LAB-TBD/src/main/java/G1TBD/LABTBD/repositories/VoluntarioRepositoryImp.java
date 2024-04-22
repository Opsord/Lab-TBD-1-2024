package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {

    private static final Logger logger = Logger.getLogger(VoluntarioRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioEntity crear(VoluntarioEntity voluntario) {
        String sql = "INSERT INTO Voluntario (rut, nombre, apellido, edadVoluntario, sexoVoluntario, email, contrasena, disponibilidad, role) "
                +
                "VALUES (:rut, :nombre, :apellido, :edadVoluntario, :sexoVoluntario, :email, :contrasena, :disponibilidad, :role)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("edadVoluntario", voluntario.getEdadVoluntario())
                    .addParameter("sexoVoluntario", voluntario.isSexoVoluntario())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("disponibilidad", voluntario.isDisponibilidad())
                    .addParameter("role", voluntario.getRole())
                    .executeUpdate();
            return voluntario;
        } catch (Exception e) {
            logger.severe("Error al crear voluntario: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioEntity> obtenerTodos() {
        String sql = "SELECT * FROM Voluntario";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los voluntarios: " + e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity obtenerPorRut(String rut) {
        String sql = "SELECT * FROM Voluntario WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            List<VoluntarioEntity> voluntarios = conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntarios.isEmpty() ? null : voluntarios.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntario por rut: " + e.getMessage());
            return null;
        }
    }
    @Override
    public VoluntarioEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM Voluntario WHERE idVoluntario = :idvoluntario";

        try (Connection conn = sql2o.open()) {
            List<VoluntarioEntity> voluntarios = conn.createQuery(sql)
                    .addParameter("idVoluntario", id)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntarios.isEmpty() ? null : voluntarios.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntario por rut: " + e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity obtenerPorEmail(String email) {
        String sql = "SELECT * FROM Voluntario WHERE email = :email";

        try (Connection conn = sql2o.open()) {
            List<VoluntarioEntity> voluntarios = conn.createQuery(sql)
                    .addParameter("email", email)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntarios.isEmpty() ? null : voluntarios.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntario por email: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizar(VoluntarioEntity voluntario) {
        String sql = "UPDATE Voluntario SET rut = :rut, nombre = :nombre, apellido = :apellido, " +
                "edadVoluntario = :edadVoluntario, sexoVoluntario = :sexoVoluntario, email = :email, contrasena = :contrasena, disponibilidad = :disponibilidad "
                +
                "WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("edadVoluntario", voluntario.getEdadVoluntario())
                    .addParameter("sexoVoluntario", voluntario.isSexoVoluntario())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("disponibilidad", voluntario.isDisponibilidad())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar voluntario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String rut) {
        String sql = "DELETE FROM Voluntario WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar voluntario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<VoluntarioEntity> obtenerPorEmergencia(long idEmergencia) {
        String sql = "SELECT v.* FROM Voluntario v " +
                "JOIN Voluntario_Atributo va ON v.idVoluntario = va.idVoluntario " +
                "JOIN Atributo a ON va.idAtributo = a.idAtributo " +
                "JOIN Emergencia_Atributo ea ON va.idAtributo = ea.idAtributo " +
                "JOIN Emergencia e ON ea.idEmergencia = e.idEmergencia " +
                "WHERE e.idEmergencia = :idEmergencia";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idEmergencia", idEmergencia)
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntarios por emergencia: " + e.getMessage());
            return null;
        }
    }

}
