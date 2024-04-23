package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergencyEntity;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class EmergencyRepositoryImp implements EmergencyRepository {

    private static final Logger logger = Logger.getLogger(EmergencyRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmergencyEntity create(EmergencyEntity emergency){
        String sql = "INSERT INTO Emergencia (estadoEmergencia, tituloEmergencia, descripcionEmergencia, idCoordinador)" +
                "VALUES (:estadoEmergencia, :tituloEmergencia, :descripcionEmergencia, :idCoordinador)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("estadoEmergencia", emergency.isStatus())
                    .addParameter("tituloEmergencia", emergency.getTitle())
                    .addParameter("descripcionEmergencia", emergency.getDescription())
                    .addParameter("idCoordinador", emergency.getIdCoordinator())
                    .executeUpdate()
                    .getKey();

            emergency.setIdEmergency(id);
            return emergency;
        } catch (Exception e) {
            logger.severe("Error al crear emergencia: " + e.getMessage());
            return null;
        }
    }


    @Override
    public List<EmergencyEntity> getAll(){
        String sql = "SELECT * FROM Emergencia";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergencyEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las emergencias: " + e.getMessage());
            return Collections.emptyList();
        }
    }
    public List<EmergencyEntity> getAllActive(){
        String sql = "SELECT * FROM Emergencia WHERE estadoemergencia = true";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergencyEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las emergencias: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public EmergencyEntity getById(long id){
        String sql = "SELECT * FROM Emergencia WHERE idEmergencia = :idEmergencia";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idEmergencia", id)
                    .executeAndFetchFirst(EmergencyEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener emergencia por id: " + e.getMessage());
            return null;
        }

    }

//    @Override
//    public List<EmergencyEntity> obtenerEmergenciaPorEstado(){
//        String sql = "SELECT * FROM Emergencia WHERE estadoEmergencia = true";
//
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql).executeAndFetch(EmergencyEntity.class);
//        }
//    }


    @Override
    public boolean update(EmergencyEntity emergency){
        String sql = "UPDATE Emergencia SET estadoEmergencia = :estadoEmergencia, tituloEmergencia = :tituloEmergencia, "+
                "descripcionEmergencia = :descripcionEmergencia" +
                "WHERE idEmergencia = :idEmergencia";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", emergency.getIdEmergency())
                    .addParameter("estadoEmergencia", emergency.isStatus())
                    .addParameter("tituloEmergencia", emergency.getTitle())
                    .addParameter("descripcionEmergencia", emergency.getDescription())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar emergencia: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id){
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
    public List<EmergencyEntity> getClosedEmergencies(){
        try (Connection connection = sql2o.open()) {
            String sql = "SELECT e.* " +
                    "FROM Emergencia e " +
                    "WHERE e.estadoEmergencia = false";

            return connection.createQuery(sql)
                    .executeAndFetch(EmergencyEntity.class);
        } catch (Exception exception) {
            logger.severe("Error al obtener emergencias finalizadas: " + exception.getMessage());
            return Collections.emptyList();
        }
    }
    /*
    @Override
    public List<EmergencyEntity> encontrarEmergenciasFinalizadas(){
        try (Connection connection = sql2o.open()) {
            String sql = "SELECT e.idEmergencia, COUNT(DISTINCT t.idTarea) AS cantidadTareas, COUNT(DISTINCT va.rutVoluntario) AS cantidadVoluntarios " +
                    "FROM Emergencia e " +
                    "LEFT JOIN Tarea t ON e.idEmergencia = t.idEmergencia " +
                    "LEFT JOIN VoluntarioAtributo va ON t.rutVoluntario = va.rutVoluntario " +
                    "WHERE e.estadoEmergencia = true " +
                    "GROUP BY e.idEmergencia";

            return connection.createQuery(sql)
                    .executeAndFetch(EmergencyEntity.class);
        } catch (Exception exception) {
            logger.severe("Error al obtener emergencias finalizadas: " + exception.getMessage());
            return Collections.emptyList();
        }
    }

     */



}
