package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtributoEntity {
    private long idAtributo;
    private String tipoAtributo;

    public AtributoEntity(String tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }
}
