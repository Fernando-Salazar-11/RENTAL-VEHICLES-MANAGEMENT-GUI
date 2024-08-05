/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author masq4
 */
public class Familiar extends Auto{
    int pasajeros;

    public Familiar(int pasajeros, String marca, String modelo, float costoRenta, int id, boolean disponivilidad) {
        super(marca, modelo, costoRenta, id, disponivilidad);
        this.pasajeros = pasajeros;
    }

    public Familiar(Cliente cliente) {
        super(cliente);
    }

       

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    
    public String toString(Auto auto) {      
        return "Familiar{"+ "pasajeros=" + pasajeros + auto.toString() + '}';
    }
        
    
}
