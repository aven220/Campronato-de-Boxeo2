package proyecto;


public class Ranking {
   String nombre,identificacion,categoria,gym,box;
   double puntuacion;
   int puesto;

    public Ranking() {
    }

    public Ranking(String nombre, String identificacion, String categoria, String gym, String box, double puntuacion, int puesto) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.categoria = categoria;
        this.gym = gym;
        this.box = box;
        this.puntuacion = puntuacion;
        this.puesto = puesto;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
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
