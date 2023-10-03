package DAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import proyecto.Boxeador;

public class TablaBoxeadores extends JFrame {

    private JTable table;

    public TablaBoxeadores() {
        super("Boxeadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear una tabla con un modelo de datos vacío
        table = new JTable(new DefaultTableModel());

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        usuarioDao dao = new usuarioDao();
        List<Boxeador> boxeadores = dao.obtenerBoxeadores();

        // Llenar la tabla con los datos
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnIdentifiers(new Object[]{"Nombre", "Apellido", "Correo", "Documento", "Categoría", "Edad", "Títulos", "KO", "Empates", "Rank", "Peso", "Altura"});

        for (Boxeador boxeador : boxeadores) {
            model.addRow(new Object[]{
                boxeador.getNombre(),
                boxeador.getApellido(),
                boxeador.getCorreo(),
                boxeador.getIdentificacion(),
                boxeador.getCategoria(),
                boxeador.getEdad(),
                boxeador.getTitulos(),
                boxeador.getKo(),
                boxeador.getEmpates(),
                boxeador.getRank(),
                boxeador.getPeso(),
                boxeador.getAltura()
            });
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TablaBoxeadores();
        });
    }
}
