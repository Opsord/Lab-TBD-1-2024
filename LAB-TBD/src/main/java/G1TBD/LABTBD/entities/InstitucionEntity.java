package G1TBD.LABTBD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InstitucionEntity {
    private Integer idInstitucion;
    private String nombreInstitucion;

    public InstitucionEntity(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }
}
