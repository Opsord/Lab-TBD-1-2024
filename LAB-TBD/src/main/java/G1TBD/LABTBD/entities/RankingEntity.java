package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RankingEntity {

    private long idRanking;
    private String rutVoluntario;
    private long idTarea;
    private Integer valorRanking;

}
