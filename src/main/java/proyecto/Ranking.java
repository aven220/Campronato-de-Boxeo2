package proyecto;


public class Ranking {
   String nombre,identificacion,categoria,gym;
   double puntuacion;
   int puesto;

    public Ranking() {
    }

    public Ranking(String nombre, String identificacion, double puntuacion, int puesto) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.puntuacion = puntuacion;
        this.puesto = puesto;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }
 
   
}
