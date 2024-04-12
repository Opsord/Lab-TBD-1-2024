package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmergenciaEntity {


    private Integer idEmergencia;
    private boolean estadoEmergencia;
    private String tituloEmergencia;
    private String descripcionEmergencia;

    public EmergenciaEntity(boolean estadoEmergencia, String tituloEmergencia, String descripcionEmergencia ) {
        this.estadoEmergencia = estadoEmergencia;
        this.tituloEmergencia = tituloEmergencia;
        this.descripcionEmergencia = descripcionEmergencia;
    }

}
