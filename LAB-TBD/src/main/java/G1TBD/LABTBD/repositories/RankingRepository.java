package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {

    RankingEntity crear(RankingEntity ranking);

    List<RankingEntity> obtenerTodos();

    RankingEntity obtenerPorId(long id);

    boolean actualizar(RankingEntity ranking);

    boolean eliminar(long id);
    public List<RankingEntity> obtenerRankingPorIdTarea(long idTarea);
}
