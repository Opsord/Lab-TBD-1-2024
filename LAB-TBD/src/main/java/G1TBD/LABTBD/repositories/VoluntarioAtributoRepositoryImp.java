package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.VoluntarioAtributoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class VoluntarioAtributoRepositoryImp implements VoluntarioAtributoRepository{

    private static final Logger logger = Logger.getLogger(VoluntarioAtributoRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioAtributoEntity crear(VoluntarioAtributoEntity voluntarioAtributo) {
        String sql = "INSERT INTO Voluntario_Atributo (idVoluntarioAtributo, rutVoluntario, idAtributo) " +
                "VALUES (:idVoluntarioAtributo, :idVoluntario, :idAtributo)";

        String idVoluntarioAtributo = java.util.UUID.randomUUID().toString();

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", idVoluntarioAtributo)
                    .addParameter("rutVoluntario", voluntarioAtributo.getRutVoluntario())
                    .addParameter("idAtributo", voluntarioAtributo.getIdAtributo())
                    .executeUpdate();

            voluntarioAtributo.setIdVoluntarioAtributo(java.util.UUID.fromString(idVoluntarioAtributo));

            return voluntarioAtributo;
        } catch (Exception e) {
            logger.severe("Error al crear voluntarioAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioAtributoEntity> obtenerTodos() {
        String sql = "SELECT * FROM Voluntario_Atributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(VoluntarioAtributoEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los voluntarioAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioAtributoEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM Voluntario_Atributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", id)
                    .executeAndFetchFirst(VoluntarioAtributoEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener voluntarioAtributo por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizar(VoluntarioAtributoEntity voluntarioAtributo) {
        String sql = "UPDATE Voluntario_Atributo SET idVoluntarioAtributo = :idVoluntarioAtributo, rutVoluntario = :rutVoluntario, idAtributo = :idAtributo" +
                "WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", voluntarioAtributo.getIdVoluntarioAtributo())
                    .addParameter("rutVoluntario", voluntarioAtributo.getRutVoluntario())
                    .addParameter("idAtributo", voluntarioAtributo.getIdAtributo())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar voluntarioAtributo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(long id) {
        String sql = "DELETE FROM Voluntario_Atributo WHERE idVoluntarioAtributo = :idVoluntarioAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idVoluntarioAtributo", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar voluntarioAtributo: " + e.getMessage());
            return false;
        }
    }
}
