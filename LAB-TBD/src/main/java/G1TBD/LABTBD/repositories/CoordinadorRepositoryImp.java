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
    public CoordinadorEntity crear(CoordinadorEntity coordinador) {
        String sql = "INSERT INTO coordinador (rutCoordinador, nombreCoordinador, apellidoCoordinador, contrasena, idInstitucion) " +
                "VALUES (:rutCoordinador, :nombreCoordinador, :apellidoCoordinador, :contrasena, :idInstitucion)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("rutCoordinador", coordinador.getRutCoordinador())
                    .addParameter("nombreCoordinador", coordinador.getNombreCoordinador())
                    .addParameter("apellidoCoordinador", coordinador.getApellidoCoordinador())
                    .addParameter("contrasena", coordinador.getContrasena())
                    .addParameter("idInstitucion", coordinador.getIdInstitucion())
                    .executeUpdate()
                    .getKey();
            coordinador.setIdCoordinador(id);
            return coordinador;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<CoordinadorEntity> obtenerTodos(){
        String sql = "SELECT * FROM coordinador";
        try (Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(CoordinadorEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public CoordinadorEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idCoordinador", id)
                    .executeAndFetchFirst(CoordinadorEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizar(CoordinadorEntity coordinador) {
        String sql = "UPDATE coordinador SET rutCoordinador = :rutCoordinador, nombreCoordinador = :nombreCoordinador, " +
                "apellidoCoordinador = :apellidoCoordinador, contrasena = :contrasena, idInstitucion = :idInstitucion " +
                "WHERE idCoordinador = :idCoordinador";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idCoordinador", coordinador.getIdCoordinador())
                    .addParameter("rutCoordinador", coordinador.getRutCoordinador())
                    .addParameter("nombreCoordinador", coordinador.getNombreCoordinador())
                    .addParameter("apellidoCoordinador", coordinador.getApellidoCoordinador())
                    .addParameter("contrasena", coordinador.getContrasena())
                    .addParameter("idInstitucion", coordinador.getIdInstitucion())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(long id) {
        String sql = "DELETE FROM coordinador WHERE idCoordinador = :idCoordinador";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idCoordinador", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
