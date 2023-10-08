package DAO;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import proyecto.Boxeador;
import proyecto.Categoria;
import proyecto.Gym;
import proyecto.Juez;
import proyecto.Manager;
import proyecto.Ranking;


public class usuarioDao {
    
    public Connection conectar() {

        String baseDeDatos = "bdtorneobox";
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";

        Connection conexion = null;
        try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(conexionUrl, usuario, password);

        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
//////////////////////////////////////////////

    public boolean verificarCredenciales(String usuarioIngresado, char[] contrasenaIngresada) {
        Connection conexion = conectar();
        String contrasenaTexto = new String(contrasenaIngresada);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String consultaSQL = "SELECT * FROM juez WHERE usuario = ? AND contrasena = ?";
            preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, usuarioIngresado);
            preparedStatement.setString(2, contrasenaTexto);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "BIENVENIDO " + usuarioIngresado);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos");
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
/////////////////////////////////////

    public void agregarBox(Boxeador user) {

        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `boxeador` ( `nombreBox`, `apellido`,`documento`, "
                    + "`idCategoria`, `edad`, `peso`, `altura`) "
                    + "VALUES ('" + user.getNombre() + "', '" + user.getApellido() + "'"
                    + ", '" + user.getIdentificacion() + "', '" + user.getCategoria() + "',"
                    + " '" + user.getEdad() + "'"
                    + ", '" + user.getPeso() + "', '" + user.getAltura() + "');";

            Statement sta = conexion.createStatement();
            sta.execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Boxeador> listarBox() {
        List<Boxeador> listaBoxeadores = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT documento, nombreBox, apellido, edad, peso, altura, nombreGym, "
                    + "nombreCategoria FROM boxeador INNER JOIN gym ON boxeador.idGym = gym.idGym "
                    + "INNER JOIN categoria ON boxeador.idCategoria = categoria.idCategoria";

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Boxeador boxeador = new Boxeador();
                boxeador.setIdentificacion(resultSet.getString("documento"));
                boxeador.setNombre(resultSet.getString("nombreBox"));
                boxeador.setApellido(resultSet.getString("apellido"));
                boxeador.setEdad(resultSet.getInt("edad"));
                boxeador.setPeso(resultSet.getDouble("peso"));
                boxeador.setAltura(resultSet.getDouble("altura"));
// ////////////////////////////////////////////////////
                boxeador.setGym(resultSet.getString("nombreGym"));
                boxeador.setCategoria(resultSet.getString("nombreCategoria"));

                listaBoxeadores.add(boxeador);
            }

            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaBoxeadores;
    }

    public List listarGym() {
        List<Gym> listaGym = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM gym";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Gym gym = new Gym();
                gym.setNombre(resultSet.getString("nombreGym"));
                gym.setNit(resultSet.getString("nit"));
                gym.setCiudad(resultSet.getString("ciudad"));
                listaGym.add(gym);
            }

            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGym;
    }


    public List listarCategoria() {
        List<Categoria> listaCategoria = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM categoria";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setNombre(resultSet.getString("nombreCategoria"));
                listaCategoria.add(categoria);
            }
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCategoria;
    }
////////////LISTAR CATEGORIA EN LAS 4 TABLAS..

    public List<Categoria> listarCategoriaTabla() {
        List<Categoria> listaCategoria = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT nombreCategoria, puntuacion, nombreBox, nombreGym, nombreManager FROM categoria "
                    + "INNER JOIN ranking ON categoria.idCategoria = ranking.idCategoria "
                    + "INNER JOIN boxeador ON categoria.idCategoria = boxeador.idCategoria "
                    + "INNER JOIN gym ON boxeador.idGym = gym.idGym "
                    + "INNER JOIN manager ON boxeador.idManager = manager.idManager;";

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setNombre(resultSet.getString("nombreCategoria"));
                categoria.setBox(resultSet.getString("nombreBox"));
                categoria.setGym(resultSet.getString("nombreGym"));
                categoria.setNombreManager(resultSet.getString("nombreManager"));

                listaCategoria.add(categoria);
            }
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCategoria;
    }

    public List listarJuez() {
        List<Juez> listaJuez = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM juez";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Juez juez = new Juez();
                juez.setNombre(resultSet.getString("nombre"));
                juez.setApellido(resultSet.getString("apellido"));
                juez.setIdentificacion(resultSet.getString("identificacion"));
                juez.setEdad(resultSet.getInt("edad"));
                listaJuez.add(juez);
            }

            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaJuez;
    }
//**************************************************************//////////
    public List listarManager() {
        List<Manager> listaManager = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT nombreManager,apellido,telefono,correo,identificacion,edad,"
                    + "nombreGym FROM manager INNER JOIN gym ON manager.idGym = gym.idGym";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Manager manager = new Manager();
                manager.setNombreManager(resultSet.getString("nombreManager"));
                manager.setApellido(resultSet.getString("apellido"));
                manager.setTelefono(resultSet.getString("telefono"));
                manager.setCorreo(resultSet.getString("correo"));
                manager.setIdentificacion(resultSet.getString("identificacion"));
                manager.setEdad(resultSet.getInt("edad"));
                manager.setNombreGym(resultSet.getString("nombreGym"));

                listaManager.add(manager);
            }

            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaManager;
    }
