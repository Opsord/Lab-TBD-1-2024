package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmergenciaAtributoEntity {
    private long idEmergenciaAtributo;
    private long idEmergencia;
    private long idAtributo;
    private boolean compatibilidad;

    public EmergenciaAtributoEntity(long idEmergencia, long idHabilidad, boolean compatibilidad) {
        this.idEmergencia = idEmergencia;
        this.idAtributo = idHabilidad;
        this.compatibilidad = compatibilidad;
    }
}
