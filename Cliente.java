/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

import java.util.ArrayList;

/**
 *
 * @author masq4
 */
public class Cliente {
    String nombre;
    String correo;
    long telefono;
    
    
    public Cliente(String nombre, String correo, long telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
    
    
}
