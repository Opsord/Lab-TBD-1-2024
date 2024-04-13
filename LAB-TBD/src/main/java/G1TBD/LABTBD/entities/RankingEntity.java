package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RankingEntity {
    private long idRanking;
    private long idVoluntario;
    private long idTarea;
    private Integer valorRanking;
    public RankingEntity(long idVoluntario, long idTarea, Integer valorRanking) {
        this.idVoluntario = idVoluntario;
        this.idTarea = idTarea;
        this.valorRanking = valorRanking;
    }
}
