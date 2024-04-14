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

    public RankingEntity crearRanking(RankingEntity ranking) {
        return rankingRepository.crearRanking(ranking);
    }

    public List<RankingEntity> obtenerTodosLosRankings() {
        return rankingRepository.obtenerTodosLosRanking();
    }

    public RankingEntity obtenerRankingPorId(long id) {
        return rankingRepository.obtenerRankingPorId(id);
    }

    public boolean actualizarRanking(RankingEntity ranking) {
        return rankingRepository.actualizarRanking(ranking);
    }

    public boolean eliminarRanking(long id) {
        return rankingRepository.eliminarRanking(id);
    }
}
