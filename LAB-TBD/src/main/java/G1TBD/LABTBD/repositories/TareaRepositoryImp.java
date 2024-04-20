package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class TareaRepositoryImp implements TareaRepository{

    private static final Logger logger = Logger.getLogger(TareaRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public TareaEntity crear(TareaEntity tarea) {
        String sql = "INSERT INTO Tarea (idEmergencia, tipoTarea, descripcion, estado) " +
                "VALUES (:idEmergencia, :tipoTarea, :descripcion, :estado)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("tipoTarea", tarea.getTipoTarea())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("estado", tarea.isEstado())
                    .executeUpdate()
                    .getKey();
            tarea.setIdTarea(id);
            return tarea;
        } catch (Exception e) {
            logger.severe("Error al crear tarea: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaEntity> obtenerTodos() {
        String sql = "SELECT * FROM Tarea";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las tareas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public TareaEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM Tarea WHERE idTarea = :id";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener tarea por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizar(TareaEntity tarea) {
        String sql = "UPDATE Tarea SET idEmergencia = :idEmergencia, tipoTarea = :tipoTarea, descripcion = :descripcion, estado = :estado WHERE idTarea = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("tipoTarea", tarea.getTipoTarea())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("estado", tarea.isEstado())
                    .addParameter("id", tarea.getIdTarea())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(long id) {
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
    public List<TareaEntity> obtenerTareasPorIdEmergencia(long idEmergencia) {
        String sql = "SELECT * FROM Tarea WHERE idEmergencia = :idEmergencia";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idEmergencia", idEmergencia)
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener tareas por id de emergencia: " + e.getMessage());
            return null;
        }
    }

}
