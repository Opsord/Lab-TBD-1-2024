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
    private Integer idVoluntarioAtributo;
    private Integer idVoluntario;
    private Integer idAtributo;

    public VoluntarioAtributoEntity( Integer idAtributo) {
        this.idAtributo = idAtributo;
    }
}
