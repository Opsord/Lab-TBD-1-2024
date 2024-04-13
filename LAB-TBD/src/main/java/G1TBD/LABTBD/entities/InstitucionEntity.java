package G1TBD.LABTBD.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstitucionEntity {
    private long idInstitucion;
    private String nombreInstitucion;

    public InstitucionEntity(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }
}
