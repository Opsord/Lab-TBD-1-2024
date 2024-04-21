package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class EmergenciaEntity {

    private UUID idEmergencia;
    private boolean estadoEmergencia;
    private String tituloEmergencia;
    private String descripcionEmergencia;
    private long rutCoordinador;

}
