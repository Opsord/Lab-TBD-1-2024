package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class CoordinadorRepositoryImp implements CoordinadorRepository {
    private Sql2o sql2o;

    public CoordinadorRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    // Crear un Coordinador
    @Override
    public void create(CoordinadorEntity coordinador) {
        String sql =
                "INSERT INTO Coordinador (rutCoordinador, nombreCoordinador, apellidoCoordinador, contrasena, idInstitucion) " +
                        "VALUES (:rutCoordinador, :nombreCoordinador, :apellidoCoordinador, :contrasena, :idInstitucion)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("rutcoordinador", coordinador.getRutCoordinador())
                    .addParameter("nombrecoordinador", coordinador.getNombreCoordinador())
                    .addParameter("apellidocoordinador", coordinador.getApellidoCoordinador())
                    .addParameter("contrasena", coordinador.getContrasena())
                    .addParameter("idinstitucion", coordinador.getIdInstitucion())
                    .executeUpdate();
        }
    }

    // Conseguir coordinador por su id
    @Override
    public CoordinadorEntity conseguirPorId(Integer id) {
        String sql = "SELECT * FROM Coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idcoordinador", id)
                    .executeAndFetchFirst(CoordinadorEntity.class);
        }
    }

    // Actualizar datos de un coordinador
    @Override
    public void Update(CoordinadorEntity coordinador) {
        String sql =
                "UPDATE Coordinador SET rutCoordinador = :rutCoordinador, nombreCoordinador = :nombreCoordinador, " +
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
        }
    }

    // Eliminar un Coordinador
    @Override
    public void Delete(Integer id) {
        String sql = "DELETE FROM Coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idcoordinador", id)
                    .executeUpdate();
        }
    }
}
