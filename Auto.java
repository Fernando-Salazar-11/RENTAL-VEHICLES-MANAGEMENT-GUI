/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkgfinal;

/**
 *
 * @author masq4
 */
public class Auto {
    private String marca;
    private String modelo;
    private int mantenimiento = 0;
    private float costoRenta;
    private int id;
    private boolean disponivilidad;
    private Cliente cliente;

    public Auto(String marca, String modelo, float costoRenta, int id, boolean disponivilidad){
        this.marca = marca;
        this.modelo = modelo;
        this.costoRenta = costoRenta;
        this.id = id;
        this.disponivilidad = disponivilidad;
    }

    public Auto(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(int mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public float getCostoRenta() {
        return costoRenta;
    }

    public void setCostoRenta(float costoRenta) {
        this.costoRenta = costoRenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponivilidad() {
        return disponivilidad;
    }

    public void setDisponivilidad(boolean disponivilidad) {
        this.disponivilidad = disponivilidad;
    }      
    
    public boolean rentar(Auto auto){
        if(auto.getMantenimiento() > 1){
            return false;
        }
        else{
            auto.setDisponivilidad(false);
            auto.setMantenimiento(auto.getMantenimiento() + 1);
            return true;
        }        
    }     
    
    public void recibir(Auto auto){
        auto.setDisponivilidad(true);
        auto.setCliente(null);
    }
    
    public void darMantenimieto(Auto auto){
        auto.setMantenimiento(0);
    }

    
    public String toString() {
        return "Auto{" + "marca=" + marca + ", modelo=" + modelo + ", mantenimiento=" + mantenimiento + ", costoRenta=" + costoRenta + ", id=" + id + ", disponivilidad=" + disponivilidad + ", cliente=" + cliente.toString() + '}';
    }
    

}
