/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Objects;

/**
 *
 * @author Dam
 */
public class Jugador {
    private Integer dorsal, salario;
    private String nombre, nomEquipo;

    public Jugador(Integer dorsal, String nombre, Integer salario, String nomEquipo) {
        this.dorsal = dorsal;
        this.salario = salario;
        this.nombre = nombre;
        this.nomEquipo = nomEquipo;
    }

    public Jugador() {
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.dorsal);
        hash = 67 * hash + Objects.hashCode(this.nomEquipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nomEquipo, other.nomEquipo)) {
            return false;
        }
        return Objects.equals(this.dorsal, other.dorsal);
    }

    @Override
    public String toString() {
        return "Jugador{" + "dorsal=" + dorsal + ", salario=" + salario + ", nombre=" + nombre + ", nomEquipo=" + nomEquipo + '}';
    }
    
}