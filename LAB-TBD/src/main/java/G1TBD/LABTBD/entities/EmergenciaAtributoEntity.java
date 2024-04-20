package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class EmergenciaAtributoEntity {

    private UUID idEmergenciaAtributo;
    private UUID idEmergencia;
    private UUID idAtributo;
    private boolean compatibilidad;

}
