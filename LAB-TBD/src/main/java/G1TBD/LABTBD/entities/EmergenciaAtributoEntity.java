package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmergenciaAtributoEntity {
    private long idEmergenciaAtributo;
    private long idEmergencia;
    private long idHabilidad;
    private boolean compatibilidad;

    public EmergenciaAtributoEntity(long idEmergencia, long idHabilidad, boolean compatibilidad) {
        this.idEmergencia = idEmergencia;
        this.idHabilidad = idHabilidad;
        this.compatibilidad = compatibilidad;
    }
}