////////////////////////lISTAR rANKING

    public List<Ranking> listarRanking() {
        List<Ranking> listaRanking = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT puntuacion, nombreCategoria, nombreBox, nombreGym FROM ranking "
                    + "INNER JOIN categoria ON ranking.idCategoria = categoria.idCategoria "
                    + "INNER JOIN boxeador ON ranking.idBoxeador = boxeador.idBoxeador "
                    + "INNER JOIN gym ON boxeador.idGym = gym.idGym "
                    + "ORDER BY puntuacion DESC";

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int puesto = 1;  // Inicializar el puesto en 1

            while (resultSet.next()) {
                Ranking ranking = new Ranking();
                ranking.setPuntuacion(resultSet.getDouble("puntuacion"));
                ranking.setPuesto(puesto);
                ranking.setBox(resultSet.getString("nombreBox"));
                ranking.setCategoria(resultSet.getString("nombreCategoria"));
                ranking.setGym(resultSet.getString("nombreGym"));
                listaRanking.add(ranking);
                puesto++;
            }

            resultSet.close();
            statement.close();
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRanking;
    }

    public boolean existeCedula(String numeroCedula) {
        boolean cedulaExiste = false;

        try {
            Connection conexion = conectar();
            String sql = "SELECT COUNT(*) AS total FROM `boxeador` WHERE documento = ?";
            String sql2 = "SELECT COUNT(*) AS total FROM `juez` WHERE identificacion = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, numeroCedula);
            PreparedStatement preparedStatement2 = conexion.prepareStatement(sql2);
            preparedStatement2.setString(1, numeroCedula);

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet2 = preparedStatement2.executeQuery();

            if (resultSet.next()) {
                int totalRegistros = resultSet.getInt("total");
                cedulaExiste = totalRegistros > 0;
            }

            if (resultSet2.next()) {
                int totalRegistros = resultSet2.getInt("total");
                cedulaExiste = totalRegistros > 0;
            }
            preparedStatement.close();
            preparedStatement2.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cedulaExiste;
    }

    public boolean existeNit(String nit) {
        boolean nitExiste = false;

        try {
            Connection conexion = conectar();
            String sql = "SELECT COUNT(*) AS total FROM `gym` WHERE nit = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nit);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int totalRegistros = resultSet.getInt("total");
                nitExiste = totalRegistros > 0;
            }

            preparedStatement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return nitExiste;
    }

    public int obtenerIdGymPorNombre(String nombreGym) {
        try {
            Connection conexion = conectar();
            String consultaSQL = "SELECT idGym FROM gym WHERE nombre = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, nombreGym);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("idGym");
            } else {
                return -1; // Retorna -1 si no se encontró el Gym
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public void agregarManager(Manager user) {
        try {
            Connection conexion = conectar();
            int idGym = 1;

            if (idGym != -1) {
                String sql = "INSERT INTO `manager` (`nombre`, `apellido`, `telefono`, `correo`, `identificacion`, `edad`) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1, user.getNombreManager());
                preparedStatement.setString(2, user.getApellido());
                preparedStatement.setString(3, user.getTelefono());
                preparedStatement.setString(4, user.getCorreo());
                preparedStatement.setString(5, user.getIdentificacion());
                preparedStatement.setInt(6, user.getEdad());
                preparedStatement.setInt(7, idGym);

                preparedStatement.executeUpdate();
            } else {
                System.out.println("No se encontró el Gym correspondiente.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarGym(Gym user) {

        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `gym` (`nombre`, `nit`, `ciudad`) "
                    + "VALUES ('" + user.getNombre() + "', '" + user.getNit() + "', '" + user.getCiudad() + "');";
            Statement sta = conexion.createStatement();
            sta.execute(sql);

        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarCategoria(Categoria user) {

        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `categoria` (`nombre`, `pesoMin`, `pesoMax`) "
                    + "VALUES ('" + user.getNombre() + "', '" + user.getPesoMin() + "', '" + user.getPesoMax() + "');";
            Statement sta = conexion.createStatement();
            sta.execute(sql);

        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregaJuez(Juez user) {

        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `juez` (`nombre`, `apellido`, `identificacion`,`edad`) "
                    + "VALUES ('" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getIdentificacion() + "', '" + user.getEdad() + "');";
            Statement sta = conexion.createStatement();
            sta.execute(sql);

        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(int idBoxeador) {
        try {
            Connection conexion = conectar();
            String sql = "DELETE FROM `boxeador` WHERE `id` = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, idBoxeador);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Boxeador eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún boxeador con el ID proporcionado.");
            }

            preparedStatement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Boxeador> obtenerBoxeadores() {
        List<Boxeador> boxeadores = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM `boxeador`";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Boxeador boxeador = new Boxeador();
                boxeador.setNombre(resultSet.getString("nombre"));
                boxeador.setApellido(resultSet.getString("apellido"));
                boxeador.setCorreo(resultSet.getString("email"));
                boxeador.setIdentificacion(resultSet.getString("documento"));
                boxeador.setCategoria(resultSet.getString("nombreCategoria"));
                boxeador.setEdad(resultSet.getInt("edad"));
                boxeador.setTitulos(resultSet.getInt("titulos"));
                boxeador.setKo(resultSet.getInt("ko"));
                boxeador.setEmpates(resultSet.getInt("empates"));
                boxeador.setRank(resultSet.getInt("rank"));
                boxeador.setPeso(resultSet.getInt("peso"));
                boxeador.setAltura(resultSet.getDouble("altura"));
                boxeadores.add(boxeador);

            }

            preparedStatement.close();
            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return boxeadores;
    }
}
