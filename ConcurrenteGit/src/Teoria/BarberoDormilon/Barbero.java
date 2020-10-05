/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teoria.BarberoDormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Barbero implements Runnable{
    String color;
    Barberia sillon;
    int cant;
    
    public Barbero(String color, Barberia sillon, int cant) {
        this.color = color;
        this.sillon = sillon;
        this.cant=cant;
    }

    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Barberia getSillon() {
        return sillon;
    }

    public void setSillon(Barberia sillon) {
        this.sillon = sillon;
    }
    
    public void run(){
        while(true){
            try {
                sillon.afeitar(color);
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
}