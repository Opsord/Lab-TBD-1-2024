package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.CoordinadorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class CoordinadorRepositoryImp implements CoordinadorRepository {
    @Autowired
    private Sql2o sql2o;

    // Crear un Coordinador
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
    public CoordinadorEntity conseguirPorId(Integer id) {
        String sql = "SELECT * FROM Coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idcoordinador", id)
                    .executeAndFetchFirst(CoordinadorEntity.class);
        }
    }

    // Actualizar datos de un coordinador
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
    public void Delete(Integer id) {
        String sql = "DELETE FROM Coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idcoordinador", id)
                    .executeUpdate();
        }
    }
}
