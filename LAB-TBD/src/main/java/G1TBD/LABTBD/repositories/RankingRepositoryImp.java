package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class RankingRepositoryImp implements RankingRepository{

    private static final Logger logger = Logger.getLogger(RankingRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public RankingEntity create(RankingEntity ranking) {
        String sql = "INSERT INTO Ranking (idVoluntario, idTarea, valorRanking) " +
                "VALUES (:idVoluntario, :idTarea, :valorRanking)";

        String idRanking = java.util.UUID.randomUUID().toString();

        try (Connection conn = sql2o.open()) {
            long id = (long) conn.createQuery(sql)
                    .addParameter("idVoluntario", ranking.getIdVolunteer())
                    .addParameter("idTarea", ranking.getIdTask())
                    .addParameter("valorRanking", ranking.getValorRanking())
                    .executeUpdate()
                            .getKey();

            ranking.setIdRanking(id);

            return ranking;
        } catch (Exception e) {
            logger.severe("Error al crear ranking: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> getAll() {
        String sql = "SELECT * FROM Ranking";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los rankings: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public RankingEntity getById(long id) {
        String sql = "SELECT * FROM Ranking WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener ranking por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(RankingEntity ranking) {
        String sql = "UPDATE Ranking SET idVoluntario = :idVoluntario, idTarea = :idTarea, valorRanking = :valorRanking " +
                "WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idRanking", ranking.getIdRanking())
                    .addParameter("idVoluntario", ranking.getIdVolunteer())
                    .addParameter("idTarea", ranking.getIdTask())
                    .addParameter("valorRanking", ranking.getValorRanking())
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar ranking: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM Ranking WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar ranking: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<RankingEntity> getByTaskId(long idTask) {
        String sql = "SELECT * FROM Ranking WHERE idTarea = :idTarea";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idTarea", idTask)
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener ranking por id de emergencia: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
