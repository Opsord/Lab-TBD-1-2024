package G1TBD.LABTBD.entities;


public class VoluntarioEntity {
    private int idVoluntario;
    private String rutVoluntario;
    private String nombreVoluntario;
    private String apellidoVoluntario;
    private int edadVoluntario;
    private boolean sexoVoluntario;
    private String contrasena;
    private boolean disponibilidad;

    public VoluntarioEntity() {
    }

    public VoluntarioEntity(int idVoluntario, String rutVoluntario, String nombreVoluntario, String apellidoVoluntario, int edadVoluntario, boolean sexoVoluntario, String contrasena, boolean disponibilidad) {
        this.idVoluntario = idVoluntario;
        this.rutVoluntario = rutVoluntario;
        this.nombreVoluntario = nombreVoluntario;
        this.apellidoVoluntario = apellidoVoluntario;
        this.edadVoluntario = edadVoluntario;
        this.sexoVoluntario = sexoVoluntario;
        this.contrasena = contrasena;
        this.disponibilidad = disponibilidad;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public String getRutVoluntario() {
        return rutVoluntario;
    }

    public String getNombreVoluntario() {
        return nombreVoluntario;
    }

    public String getApellidoVoluntario() {
        return apellidoVoluntario;
    }

    public int getEdadVoluntario() {
        return edadVoluntario;
    }

    public boolean isSexoVoluntario() {
        return sexoVoluntario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }


    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public void setRutVoluntario(String rutVoluntario) {
        this.rutVoluntario = rutVoluntario;
    }

    public void setNombreVoluntario(String nombreVoluntario) {
        this.nombreVoluntario = nombreVoluntario;
    }

    public void setApellidoVoluntario(String apellidoVoluntario) {
        this.apellidoVoluntario = apellidoVoluntario;
    }

    public void setEdadVoluntario(int edadVoluntario) {
        this.edadVoluntario = edadVoluntario;
    }

    public void setSexoVoluntario(boolean sexoVoluntario) {
        this.sexoVoluntario = sexoVoluntario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
