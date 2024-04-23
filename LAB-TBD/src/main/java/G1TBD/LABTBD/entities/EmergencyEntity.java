package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyEntity {

    private long idEmergency;
    private boolean status;
    private String title;
    private String description;
    private long idCoordinator;

}
