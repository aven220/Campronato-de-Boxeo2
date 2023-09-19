package Operaciones;

import DAO.TablaBoxeadores;
import DAO.usuarioDao;
import GUI.Inicio;
import GUI.Login;
import GUI.NewBoxeador;
import javax.swing.JOptionPane;
import proyecto.Boxeador;

public class Campeonato {

    public static void main(String[] args) {
        
        //TablaBoxeadores ss = new TablaBoxeadores();
      
        Login lol = new Login();
        lol.setVisible(true);
       /* int menu = 0;
        
        do {
            try {
                menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese opcion: \n"
                        + "1. ELIMINAR BOXEADOR\n"
                        + "2. SUMAR\n"
                        + "3. PROMEDIO\n"
                        + "4. MAYOR\n"
                        + "5. SALIR\n"
                        + "6. NUEVO BOXEADOR", "BOXEADOR", 3));

                switch (menu) {
                    case 1:
                        usuarioDao dao1 = new usuarioDao();
                        int idBoxeador = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese id", "Primer ventana", 3));
                        dao1.eliminar(idBoxeador);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opcion incorrecta: " + e.getMessage());
            }
        } while (menu != 5); */
    }
}
