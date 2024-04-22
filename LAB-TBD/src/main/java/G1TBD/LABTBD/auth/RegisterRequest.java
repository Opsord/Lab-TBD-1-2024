package G1TBD.LABTBD.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    String email;
    String contrasena;
    String rut;
    String nombre;
    String apellido;

}
