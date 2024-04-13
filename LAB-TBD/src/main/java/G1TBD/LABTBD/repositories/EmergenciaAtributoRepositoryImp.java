package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergenciaAtributoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaAtributoRepositoryImp implements EmergenciaAtributoRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public void create(EmergenciaAtributoEntity emergenciaAtributo) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO EmergenciaAtributo (idEmergencia, idHabilidad, compatibilidad) " +
                    "VALUES (:idEmergencia, :idHabilidad, :compatibilidad)")
                    .addParameter("idEmergencia", emergenciaAtributo.getIdEmergencia())
                    .addParameter("idHabilidad", emergenciaAtributo.getIdAtributo())
                    .addParameter("compatibilidad", emergenciaAtributo.isCompatibilidad())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<EmergenciaAtributoEntity> conseguirTodos() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM EmergenciaAtributo")
                    .executeAndFetch(EmergenciaAtributoEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public EmergenciaAtributoEntity obtenerPorId(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM EmergenciaAtributo WHERE idAtributo = :idAtributo")
                    .addParameter("idAtributo", id)
                    .executeAndFetchFirst(EmergenciaAtributoEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
public void update(EmergenciaAtributoEntity emergenciaAtributo) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE EmergenciaAtributo SET idEmergencia = :idEmergencia, idHabilidad = :idHabilidad, compatibilidad = :compatibilidad WHERE idAtributo = :idAtributo")
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
    public void delete(EmergenciaAtributoEntity emergenciaAtributo){
        String sql = "DELETE FROM EmergenciaAtributo WHERE idAtributo = :idAtributo";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idAtributo", emergenciaAtributo.getIdAtributo())
                    .executeUpdate();
        }
    }
}
