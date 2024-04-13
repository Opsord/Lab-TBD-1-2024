package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmergenciaEntity {


    private long idEmergencia;
    private boolean estadoEmergencia;
    private String tituloEmergencia;
    private String descripcionEmergencia;

    public EmergenciaEntity(boolean estadoEmergencia, String tituloEmergencia, String descripcionEmergencia ) {
        this.estadoEmergencia = estadoEmergencia;
        this.tituloEmergencia = tituloEmergencia;
        this.descripcionEmergencia = descripcionEmergencia;
    }

}
