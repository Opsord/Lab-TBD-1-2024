package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAttributeEntity {

    private long idEmergencyAttribute;
    private long idEmergency;
    private long idAttribute;
    private boolean compatibility;

}
