package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TaskEntity;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class TaskRepositoryImp implements TaskRepository {

    private static final Logger logger = Logger.getLogger(TaskRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public TaskEntity create(TaskEntity task) {
        String sql = "INSERT INTO Tarea (idEmergencia, tipoTarea, descripcion, estado) " +
                "VALUES (:idEmergencia, :tipoTarea, :descripcion, :estado)";

        String idTarea = java.util.UUID.randomUUID().toString();

        try(Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idEmergencia", task.getIdEmergency())
                    .addParameter("tipoTarea", task.getType())
                    .addParameter("descripcion", task.getDescription())
                    .addParameter("estado", task.isState())
                    .executeUpdate()
                            .getKey();

            task.setIdTask(id);

            return task;

        } catch (Exception e) {
            logger.severe("Error al crear tarea: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskEntity> getAll() {
        String sql = "SELECT * FROM Tarea";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(TaskEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las tareas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public TaskEntity getById(long id) {
        String sql = "SELECT * FROM Tarea WHERE idTarea = :id";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(TaskEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener tarea por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(TaskEntity task) {
        String sql = "UPDATE Tarea SET idEmergencia = :idEmergencia, tipoTarea = :tipoTarea, descripcion = :descripcion, estado = :estado WHERE idTarea = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", task.getIdEmergency())
                    .addParameter("tipoTarea", task.getType())
                    .addParameter("descripcion", task.getDescription())
                    .addParameter("estado", task.isState())
                    .addParameter("id", task.getIdTask())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM Tarea WHERE idTarea = :id";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<TaskEntity> getByEmergencyId(long idEmergency) {
        String sql = "SELECT * FROM Tarea WHERE idEmergencia = :idEmergencia";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idEmergencia", idEmergency)
                    .executeAndFetch(TaskEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener tareas por id de emergencia: " + e.getMessage());
            return Collections.emptyList();
        }
    }

}
