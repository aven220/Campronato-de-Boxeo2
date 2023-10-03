package proyecto;

public class Categoria {

    private String nombre, Ranking,Gym,Box,puntuacion,nombreManager;
    private Double pesoMax,pesoMin;
    private int numIntegrantes;

    public Categoria() {
    }

    public Categoria(String nombre, String Ranking, String Gym, String Box, String puntuacion, String nombreManager, Double pesoMax, Double pesoMin, int numIntegrantes) {
        this.nombre = nombre;
        this.Ranking = Ranking;
        this.Gym = Gym;
        this.Box = Box;
        this.puntuacion = puntuacion;
        this.nombreManager = nombreManager;
        this.pesoMax = pesoMax;
        this.pesoMin = pesoMin;
        this.numIntegrantes = numIntegrantes;
    }

    public String getNombreManager() {
        return nombreManager;
    }

    public void setNombreManager(String nombreManager) {
        this.nombreManager = nombreManager;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRanking() {
        return Ranking;
    }

    public void setRanking(String Ranking) {
        this.Ranking = Ranking;
    }

    public String getGym() {
        return Gym;
    }

    public void setGym(String Gym) {
        this.Gym = Gym;
    }

    public String getBox() {
        return Box;
    }

    public void setBox(String Box) {
        this.Box = Box;
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
