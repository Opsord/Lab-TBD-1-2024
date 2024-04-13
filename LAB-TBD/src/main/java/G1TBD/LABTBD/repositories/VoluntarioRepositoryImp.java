package G1TBD.LABTBD.repositories;
import G1TBD.LABTBD.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
@Repository
public class VoluntarioRepositoryImp implements  VoluntarioRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioEntity crearVoluntario(VoluntarioEntity voluntario) {
        String sql =
                "INSERT INTO Voluntario (rutVoluntario, nombreVoluntario, apellidoVoluntario, edadVoluntario, sexoVoluntario, contrasena, disponibilidad) " +
                        "VALUES (:rutVoluntario, :nombreVoluntario, :apellidoVoluntario, :edadVoluntario, :sexoVoluntario, :contrasena, :disponibilidad)";

        try (Connection con = sql2o.open()) {
            long id = (long) con.createQuery(sql)
                    .addParameter("rutVoluntario", voluntario.getRutVoluntario())
                    .addParameter("nombreVoluntario", voluntario.getNombreVoluntario())
                    .addParameter("apellidoVoluntario", voluntario.getApellidoVoluntario())
                    .addParameter("edadVoluntario", voluntario.getContrasena())
                    .addParameter("sexoVoluntario", voluntario.isSexoVoluntario())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("disponibilidad", voluntario.isDisponibilidad())
                    .executeUpdate()
                    .getKey();
            voluntario.setIdVoluntario(id);
            return voluntario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity obtenerVoluntarioPorId(long id) {
        String sql = "SELECT * FROM Voluntario WHERE idVoluntario = :idVoluntario";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idvoluntario", id)
                    .executeAndFetchFirst(VoluntarioEntity.class);
        }
    }

    @Override
    public void actualizarVoluntario(VoluntarioEntity voluntario) {
        String sql =
                "UPDATE Voluntario SET rutVoluntario = :rutVoluntario, nombreVoluntario = :nombreVoluntario, apellidoVoluntario = :apellidoVoluntario, " +
                        "edadVoluntario = :edadVoluntario, sexoVoluntario = :sexoVoluntario, contrasena = :contrasena, disponibilidad = :disponibilidad " +
                        "WHERE idVoluntario = :idVoluntario";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idvoluntario", voluntario.getIdVoluntario())
                    .addParameter("rutVoluntario", voluntario.getRutVoluntario())
                    .addParameter("nombreVoluntario", voluntario.getNombreVoluntario())
                    .addParameter("apellidoVoluntario", voluntario.getApellidoVoluntario())
                    .addParameter("edadVoluntario", voluntario.getContrasena())
                    .addParameter("sexoVoluntario", voluntario.isSexoVoluntario())
                    .addParameter("contrasena", voluntario.getContrasena())
                    .addParameter("disponibilidad", voluntario.isDisponibilidad())
                    .executeUpdate();
        }
    }

    @Override
    public void eliminarVoluntario(long id) {
        String sql = "DELETE FROM Voluntario WHERE idVoluntario = :idVoluntario";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idvoluntario", id)
                    .executeUpdate();
        }
    }
}
