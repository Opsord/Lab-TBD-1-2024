package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {

    RankingEntity crearRanking(RankingEntity ranking);

    List<RankingEntity> obtenerTodosLosRanking();

    RankingEntity obtenerRankingPorId(long id);

    boolean actualizarRanking(RankingEntity ranking);

    boolean eliminarRanking(long id);
}
