package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RankingEntity {
    private Integer id;
    private Integer idVoluntario;
    private Integer idTarea;
    private Integer valorRanking;
    public RankingEntity(Integer idVoluntario, Integer idTarea, Integer valorRanking) {
        this.idVoluntario = idVoluntario;
        this.idTarea = idTarea;
        this.valorRanking = valorRanking;
    }
}
