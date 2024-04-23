package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    private long idTask;
    private long idEmergency;
    private String type;
    private String description;
    private boolean state;

}
