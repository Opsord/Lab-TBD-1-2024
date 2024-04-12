package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
