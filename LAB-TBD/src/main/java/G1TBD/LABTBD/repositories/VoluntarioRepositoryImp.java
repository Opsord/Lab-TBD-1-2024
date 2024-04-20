package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class VoluntarioRepositoryImp implements  VoluntarioRepository{

    private static final Logger logger = Logger.getLogger(VoluntarioRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioEntity crear(VoluntarioEntity voluntario) {
        String sql = "INSERT INTO Voluntario (rutVoluntario, nombreVoluntario, apellidoVoluntario, edadVoluntario, sexoVoluntario, email, contrasena, disponibilidad) " +
                "VALUES (:rutVoluntario, :nombreVoluntario, :apellidoVoluntario, :edadVoluntario, :sexoVoluntario, :email, :contrasena, :disponibilidad)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("rutVoluntario", voluntario.getRutVoluntario())
                    .addParameter("nombreVoluntario", voluntario.getNombreVoluntario())
                    .addParameter("apellidoVoluntario", voluntario.getApellidoVoluntario())
                    .addParameter("edadVoluntario", voluntario.getEdadVoluntario())
                    .addParameter("sexoVoluntario", voluntario.isSexoVoluntario())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("disponibilidad", voluntario.isDisponibilidad())
                    .executeUpdate()
                    .getKey();
            voluntario.setIdVoluntario(id);
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
    public VoluntarioEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM Voluntario WHERE idVoluntario = :idVoluntario";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idVoluntario", id)
                    .executeAndFetchFirst(VoluntarioEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntario por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizar(VoluntarioEntity voluntario) {
        String sql = "UPDATE Voluntario SET rutVoluntario = :rutVoluntario, nombreVoluntario = :nombreVoluntario, apellidoVoluntario = :apellidoVoluntario, " +
                "edadVoluntario = :edadVoluntario, sexoVoluntario = :sexoVoluntario, email = :email, contrasena = :contrasena, disponibilidad = :disponibilidad " +
                "WHERE idVoluntario = :idVoluntario";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntario", voluntario.getIdVoluntario())
                    .addParameter("rutVoluntario", voluntario.getRutVoluntario())
                    .addParameter("nombreVoluntario", voluntario.getNombreVoluntario())
                    .addParameter("apellidoVoluntario", voluntario.getApellidoVoluntario())
                    .addParameter("edadVoluntario", voluntario.getContrasena())
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
    public boolean eliminar(long id) {
        String sql = "DELETE FROM Voluntario WHERE idVoluntario = :idVoluntario";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntario", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar voluntario: " + e.getMessage());
            return false;
        }
    }

}
