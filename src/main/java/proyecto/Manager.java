package proyecto;

public class Manager {

    private String apellido,telefono,correo,identificacion,nombreManager;
    private int edad,idGym;

    public Manager() {
    }

    public Manager(String apellido, String telefono, String correo, String identificacion, String nombreManager, int edad, int idGym) {
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.identificacion = identificacion;
        this.nombreManager = nombreManager;
        this.edad = edad;
        this.idGym = idGym;
    }

    public String getNombreManager() {
        return nombreManager;
    }

    public void setNombreManager(String nombreManager) {
        this.nombreManager = nombreManager;
    }

    public int getIdGym() {
        return idGym;
    }

    public void setIdGym(int idGym) {
        this.idGym = idGym;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
