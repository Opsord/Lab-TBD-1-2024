package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.RankingEntity;
import G1TBD.LABTBD.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080/ranking")
public class RankingController {
    @Autowired
    private RankingRepository rankingRepository;

    @PostMapping("/crearRanking")
    public String crearRanking(RankingEntity ranking) {
        rankingRepository.crear(ranking);
        return "redirect:/ranking"; // Ajusta según la ruta deseada
    }

    @GetMapping("/obtenerTodosLosRanking")
    public List<RankingEntity> obtenerTodosLosRanking() {
        return rankingRepository.obtenerTodos();
    }

    @GetMapping("/obtenerRankingPorId")
    public RankingEntity obtenerRankingPorId(long id) {
        return rankingRepository.obtenerPorId(id);
    }

    @PostMapping("/actualizarRanking")
    public boolean actualizarRanking(RankingEntity ranking) {
        return rankingRepository.actualizar(ranking);
    }

    @PostMapping("/eliminarRanking")
    public boolean eliminarRanking(long id) {
        return rankingRepository.eliminar(id);
    }
}
