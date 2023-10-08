/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionmanager;

import DAO.conectar;
import DAO.usuarioDao;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import proyecto.Categoria;
import proyecto.Manager;

/**
 *
 * @author JHON C
 */
public class ManagerConsultas {
    usuarioDao conexion = new usuarioDao();
    Connection cn = conexion.conectar();
    ResultSet rs;
    Statement st;
    public ArrayList<Manager> ObtenerManager (){
        ArrayList<Manager> Lista_Manager = new ArrayList<>();
        try {
            String consulta="Select * from manager";
            st=cn.createStatement();
            rs=st.executeQuery(consulta);
            while (rs.next()) {
                Manager mana = new Manager();
                mana.setNombreManager(rs.getString("nombreManager"));
                mana.setApellido(rs.getString("Apellido"));
                mana.setEdad(rs.getInt("Edad"));
                mana.setTelefono(rs.getString("Telefono"));
                Lista_Manager.add(mana);
                System.out.println("manager obtenido");
            }
        } catch (Exception e) {
            System.out.println("Error a encontrar Manager");
        }
       return Lista_Manager;
    }
}
