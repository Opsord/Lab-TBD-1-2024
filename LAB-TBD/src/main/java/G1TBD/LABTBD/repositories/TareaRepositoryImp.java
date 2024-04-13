package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TareaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public TareaEntity crearTarea(TareaEntity tarea) {
        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery("INSERT INTO Tarea (idEmergencia, tipoTarea, descripcion, estado) " +
                            "VALUES (:idEmergencia, :tipoTarea, :descripcion, :estado)")
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("tipoTarea", tarea.getTipoTarea())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("estado", tarea.isEstado())
                    .executeUpdate()
                    .getKey();
            tarea.setIdTarea(id);
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaEntity> obtenerTodasLasTareas() {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Tarea")
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TareaEntity obtenerTareaPorId(long id) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Tarea WHERE idTarea = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizarTarea(TareaEntity tarea) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Tarea SET idEmergencia = :idEmergencia, tipoTarea = :tipoTarea, descripcion = :descripcion, estado = :estado WHERE idTarea = :id")
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("tipoTarea", tarea.getTipoTarea())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("estado", tarea.isEstado())
                    .addParameter("id", tarea.getIdTarea())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarTarea(long id) {
        try(Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Tarea WHERE idTarea = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
