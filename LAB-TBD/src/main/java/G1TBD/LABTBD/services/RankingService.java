package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.RankingEntity;
import G1TBD.LABTBD.entities.TareaEntity;
import G1TBD.LABTBD.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public RankingEntity crear(RankingEntity ranking) {
        return rankingRepository.crear(ranking);
    }

    public List<RankingEntity> obtenerTodos() {
        return rankingRepository.obtenerTodos();
    }

    public RankingEntity obtenerPorId(long id) {
        return rankingRepository.obtenerPorId(id);
    }

    public List<RankingEntity> obtenerPorIdTarea(long id) {
        return rankingRepository.obtenerRankingPorIdTarea(id);
    }



    public boolean actualizar(RankingEntity ranking) {
        return rankingRepository.actualizar(ranking);
    }

    public boolean eliminar(long id) {
        return rankingRepository.eliminar(id);
    }
}
