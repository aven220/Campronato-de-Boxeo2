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

        String baseDeDatos = "BDTorneoBox";
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

    public void agregarBox(Boxeador user) {

        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `boxeador` ( `nombre`, `apellido`,`documento`, "
                    + "`idCategoria`, `edad`, `peso`, `altura`) "
                    + "VALUES ('" + user.getNombre() + "', '" + user.getApellido() + "'"
                    + ", '" + user.getIdentificacion() + "', '" + user.getIdCategoria() + "',"
                    + " '" + user.getEdad() + "'"
                    + ", '" + user.getPeso() + "', '" + user.getAltura() + "');";

            Statement sta = conexion.createStatement();
            sta.execute(sql);
        } catch (Exception ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List listarBox() {
        List<Boxeador> listaBoxeadores = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM boxeador";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Boxeador boxeador = new Boxeador();
                boxeador.setIdentificacion(resultSet.getString("documento"));
                boxeador.setNombre(resultSet.getString("nombre"));
                boxeador.setApellido(resultSet.getString("apellido"));
                boxeador.setIdCategoria(resultSet.getInt("idCategoria"));
                boxeador.setEdad(resultSet.getInt("edad"));
                boxeador.setPeso(resultSet.getDouble("peso"));
                boxeador.setAltura(resultSet.getDouble("altura"));

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
                gym.setNombre(resultSet.getString("nombre"));
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
    //////////////////
        public List listarCategoria() {
        List<Categoria> listaCategoria = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM categoria";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setNombre(resultSet.getString("nombre"));
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
    
        public List listarManager() {
        List<Manager> listaManager = new ArrayList<>();

        try {
            Connection conexion = conectar();
            String sql = "SELECT * FROM manager";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Manager manager = new Manager();
                manager.setNombre(resultSet.getString("nombre"));
                manager.setApellido(resultSet.getString("apellido"));
                manager.setTelefono(resultSet.getString("telefono"));
                manager.setCorreo(resultSet.getString("correo"));
                manager.setIdentificacion(resultSet.getString("identificacion"));
                manager.setEdad(resultSet.getInt("edad"));
                manager.setIdBoxeador(resultSet.getInt("idBoxeador"));
                
                
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
////////////////////////

    public List listarRanking() {

    List<Ranking> listaRanking = new ArrayList<>();

    try {
        Connection conexion = conectar();
        String sql = "SELECT r.*, b.nombre AS nombreBoxeador, c.nombre AS nombreCategoria "
                + "FROM ranking r "
                + "INNER JOIN boxeador b ON r.idBoxeador = b.idBoxeador "
                + "INNER JOIN categoria c ON b.idCategoria = c.idCategoria";

        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Ranking ranking = new Ranking();
            ranking.setPuntuacion(resultSet.getDouble("puntuacion"));
            ranking.setPuesto(0);
            ranking.setNombre(resultSet.getString("nombreBoxeador"));
            ranking.setCategoria(resultSet.getString("nombreCategoria"));

            listaRanking.add(ranking);
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

    public void agregarManager(Manager user) {

        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `manager` (`nombre`, `apellido`, `telefono`, `correo`, `identificacion`, `edad`, `idBoxeador`) "
                    + "VALUES ('" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getTelefono() + "', '"
                    + user.getCorreo() + "', '" + user.getIdentificacion() + "', '" + user.getEdad() + "', '" + user.getIdBoxeador()+ "');";
            Statement sta = conexion.createStatement();
            sta.execute(sql);
        } catch (Exception ex) {
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
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
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
                boxeador.setIdCategoria(resultSet.getInt("idCategoria"));
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
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return boxeadores;
    }
}
