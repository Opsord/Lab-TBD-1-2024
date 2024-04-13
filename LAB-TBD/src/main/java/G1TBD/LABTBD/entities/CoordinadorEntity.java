package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoordinadorEntity {
    private long idCoordinador;
    private String rutCoordinador;
    private String nombreCoordinador;
    private String apellidoCoordinador;
    private String contrasena;
    private long idInstitucion;

    public CoordinadorEntity(String rutCoordinador, String nombreCoordinador, String apellidoCoordinador, String contrasena, long idInstitucion) {
        this.rutCoordinador = rutCoordinador;
        this.nombreCoordinador = nombreCoordinador;
        this.apellidoCoordinador = apellidoCoordinador;
        this.contrasena = contrasena;
        this.idInstitucion = idInstitucion;
    }
}
