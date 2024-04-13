package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp {
    @Autowired
    private Sql2o sql2o;

    // Crear un registro en el ranking
    public void create(RankingEntity ranking) {
        String sql =
                "INSERT INTO ranking (idVoluntario, idTarea, valorRanking) " +
                        "VALUES (:idVoluntario, :idTarea, :valorRanking)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idVoluntario", ranking.getIdVoluntario())
                    .addParameter("idTarea", ranking.getIdTarea())
                    .addParameter("valorRanking", ranking.getValorRanking())
                    .executeUpdate();
            con.commit();
        }
    }

    // Conseguir todos los registros de ranking
    public List<RankingEntity> conseguirTodos() {
        String sql = "SELECT * FROM ranking";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(RankingEntity.class);
        }
    }

    // Conseguir un registro de ranking por su ID
    public RankingEntity conseguirPorId(long id) {
        String sql = "SELECT * FROM ranking WHERE idRanking = :idRanking";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeAndFetchFirst(RankingEntity.class);
        }
    }

    // Actualizar un registro de ranking
    public void update(RankingEntity ranking) {
        String sql =
                "UPDATE ranking SET idVoluntario = :idVoluntario, idTarea = :idTarea, valorRanking = :valorRanking " +
                        "WHERE idRanking = :idRanking";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idRanking", ranking.getIdRanking())
                    .addParameter("idVoluntario", ranking.getIdVoluntario())
                    .addParameter("idTarea", ranking.getIdTarea())
                    .addParameter("valorRanking", ranking.getValorRanking())
                    .executeUpdate();
            con.commit();
        }
    }

    // Eliminar un registro de ranking
    public void delete(long id) {
        String sql = "DELETE FROM ranking WHERE idRanking = :idRanking";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeUpdate();
            con.commit();
        }
    }
}