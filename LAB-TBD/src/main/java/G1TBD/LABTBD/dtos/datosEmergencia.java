package G1TBD.LABTBD.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class datosEmergencia {
    private String tituloEmergencia;
    private int cantidadVoluntarios;
    private int cantidadTareas;
}
