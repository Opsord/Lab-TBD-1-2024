package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VoluntarioEntity {
    private int idVoluntario;
    private String rutVoluntario;
    private String nombreVoluntario;
    private String apellidoVoluntario;
    private int edadVoluntario;
    private boolean sexoVoluntario;
    private String contrasena;
    private boolean disponibilidad;


}
