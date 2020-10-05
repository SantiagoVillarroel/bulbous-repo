/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Punto6;

/**
 *
 * @author Faustino
 */
public class Cliente implements Runnable{

    private String nombre;
    private Producto[] carroCompra;
// Constructor y métodos de acceso
    private Atencion at;
    public Cliente(String nombre, Producto[] carroCompra, Atencion at) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
        this.at= at;
    }

    public String getNombre() {
        return nombre;
    }
    public void setCajera(Atencion at){
        this.at=at;
    }
    public void run(){
        at.solicitarAtencion(this);        
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto[] getCarroCompra() {
        return carroCompra;
    }

    public void setCarroCompra(Producto[] carroCompra) {
        this.carroCompra = carroCompra;
    }
    
    
}
