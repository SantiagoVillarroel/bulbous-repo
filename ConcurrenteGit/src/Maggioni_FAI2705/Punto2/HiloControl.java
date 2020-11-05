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
public class HiloControl implements Runnable{
    private GestorCruce gc;

    public HiloControl(GestorCruce gc) {
        this.gc = gc;
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep(3000);
                gc.cambiaSemaforos();
                System.out.println("CAMBIO");
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
