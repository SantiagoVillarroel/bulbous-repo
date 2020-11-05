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
    private AdminSem as2;

    public Pasajero(String pasajero, AdminSem as,AdminSem as2) {
        this.color= pasajero;
        this.as = as;
        this.as2=as2;
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
        boolean res= false;
        while(!res){
        res= as.pasajero(color);
        if(!res){
            System.out.println(color+Thread.currentThread().getName()+" busco otro taxi mejor");
            res= as2.pasajero(color);
        }
        if(!res){
            this.pasear();
        }
        
    }
    }
     public void pasear(){
         System.out.println(color+Thread.currentThread().getName()+" pasea un poco ya que no consiguió taxi.");
        try {
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
