package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CoordinadorRepositoryImp implements CoordinadorRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void crearCoordinador(CoordinadorEntity coordinador) {
        String sql =
                "INSERT INTO coordinador (rutCoordinador, nombreCoordinador, apellidoCoordinador, contrasena, idInstitucion) " +
                        "VALUES (:rutCoordinador, :nombreCoordinador, :apellidoCoordinador, :contrasena, :idInstitucion)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("rutcoordinador", coordinador.getRutCoordinador())
                    .addParameter("nombrecoordinador", coordinador.getNombreCoordinador())
                    .addParameter("apellidocoordinador", coordinador.getApellidoCoordinador())
                    .addParameter("contrasena", coordinador.getContrasena())
                    .addParameter("idinstitucion", coordinador.getIdInstitucion())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public List<CoordinadorEntity> obtenerTodosLosCoordinadores(){
        String sql = "SELECT * FROM coordinador";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(CoordinadorEntity.class);
        }

    }

    @Override
    public CoordinadorEntity obtenerCoordinadorPorId(long id) {
        String sql = "SELECT * FROM coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idcoordinador", id)
                    .executeAndFetchFirst(CoordinadorEntity.class);
        }
    }

    @Override
    public void actualizarCoordinador(CoordinadorEntity coordinador) {
        String sql =
                "UPDATE coordinador SET rutCoordinador = :rutCoordinador, nombreCoordinador = :nombreCoordinador, " +
                        "apellidoCoordinador = :apellidoCoordinador, contrasena = :contrasena, idInstitucion = :idInstitucion " +
                        "WHERE idCoordinador = :idCoordinador";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idcoordinador", coordinador.getIdCoordinador())
                    .addParameter("rutcoordinador", coordinador.getRutCoordinador())
                    .addParameter("nombrecoordinador", coordinador.getNombreCoordinador())
                    .addParameter("apellidocoordinador", coordinador.getApellidoCoordinador())
                    .addParameter("contrasena", coordinador.getContrasena())
                    .addParameter("idinstitucion", coordinador.getIdInstitucion())
                    .executeUpdate();
            con.commit();
        }
    }

    @Override
    public void eliminarCoordinador(long id) {
        String sql = "DELETE FROM coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idcoordinador", id)
                    .executeUpdate();
            con.commit();
        }
    }
}
