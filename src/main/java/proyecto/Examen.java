
package proyecto;

import java.util.Date;


public class Examen {

private double pesaje;
private boolean antidoping;
private Date fechaExamen;

    public Examen() {
    }

    public Examen(double pesaje, boolean antidoping, Date fechaExamen) {
        this.pesaje = pesaje;
        this.antidoping = antidoping;
        this.fechaExamen = fechaExamen;
    }

    

    public double getPesaje() {
        return pesaje;
    }

    public void setPesaje(double pesaje) {
        this.pesaje = pesaje;
    }

    public boolean isAntidoping() {
        return antidoping;
    }

    public void setAntidoping(boolean antidoping) {
        this.antidoping = antidoping;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }
    
    
}
