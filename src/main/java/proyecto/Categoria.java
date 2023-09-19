package proyecto;

public class Categoria {

    private String nombre;
    private Double pesoMax,pesoMin;
    private int numIntegrantes;

    public Categoria() {
    }

    public Categoria(String nombre, Double pesoMax, Double pesoMin, int numIntegrantes) {
        this.nombre = nombre;
        this.pesoMax = pesoMax;
        this.pesoMin = pesoMin;
        this.numIntegrantes = numIntegrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(Double pesoMax) {
        this.pesoMax = pesoMax;
    }

    public Double getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(Double pesoMin) {
        this.pesoMin = pesoMin;
    }

    public int getNumIntegrantes() {
        return numIntegrantes;
    }

    public void setNumIntegrantes(int numIntegrantes) {
        this.numIntegrantes = numIntegrantes;
    }
    
}
