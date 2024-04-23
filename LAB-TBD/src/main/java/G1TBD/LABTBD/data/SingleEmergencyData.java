package G1TBD.LABTBD.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleEmergencyData {
    private String tituloEmergencia;
    private int cantidadVoluntarios;
    private int cantidadTareas;
}
