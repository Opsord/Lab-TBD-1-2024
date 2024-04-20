package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RankingEntity {

    private UUID idRanking;
    private String rutVoluntario;
    private UUID idTarea;
    private Integer valorRanking;

}
