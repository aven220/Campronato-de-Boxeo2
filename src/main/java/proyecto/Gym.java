package proyecto;

import java.util.ArrayList;
import java.util.List;

public class Gym {

    private String nombre, nit, ciudad;
    private int representantes;
    private List<Boxeador> boxeadores;
    private List<Manager> managers;

    public Gym() {
        this.boxeadores = new ArrayList<>();
        this.managers = new ArrayList<>();
    }

    public void agregarBoxeador(Boxeador boxeador) {
        boxeadores.add(boxeador);
    }

    public void agregarManager(Manager manager) {
        managers.add(manager);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(int representantes) {
        this.representantes = representantes;
    }

    public List<Boxeador> getBoxeadores() {
        return boxeadores;
    }

    public void setBoxeadores(List<Boxeador> boxeadores) {
        this.boxeadores = boxeadores;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }
    
}
