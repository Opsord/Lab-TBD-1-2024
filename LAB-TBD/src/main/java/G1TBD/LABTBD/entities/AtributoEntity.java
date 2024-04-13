package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtributoEntity {
    private long idAtributo;
    private String atributo;

    public AtributoEntity(String atributo) {
        this.atributo = atributo;
    }
}
