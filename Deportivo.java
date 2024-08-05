/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author masq4
 */
public class Deportivo extends Auto{
    int potencia;

    public Deportivo(int potencia, String marca, String modelo, float costoRenta, int id, boolean disponivilidad) {
        super(marca, modelo, costoRenta, id, disponivilidad);
        this.potencia = potencia;
    }

    

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    
    public String toString(Auto auto) {
        return "Deportivo{"+ "potencia=" + potencia + auto.toString() + '}';
    }
    
    
}
