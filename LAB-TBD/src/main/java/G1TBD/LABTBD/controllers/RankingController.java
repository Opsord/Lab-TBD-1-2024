package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.RankingEntity;
import G1TBD.LABTBD.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
@CrossOrigin(origins = "http://localhost:8090/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    String homeLinkRedirect = "redirect:/ranking";

    @PostMapping("/crearRanking")
    public String crear(@RequestBody RankingEntity ranking) {
        rankingService.crear(ranking);
        return homeLinkRedirect;
    }

    @GetMapping("/obtenerTodosLosRanking")
    public List<RankingEntity> obtenerTodos() {
        return rankingService.obtenerTodos();
    }

    @GetMapping("/obtenerRankingPorId/{id}")
    public RankingEntity obtenerPorId(@PathVariable long id) {
        return rankingService.obtenerPorId(id);
    }

    @PutMapping("/actualizarRanking")
    public boolean actualizar(@RequestBody RankingEntity ranking) {
        return rankingService.actualizar(ranking);
    }

    @DeleteMapping("/eliminarRanking/{id}")
    public boolean eliminar(@PathVariable long id) {
        return rankingService.eliminar(id);
    }
}
