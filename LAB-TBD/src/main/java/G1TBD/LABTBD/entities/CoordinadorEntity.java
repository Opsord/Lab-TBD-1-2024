package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoordinadorEntity {

    private String rutCoordinador;
    private String nombreCoordinador;
    private String apellidoCoordinador;
    private String email;
    private String contrasena;
    private long idInstitucion;

}
