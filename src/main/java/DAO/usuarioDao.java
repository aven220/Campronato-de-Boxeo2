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
import proyecto.Manager;

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
                    + "`categoria`, `edad`, `peso`, `altura`) "
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

    public List listarCliente() {
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
                boxeador.setCategoria(resultSet.getString("categoria"));
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

    public boolean existeCedula(String numeroCedula) {
        boolean cedulaExiste = false;

        try {
            Connection conexion = conectar();
            String sql = "SELECT COUNT(*) AS total FROM `boxeador` WHERE documento = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, numeroCedula);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int totalRegistros = resultSet.getInt("total");
                cedulaExiste = totalRegistros > 0;
            }

            preparedStatement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cedulaExiste;
    }

    public void agregarManager(Manager user) {

        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `manager` (`nombre`, `apellido`, `telefono`, `correo`, `identificacion`, `edad`) "
                    + "VALUES ('" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getTelefono() + "', '"
                    + user.getCorreo() + "', '" + user.getIdentificacion() + "', '" + user.getEdad() + "');";
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
                boxeador.setCategoria(resultSet.getString("categoria"));
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
