package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.RankingEntity;
import G1TBD.LABTBD.services.RankingService;
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
    private RankingService rankingService;

    String homeLinkRedirect = "redirect:/ranking";

    @PostMapping("/crearRanking")
    public String crear(RankingEntity ranking) {
        rankingService.crear(ranking);
        return homeLinkRedirect;
    }

    @GetMapping("/obtenerTodosLosRanking")
    public List<RankingEntity> obtenerTodos() {
        return rankingService.obtenerTodos();
    }

    @GetMapping("/obtenerRankingPorId")
    public RankingEntity obtenerPorId(long id) {
        return rankingService.obtenerPorId(id);
    }

    @PostMapping("/actualizarRanking")
    public boolean actualizar(RankingEntity ranking) {
        return rankingService.actualizar(ranking);
    }

    @PostMapping("/eliminarRanking")
    public boolean eliminar(long id) {
        return rankingService.eliminar(id);
    }
}
