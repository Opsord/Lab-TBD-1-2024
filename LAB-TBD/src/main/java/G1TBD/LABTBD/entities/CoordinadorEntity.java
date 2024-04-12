package G1TBD.LABTBD.entities;

public class CoordinadorEntity {
    private Integer id;
    private String rutCoordinador;
    private String nombreCoordinador;
    private String apellidoCoordinador;
    private String contraseña;
    private Integer idInstitucion;


    public CoordinadorEntity(String rutCoordinador, String nombreCoordinador, String apellidoCoordinador, String contraseña, Integer idInstitucion) {
        this.rutCoordinador = rutCoordinador;
        this.nombreCoordinador = nombreCoordinador;
        this.apellidoCoordinador = apellidoCoordinador;
        this.contraseña = contraseña;
        this.idInstitucion = idInstitucion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRutCoordinador() {
        return rutCoordinador;
    }

    public void setRutCoordinador(String rutCoordinador) {
        this.rutCoordinador = rutCoordinador;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }

    public String getApellidoCoordinador() {
        return apellidoCoordinador;
    }

    public void setApellidoCoordinador(String apellidoCoordinador) {
        this.apellidoCoordinador = apellidoCoordinador;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }
}
