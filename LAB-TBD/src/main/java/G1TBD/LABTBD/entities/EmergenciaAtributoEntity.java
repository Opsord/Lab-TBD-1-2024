package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmergenciaAtributoEntity {
    private Integer id;
    private Integer idEmergencia;
    private Integer idHabilidad;
    private boolean compatibilidad;

    public EmergenciaAtributoEntity(Integer idEmergencia, Integer idHabilidad, boolean compatibilidad) {
        this.idEmergencia = idEmergencia;
        this.idHabilidad = idHabilidad;
        this.compatibilidad = compatibilidad;
    }
}
