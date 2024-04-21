package G1TBD.LABTBD.repositories;


import G1TBD.LABTBD.entities.AtributoEntity;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Repository
public class AtributoRepositoryImp implements AtributoRepository {

    private static final Logger  logger = Logger.getLogger(AtributoRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public AtributoEntity crear(AtributoEntity atributo) {
        String sql = "INSERT INTO Atributo (atributo) " +
                "VALUES (:atributo)";


        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("atributo", atributo.getAtributo())
                    .executeUpdate()
                    .getKey();

            atributo.setIdAtributo(id);
            return atributo;

        } catch (Exception e) {
            logger.severe("Error al crear atributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<AtributoEntity> obtenerTodos() {
        String sql = "SELECT * FROM Atributo";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(AtributoEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los atributos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public AtributoEntity obtenerPorId(long id) {
        String sql = "SELECT * FROM Atributo WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeAndFetchFirst(AtributoEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener atributo por id: " + e.getMessage());
            return null;
        }
    }

//    @Override
//    public AtributoEntity obtenerPorTipoAtributo(String tipoAtributo) {
//        String sql = "SELECT * FROM Atributo WHERE atributo = :atributo";
//
//        try (Connection con = sql2o.open()) {
//            return con.createQuery(sql)
//                    .addParameter("atributo", atributo)
//                    .executeAndFetchFirst(AtributoEntity.class);
//        }
//    }

    @Override
    public boolean actualizar(AtributoEntity atributo) {
        String sql = "UPDATE Atributo SET atributo = :atributo " +
                "WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idAtributo", atributo.getIdAtributo())
                    .addParameter("atributo", atributo.getAtributo())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar atributo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(long id) {
        String sql = "DELETE FROM Atributo WHERE idAtributo = :idAtributo";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idAtributo", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar atributo: " + e.getMessage());
            return false;
        }
    }
}

