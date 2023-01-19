/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import bbdd.ConexionBD;
import clases.Equipo;
import clases.Jugador;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Dam
 */
public class DAOEquipoJugador {
    private static DAOEquipoJugador gestion = null;
    
    public DAOEquipoJugador() {
    }
    
    public static DAOEquipoJugador getInstance() {
        if (gestion == null) {
            gestion = new DAOEquipoJugador();
        }

        return gestion;
    }
    
    public void fillTable(JTable tabla, String query) {
        ConexionBD.fillTable(tabla, query);
    }
    
    public ArrayList<Equipo> getEquipos() {
        return ConexionBD.getEquipos();
    }
    
    public ArrayList<Jugador> getJugadores(Equipo equipo) {
        return ConexionBD.getJugadores(equipo);
    }
    
    public Boolean insertarEquipo(Equipo equipo) {
        return ConexionBD.insertarEquipo(equipo);
    }
    
    public void editarEquipo(Equipo equipo, String nombre, String ciudad, Integer presupuesto) {
        ConexionBD.editarEquipo(equipo, nombre, ciudad, presupuesto);
    }
    
    public void editarJugador(String equipo, Jugador jugador) {
        ConexionBD.editarJugador(equipo, jugador);
    }
    
    public void eliminarEquipos(ArrayList<Equipo> equipos) {
        for (int i = 0; i < equipos.size(); i++) {
            ConexionBD.eliminarEquipo(equipos.get(i));
        }
    }
    
    public void eliminarJugadores(Equipo equipo) {
        ConexionBD.eliminarJugadores(equipo);
    }
}