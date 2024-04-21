package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class EmergenciaAtributoEntity {

    private long idEmergenciaAtributo;
    private long idEmergencia;
    private long idAtributo;
    private boolean compatibilidad;

}
