package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class VoluntarioAtributoEntity {

    private long idVoluntarioAtributo;
    private long idVoluntario;
    private long idAtributo;

}
