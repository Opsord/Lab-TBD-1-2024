package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.RankingEntity;
import G1TBD.LABTBD.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public RankingEntity create(RankingEntity ranking) {
        return rankingRepository.create(ranking);
    }

    public List<RankingEntity> getAll() {
        return rankingRepository.getAll();
    }

    public RankingEntity getById(long id) {
        return rankingRepository.getById(id);
    }

    public List<RankingEntity> getByTaskId(long id) {
        return rankingRepository.getByTaskId(id);
    }

    public boolean update(RankingEntity ranking) {
        return rankingRepository.update(ranking);
    }

    public boolean delete(long id) {
        return rankingRepository.delete(id);
    }
}
