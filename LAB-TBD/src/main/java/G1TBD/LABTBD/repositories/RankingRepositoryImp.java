package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public RankingEntity crearRanking(RankingEntity ranking) {
        String sql = "INSERT INTO ranking (idVoluntario, idTarea, valorRanking) " +
                "VALUES (:idVoluntario, :idTarea, :valorRanking)";

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idVoluntario", ranking.getIdVoluntario())
                    .addParameter("idTarea", ranking.getIdTarea())
                    .addParameter("valorRanking", ranking.getValorRanking())
                    .executeUpdate()
                    .getKey();
            ranking.setIdRanking(id);
            return ranking;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> obtenerTodosLosRanking() {
        String sql = "SELECT * FROM ranking";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public RankingEntity obtenerRankingPorId(long id) {
        String sql = "SELECT * FROM ranking WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean actualizarRanking(RankingEntity ranking) {
        String sql = "UPDATE ranking SET idVoluntario = :idVoluntario, idTarea = :idTarea, valorRanking = :valorRanking " +
                "WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idRanking", ranking.getIdRanking())
                    .addParameter("idVoluntario", ranking.getIdVoluntario())
                    .addParameter("idTarea", ranking.getIdTarea())
                    .addParameter("valorRanking", ranking.getValorRanking())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarRanking(long id) {
        String sql = "DELETE FROM ranking WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}