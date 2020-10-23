/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class ControlReloj implements Runnable{
    private Reloj reloj;
    public ControlReloj(Reloj reloj){
        this.reloj=reloj;
    }
    public void run(){
        while(true){
            if((this.reloj.getHora()%5)==0){ //Si la hora es multiplo de 5 -> sueno alarma
                this.reloj.sonarAlarma(); 
            }
            this.reloj.sumarHora(); //Pasa una hora
            System.out.println("Hora actual: "+this.reloj.getHora()+"\n");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlReloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
