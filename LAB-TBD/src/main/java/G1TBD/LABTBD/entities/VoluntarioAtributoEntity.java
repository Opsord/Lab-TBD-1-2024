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
    private Integer id;
    private Integer idVoluntario;
    private Integer idAtributo;

    public VoluntarioAtributoEntity(Integer idVoluntario, Integer idAtributo) {
        this.idVoluntario = idVoluntario;
        this.idAtributo = idAtributo;
    }
}
