package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VolunteerEntity;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class VolunteerRepositoryImp implements VolunteerRepository {

    private static final Logger logger = Logger.getLogger(VolunteerRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public VolunteerEntity create(VolunteerEntity volunteer) {
        String sql = "INSERT INTO Voluntario (rut, nombre, apellido, edadVoluntario, sexoVoluntario, email, contrasena, disponibilidad, role) "
                +
                "VALUES (:rut, :nombre, :apellido, :edadVoluntario, :sexoVoluntario, :email, :contrasena, :disponibilidad, :role)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", volunteer.getRut())
                    .addParameter("nombre", volunteer.getName())
                    .addParameter("apellido", volunteer.getLastName())
                    .addParameter("edadVoluntario", volunteer.getAge())
                    .addParameter("sexoVoluntario", volunteer.isSex())
                    .addParameter("email", volunteer.getEmail())
                    .addParameter("contrasena", volunteer.getPassword())
                    .addParameter("disponibilidad", volunteer.isAvailability())
                    .addParameter("role", volunteer.getRole())
                    .executeUpdate();
            return volunteer;
        } catch (Exception e) {
            logger.severe("Error al crear voluntario: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerEntity> getAll() {
        String sql = "SELECT * FROM Voluntario";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(VolunteerEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los voluntarios: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public VolunteerEntity getByRut(String rut) {
        String sql = "SELECT * FROM Voluntario WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            List<VolunteerEntity> voluntarios = conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeAndFetch(VolunteerEntity.class);
            return voluntarios.isEmpty() ? null : voluntarios.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntario por rut: " + e.getMessage());
            return null;
        }
    }
    @Override
    public VolunteerEntity getById(long id) {
//        String sql = "SELECT * FROM Voluntario WHERE idVoluntario = :idVoluntario";
        String sql = "SELECT idVoluntario, rut, email, nombre, apellido, edadVoluntario, sexoVoluntario, contrasena, disponibilidad, role FROM Voluntario WHERE idVoluntario = :idVoluntario";

        try (Connection conn = sql2o.open()) {
            List<VolunteerEntity> voluntarios = conn.createQuery(sql)
                    .addParameter("idVoluntario", id)
                    .executeAndFetch(VolunteerEntity.class);
            return voluntarios.isEmpty() ? null : voluntarios.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntario por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public VolunteerEntity getByEmail(String email) {
        String sql = "SELECT * FROM Voluntario WHERE email = :email";

        try (Connection conn = sql2o.open()) {
            List<VolunteerEntity> voluntarios = conn.createQuery(sql)
                    .addParameter("email", email)
                    .executeAndFetch(VolunteerEntity.class);
            return voluntarios.isEmpty() ? null : voluntarios.get(0);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntario por email: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(VolunteerEntity volunteer) {
        String sql = "UPDATE Voluntario SET rut = :rut, nombre = :nombre, apellido = :apellido, " +
                "edadVoluntario = :edadVoluntario, sexoVoluntario = :sexoVoluntario, email = :email, contrasena = :contrasena, disponibilidad = :disponibilidad "
                +
                "WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", volunteer.getRut())
                    .addParameter("nombre", volunteer.getName())
                    .addParameter("apellido", volunteer.getLastName())
                    .addParameter("edadVoluntario", volunteer.getAge())
                    .addParameter("sexoVoluntario", volunteer.isSex())
                    .addParameter("email", volunteer.getEmail())
                    .addParameter("contrasena", volunteer.getPassword())
                    .addParameter("disponibilidad", volunteer.isAvailability())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar voluntario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String rut) {
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
    public List<VolunteerEntity> getByEmergencyId(long idEmergency) {
        String sql = "SELECT v.* FROM Voluntario v " +
                "JOIN Voluntario_Atributo va ON v.idVoluntario = va.idVoluntario " +
                "JOIN Atributo a ON va.idAtributo = a.idAtributo " +
                "JOIN Emergencia_Atributo ea ON va.idAtributo = ea.idAtributo " +
                "JOIN Emergencia e ON ea.idEmergencia = e.idEmergencia " +
                "WHERE e.idEmergencia = :idEmergencia";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idEmergencia", idEmergency)
                    .executeAndFetch(VolunteerEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntarios por emergencia: " + e.getMessage());
            return Collections.emptyList();
        }
    }

}
