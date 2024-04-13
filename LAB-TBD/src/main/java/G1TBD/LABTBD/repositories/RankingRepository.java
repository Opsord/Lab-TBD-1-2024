package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {

    public void create(RankingEntity ranking);

    public List<RankingEntity> conseguirTodos();

    public RankingEntity conseguirPorId(long id);

    public void update(RankingEntity ranking);

    public void delete(long id);
}
