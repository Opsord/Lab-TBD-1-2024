package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {

    RankingEntity create(RankingEntity ranking);

    List<RankingEntity> getAll();

    RankingEntity getById(long id);

    boolean update(RankingEntity ranking);

    boolean delete(long id);

    public List<RankingEntity> getByTaskId(long idTask);
}
