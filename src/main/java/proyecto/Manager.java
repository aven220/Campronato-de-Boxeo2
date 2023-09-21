package proyecto;

public class Manager {

    private String nombre,apellido,telefono,correo,identificacion;
    private int edad,idBoxeador;

    public Manager() {
    }

    public Manager(String nombre, String apellido, String telefono, String correo, String identificacion, int idBoxeador, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.identificacion = identificacion;
        this.idBoxeador = idBoxeador;
        this.edad = edad;
    }

    public int getIdBoxeador() {
        return idBoxeador;
    }

    public void setIdBoxeador(int idBoxeador) {
        this.idBoxeador = idBoxeador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
