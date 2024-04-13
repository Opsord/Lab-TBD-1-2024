package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {

    public void crearRanking(RankingEntity ranking);

    public List<RankingEntity> obtenerTodosLosRanking();

    public RankingEntity obtenerRankingPorId(long id);

    public void actualizarRanking(RankingEntity ranking);

    public void eliminarRanking(long id);
}
