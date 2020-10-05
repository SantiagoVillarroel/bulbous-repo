/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Punto6;
public class Producto {
    private int tiempo;
    private int precio;

    public Producto(int tiempo, int precio) {
        this.tiempo = tiempo;
        this.precio = precio;
    }


    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
