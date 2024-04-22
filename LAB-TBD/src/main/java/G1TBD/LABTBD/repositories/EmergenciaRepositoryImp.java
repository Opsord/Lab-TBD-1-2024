package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {

    private static final Logger logger = Logger.getLogger(EmergenciaRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmergenciaEntity crear(EmergenciaEntity emergencia){
        String sql = "INSERT INTO Emergencia (estadoEmergencia, tituloEmergencia, descripcionEmergencia)" +
                "VALUES (:estadoEmergencia, :tituloEmergencia, :descripcionEmergencia)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("estadoEmergencia", emergencia.isEstadoEmergencia())
                    .addParameter("tituloEmergencia", emergencia.getTituloEmergencia())
                    .addParameter("descripcionEmergencia", emergencia.getDescripcionEmergencia())
                    .executeUpdate()
                    .getKey();

            emergencia.setIdEmergencia(id);
            return emergencia;
        } catch (Exception e) {
            logger.severe("Error al crear emergencia: " + e.getMessage());
            return null;
        }
    }


    @Override
    public List<EmergenciaEntity> obtenerTodos(){
        String sql = "SELECT * FROM Emergencia";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las emergencias: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    public List<EmergenciaEntity> obtenerTodasActivas(){
        String sql = "SELECT * FROM Emergencia WHERE estadoemergencia = true";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las emergencias: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    public List<EmergenciaEntity> obtenerTodasFinalizadas(){
        String sql = "SELECT * FROM Emergencia WHERE estadoemergencia = false";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las emergencias finalizadas: " + e.getMessage());
            return Collections.emptyList();
        }
    }


    @Override
    public EmergenciaEntity obtenerPorId(long id){
        String sql = "SELECT * FROM Emergencia WHERE idEmergencia = :idEmergencia";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idEmergencia", id)
                    .executeAndFetchFirst(EmergenciaEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener emergencia por id: " + e.getMessage());
            return null;
        }

    }

//    @Override
//    public List<EmergenciaEntity> obtenerEmergenciaPorEstado(){
//        String sql = "SELECT * FROM Emergencia WHERE estadoEmergencia = true";
//
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql).executeAndFetch(EmergenciaEntity.class);
//        }
//    }


    @Override
    public boolean actualizar(EmergenciaEntity emergencia){
        String sql = "UPDATE Emergencia SET estadoEmergencia = :estadoEmergencia, tituloEmergencia = :tituloEmergencia, "+
                "descripcionEmergencia = :descripcionEmergencia" +
                "WHERE idEmergencia = :idEmergencia";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", emergencia.getIdEmergencia())
                    .addParameter("estadoEmergencia", emergencia.isEstadoEmergencia())
                    .addParameter("tituloEmergencia", emergencia.getTituloEmergencia())
                    .addParameter("descripcionEmergencia", emergencia.getDescripcionEmergencia())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar emergencia: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(long id){
        String sql = "DELETE FROM Emergencia WHERE idEmergencia = :idEmergencia";

        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("idEmergencia", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar emergencia: " + e.getMessage());
            return false;
        }
    }


    @Override
    public List<EmergenciaEntity> encontrarEmergenciasFinalizadas(){
        try (Connection connection = sql2o.open()) {
            String sql = "SELECT e.* " +
                    "FROM Emergencia e " +
                    "WHERE e.estadoEmergencia = false";

            return connection.createQuery(sql)
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception exception) {
            logger.severe("Error al obtener emergencias finalizadas: " + exception.getMessage());
            return Collections.emptyList();
        }
    }

}
