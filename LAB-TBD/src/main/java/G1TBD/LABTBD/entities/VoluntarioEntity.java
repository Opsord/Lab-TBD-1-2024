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
    private String contrasena;
    private boolean disponibilidad;

    public VoluntarioEntity(String rutVoluntario, String nombreVoluntario, String apellidoVoluntario, int edadVoluntario, boolean sexoVoluntario, String contrasena, boolean disponibilidad) {
        this.rutVoluntario = rutVoluntario;
        this.nombreVoluntario = nombreVoluntario;
        this.apellidoVoluntario = apellidoVoluntario;
        this.edadVoluntario = edadVoluntario;
        this.sexoVoluntario = sexoVoluntario;
        this.contrasena = contrasena;
        this.disponibilidad = disponibilidad;
    }
}
