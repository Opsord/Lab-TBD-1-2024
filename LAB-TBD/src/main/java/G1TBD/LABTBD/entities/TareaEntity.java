package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class TareaEntity {

    private UUID idTarea;
    private UUID idEmergencia;
    private String tipoTarea;
    private String descripcion;
    private boolean estado;

}
