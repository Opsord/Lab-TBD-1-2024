package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VoluntarioEntity {

    private long idVoluntario;
    private String rutVoluntario;
    private String nombreVoluntario;
    private String apellidoVoluntario;
    private int edadVoluntario;
    private boolean sexoVoluntario;
    private String email;
    private String contrasena;
    private boolean disponibilidad;

}
