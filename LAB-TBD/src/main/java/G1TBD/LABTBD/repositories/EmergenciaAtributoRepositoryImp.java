package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaAtributoRepositoryImp implements EmergenciaAtributoRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmergenciaAtributoEntity crearEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo) {
        String sql = "INSERT INTO EmergenciaAtributo (idEmergencia, idHabilidad, compatibilidad) " +
                "VALUES (:idEmergencia, :idHabilidad, :compatibilidad)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idEmergencia", emergenciaAtributo.getIdEmergencia())
                    .addParameter("idHabilidad", emergenciaAtributo.getIdAtributo())
                    .addParameter("compatibilidad", emergenciaAtributo.isCompatibilidad())
                    .executeUpdate()
                    .getKey();
            emergenciaAtributo.setIdEmergenciaAtributo(id);
            return emergenciaAtributo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergenciaAtributoEntity> obtenerTodosLosEmergenciaAtributo() {
        String sql = "SELECT * FROM EmergenciaAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergenciaAtributoEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public EmergenciaAtributoEntity obtenerEmergenciaAtributoPorId(long id) {
        String sql = "SELECT * FROM EmergenciaAtributo WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeAndFetchFirst(EmergenciaAtributoEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizarEmergenciaAtributo(EmergenciaAtributoEntity emergenciaAtributo) {
        String sql = "UPDATE EmergenciaAtributo SET idEmergencia = :idEmergencia, idHabilidad = :idHabilidad, compatibilidad = :compatibilidad WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergencia", emergenciaAtributo.getIdEmergencia())
                    .addParameter("idHabilidad", emergenciaAtributo.getIdAtributo())
                    .addParameter("compatibilidad", emergenciaAtributo.isCompatibilidad())
                    .addParameter("idAtributo", emergenciaAtributo.getIdAtributo())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarEmergenciaAtributo(long id){
        String sql = "DELETE FROM EmergenciaAtributo WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeUpdate();
        }
    }
}
