package proyecto;

public class Boxeador {
    
 private String nombre,apellido,telefono,correo,identificacion,gym,categoria,manager;
 private int edad,titulos,ko,empates,rank,id;
 private double peso,altura;

    public Boxeador() {
    }

    public Boxeador(String nombre, String apellido, String telefono, String correo, String identificacion, String gym, String categoria, String manager, int edad, int titulos, int ko, int empates, int rank, int id, double peso, double altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.identificacion = identificacion;
        this.gym = gym;
        this.categoria = categoria;
        this.manager = manager;
        this.edad = edad;
        this.titulos = titulos;
        this.ko = ko;
        this.empates = empates;
        this.rank = rank;
        this.id = id;
        this.peso = peso;
        this.altura = altura;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }




    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTitulos() {
        return titulos;
    }

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }

    public int getKo() {
        return ko;
    }

    public void setKo(int ko) {
        this.ko = ko;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }
    
    
 
   }

