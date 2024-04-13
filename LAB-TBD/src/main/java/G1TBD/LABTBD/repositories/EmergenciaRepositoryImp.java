package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaEntity;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class EmergenciaRepositoryImp implements EmergenciaRepository {

    private Sql2o sql2o;

    public EmergenciaRepositoryImp(Sql2o sql2o){this.sql2o = sql2o;}

    @Override
    public void create(EmergenciaEntity emergencia){
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
    public void update(EmergenciaEntity emergencia){
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
    public void delete(Integer id){
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
