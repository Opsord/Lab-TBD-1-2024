package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VoluntarioAtributoEntity {
    private long idVoluntarioAtributo;
    private long idVoluntario;
    private long idAtributo;

    public VoluntarioAtributoEntity(long idVoluntario, long idAtributo) {
        this.idVoluntario = idVoluntario;
        this.idAtributo = idAtributo;
    }
}
