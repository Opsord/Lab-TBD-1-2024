package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void crearEmergencia(EmergenciaEntity emergencia){
        String sql =
                "INSERT INTO Emergencia (estadoEmergencia, tituloEmergencia, descripcionEmergencia)"+
                        "VALUES (:estadoEmergencia, :tituloEmergencia, :descripcionEmergencia)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("estadoEmergencia", emergencia.isEstadoEmergencia())
                    .addParameter("tituloEmergencia", emergencia.getTituloEmergencia())
                    .addParameter("descripcionEmergencia", emergencia.getDescripcionEmergencia())
                    .executeUpdate();
            con.commit();

        }
    }

    @Override
    public List<EmergenciaEntity> obtenerTodasLasEmergencias(){
        String sql = "SELECT * FROM emergencia";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EmergenciaEntity.class);
        }
    }

    @Override
    public EmergenciaEntity obtenerEmergenciaPorId(long id){
        String sql = "SELECT * FROM emergencia WHERE idEmergencia = :idEmergencia";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idEmergencia", id)
                    .executeAndFetchFirst(EmergenciaEntity.class);
        }
    }

//    @Override
//    public List<EmergenciaEntity> obtenerEmergenciaPorEstado(){
//        String sql = "SELECT * FROM emergencia WHERE estadoEmergencia = true";
//
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql).executeAndFetch(EmergenciaEntity.class);
//        }
//    }


    @Override
    public void actualizarEmergencia(EmergenciaEntity emergencia){
        String sql =
                "UPDATE emergencia SET estadoEmergencia = :estadoEmergencia, tituloEmergencia = :tituloEmergencia, "+
                        "descripcionEmergencia = :descripcionEmergencia" +
                        "WHERE idEmergencia = :idEmergencia";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idEmergencia", emergencia.getIdEmergencia())
                    .addParameter("estadoEmergencia", emergencia.isEstadoEmergencia())
                    .addParameter("tituloEmergencia", emergencia.getTituloEmergencia())
                    .addParameter("descripcionEmergencia", emergencia.getDescripcionEmergencia())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void eliminarEmergencia(long id){
        String sql =
                "DELETE FROM emergencia WHERE idEmergencia = :idEmergencia";

        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("idEmergencia", id)
                    .executeUpdate();
            con.commit();
        }
    }


}
