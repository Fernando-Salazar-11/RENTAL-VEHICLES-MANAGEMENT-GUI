/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

import java.awt.*;

public class Datos {
    private Color color [] = {Color.BLUE, Color.PINK, Color.RED};
    private String colores [] = {"Azul" , "Rosa" , "Rojo"};
    
    public Datos() {
    }

    public Color[] getColor() {
        return color;
    }

    public void setColor(Color[] color) {
        this.color = color;
    }

    public String[] getColores() {
        return colores;
    }

    public void setColores(String[] colores) {
        this.colores = colores;
    }
}
