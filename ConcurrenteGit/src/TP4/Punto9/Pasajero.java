/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pasajero implements Runnable {
    private String color;
    private AdminSem as;

    public Pasajero(String pasajero, AdminSem as) {
        this.color= pasajero;
        this.as = as;
    }

    public Pasajero(AdminSem as) {
        this.as = as;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AdminSem getAs() {
        return as;
    }

    public void setAs(AdminSem as) {
        this.as = as;
    }
    
    
    public void run(){
        while(!as.pasajero(color)){
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
