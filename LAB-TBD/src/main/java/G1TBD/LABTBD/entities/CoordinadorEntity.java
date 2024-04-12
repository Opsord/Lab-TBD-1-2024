package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CoordinadorEntity {
    private Integer id;
    private String rutCoordinador;
    private String nombreCoordinador;
    private String apellidoCoordinador;
    private String contrasena;
    private Integer idInstitucion;


    public CoordinadorEntity(String rutCoordinador, String nombreCoordinador, String apellidoCoordinador, String contraseña, Integer idInstitucion) {
        this.rutCoordinador = rutCoordinador;
        this.nombreCoordinador = nombreCoordinador;
        this.apellidoCoordinador = apellidoCoordinador;
        this.contrasena = contrasena;
        this.idInstitucion = idInstitucion;
    }
}
