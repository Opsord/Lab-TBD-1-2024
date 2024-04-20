package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class InstitucionEntity {

    private UUID idInstitucion;
    private String nombreInstitucion;

}
