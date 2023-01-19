/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import clases.Equipo;
import clases.Jugador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dam
 */
public class ConexionBD {
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;
    static String bd = "euroliga";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;
    
    private static void enlace() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            System.out.println("Excepción en la conexión");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra la clase");
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void fillTable(JTable table, String Query)
    {
        try
        {
            enlace();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(Query);

            //To remove previously added rows
            while(table.getRowCount() > 0) 
            {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
            }

            cerrarSesion();
        }
        catch(SQLException ex)
        {
            System.out.println("Error SQL: " + ex.getMessage());
        }
    }
    
    public static ArrayList<Equipo> getEquipos() { 
        enlace();
        
        ArrayList<Equipo> listaEquipos = null;
        
        try {
            String sql = "SELECT * FROM equipo;";
            stmt = conn.prepareStatement(sql);
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            listaEquipos = new ArrayList<Equipo>();
            
            while (rs.next()) {
                listaEquipos.add(new Equipo(rs.getString("NOMBRE"),
                        rs.getString("CIUDAD"),
                        rs.getInt("PRESUPUESTO")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return listaEquipos;
    }
    
    public static ArrayList<Jugador> getJugadores(Equipo equipo) { 
        enlace();
        
        ArrayList<Jugador> listaJugadores = null;
        
        try {
            String sql = "SELECT * FROM jugador WHERE NOM_EQUIPO = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, equipo.getNombre());
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            listaJugadores = new ArrayList<Jugador>();
            
            while (rs.next()) {
                listaJugadores.add(new Jugador(rs.getInt("DORSAL"),
                        rs.getString("NOMBRE"),
                       rs.getInt("SALARIO"),
                      rs.getString("NOM_EQUIPO")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return listaJugadores;
    }

    public static Boolean insertarEquipo(Equipo equipo) { 
        enlace();
        
        Boolean exitoso = false;
        
        try {
            String sql = "INSERT INTO equipo (NOMBRE, CIUDAD, PRESUPUESTO) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getCiudad());
            stmt.setInt(3, equipo.getPresupuesto());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
            
            exitoso = true;
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return exitoso;
    }
    
    public static void editarEquipo(Equipo equipo, String nombre, String ciudad, Integer presupuesto) { 
        enlace();
        
        try {
            String sql = "UPDATE equipo SET CIUDAD = ?, PRESUPUESTO = ?, NOMBRE = ? WHERE NOMBRE = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, ciudad);
            stmt.setInt(2, presupuesto);
            stmt.setString(3, nombre);
            stmt.setString(4, equipo.getNombre());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static void editarJugador(String equipo, Jugador jugador) { 
        enlace();
        
        try {
            String sql = "UPDATE jugador SET NOM_EQUIPO = ? WHERE DORSAL = ? and NOM_EQUIPO = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, equipo);
            stmt.setInt(2, jugador.getDorsal());
            stmt.setString(3, jugador.getNomEquipo());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static void eliminarEquipo(Equipo equipo) { 
        enlace();
        
        try {
            String sql = "DELETE FROM equipo WHERE NOMBRE = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, equipo.getNombre());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error SQL por?: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static void eliminarJugadores(Equipo equipo) { 
        enlace();
        
        try {
            String sql = "DELETE FROM jugador WHERE NOM_EQUIPO = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, equipo.getNombre());
            
            System.out.println(stmt.toString());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error SQL por?: " + ex.toString());
        }
        
        cerrarSesion();
    }
    
    public static Boolean sumaSalario(Equipo equipo) { 
        enlace();
        Integer suma = 0;
        
        Boolean exitoso = false;
        
        try {
            String sql = "SELECT SUM(salario) FROM jugador WHERE NOM_EQUIPO = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, equipo.getNombre());
            
            System.out.println(stmt.toString());
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
            }
            
            exitoso = true;
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        
        cerrarSesion();
        
        return exitoso;
    }
    
    private static void cerrarSesion() {
        try {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Conexión cerrada \n");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}