package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerAttributeEntity {

    private long idVolunteerAttribute;
    private long idVolunteer;
    private long idAttribute;

}
