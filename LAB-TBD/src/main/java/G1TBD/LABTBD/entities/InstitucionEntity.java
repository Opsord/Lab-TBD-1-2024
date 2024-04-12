package G1TBD.LABTBD.entities;

public class InstitucionEntity {
    private Integer id;
    private String nombreInstitucion;

    public InstitucionEntity(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }
}
