/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maggioni_FAI2705.Punto2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Auto implements Runnable {
    private GestorCruce gc;

    public Auto(GestorCruce gc) {
        this.gc = gc;
    }
    
    public void run(){
        while(true){
            try {
                double sem= Math.random();
                if(sem<0.5){
                    gc.llegaOeste();
                }else
                    gc.llegaSur();
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
