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

    // CREATE
    @Override
    public TareaEntity crearTarea(TareaEntity tarea) {
        try (Connection conn = sql2o.open()) {
            long idGenerado = (long) conn.createQuery("INSERT INTO Tarea (idEmergencia, tipoTarea, descripcion, estado) " +
                            "VALUES (:idEmergencia, :tipoTarea, :descripcion, :estado)", true)
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("tipoTarea", tarea.getTipoTarea())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("estado", tarea.isEstado())
                    .executeUpdate()
                    .getKey();
            tarea.setIdTarea(idGenerado);
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // GET - ALL
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

    // GET - BY ID
    @Override
    public TareaEntity obtenerPorId(long id) {
        try(Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Tarea WHERE idTarea = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // UPDATE
    @Override
    public void actualizarTarea(TareaEntity tarea) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE Tarea SET idEmergencia = :idEmergencia, tipoTarea = :tipoTarea, descripcion = :descripcion, estado = :estado WHERE idTarea = :id")
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .addParameter("tipoTarea", tarea.getTipoTarea())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("estado", tarea.isEstado())
                    .addParameter("id", tarea.getIdTarea())
                    .executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    @Override
    public void eliminarTarea(long id) {
        try(Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Tarea WHERE idTarea = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
