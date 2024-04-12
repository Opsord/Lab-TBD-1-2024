package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AtributoEntity {
    private long idAtributo;
    private String atributo;

    public AtributoEntity(String atributo) {
        this.atributo = atributo;
    }
}
