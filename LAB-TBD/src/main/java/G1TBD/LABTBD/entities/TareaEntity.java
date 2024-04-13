package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TareaEntity {

    private long idTarea;
    private long idEmergencia;
    private String tipoTarea;
    private String descripcion;
    private boolean estado;

    public TareaEntity(long idEmergencia, String tipoTarea, String descripcion, boolean estado) {
        this.idEmergencia = idEmergencia;
        this.tipoTarea = tipoTarea;
        this.descripcion = descripcion;
        this.estado = estado;
    }

}
