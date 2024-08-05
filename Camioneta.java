/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author masq4
 */
public class Camioneta extends Auto{
    int capacidadDeCarga;

    public Camioneta(int capacidadDeCarga, String marca, String modelo, float costoRenta, int id,  boolean disponivilidad) {
        super(marca, modelo, costoRenta, id, disponivilidad);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    public int getCapacidadDeCarga() {
        return capacidadDeCarga;
    }

    public void setCapacidadDeCarga(int capacidadDeCarga) {
        this.capacidadDeCarga = capacidadDeCarga;
    }

    
    public String toString(Auto auto) {
        return "Camioneta{"+ "capacidadDeCarga=" + capacidadDeCarga + auto.toString() + '}';
    }
    
    
}
