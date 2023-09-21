
package proyecto;


public class Examen {

private double pesaje;
private boolean antidoping;

    public Examen() {
    }

    public Examen(double pesaje, boolean antidoping) {
        this.pesaje = pesaje;
        this.antidoping = antidoping;
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
}
