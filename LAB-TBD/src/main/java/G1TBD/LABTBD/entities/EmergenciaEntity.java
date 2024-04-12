package G1TBD.LABTBD.entities;

public class EmergenciaEntity {


    private Integer id;
    private boolean estadoEmergencia;
    private String tituloEmergencia;
    private String descripcionEmergencia;

    public EmergenciaEntity() {
    }
    public EmergenciaEntity(boolean estadoEmergencia, String tituloEmergencia, String descripcionEmergencia ) {
        this.estadoEmergencia = estadoEmergencia;
        this.tituloEmergencia = tituloEmergencia;
        this.descripcionEmergencia = descripcionEmergencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isEstadoEmergencia() {
        return estadoEmergencia;
    }

    public void setEstadoEmergencia(boolean estadoEmergencia) {
        this.estadoEmergencia = estadoEmergencia;
    }

    public String getTituloEmergencia() {
        return tituloEmergencia;
    }

    public void setTituloEmergencia(String tituloEmergencia) {
        this.tituloEmergencia = tituloEmergencia;
    }

    public String getDescripcionEmergencia() {
        return descripcionEmergencia;
    }

    public void setDescripcionEmergencia(String descripcionEmergencia) {
        this.descripcionEmergencia = descripcionEmergencia;
    }
}
