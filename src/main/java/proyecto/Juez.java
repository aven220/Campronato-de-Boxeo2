package proyecto;


public class Juez {

    private String nombre,apellido,identificacion,usuario,contrasena;
    private int edad,numPeleas,id;

    public Juez() {
    }

    public Juez(String nombre, String apellido, String identificacion, String usuario, String contrasena, int edad, int numPeleas, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.numPeleas = numPeleas;
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumPeleas() {
        return numPeleas;
    }

    public void setNumPeleas(int numPeleas) {
        this.numPeleas = numPeleas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
