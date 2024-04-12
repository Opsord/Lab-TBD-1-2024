package G1TBD.LABTBD.entities;

public class TareaEntity {

    private Integer id;
    private Integer idEmergencia;
    private String tipoTarea;
    private String descripcion;
    private boolean estado;

    public TareaEntity(Integer idEmergencia, String tipoTarea, String descripcion, boolean estado) {
        this.idEmergencia = idEmergencia;
        this.tipoTarea = tipoTarea;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(Integer idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
