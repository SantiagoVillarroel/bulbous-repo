/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5_3;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class ControlTren implements Runnable{
    private Estacion estacion;
    private boolean flag;
    public ControlTren(Estacion est){
        this.estacion=est;
        
    }
    public void run(){
        try {
            while(true){                
                System.out.println("Tren está en reposo. Espera a que los pasajeros se suban.");
                this.estacion.arrancar();
                this.estacion.parar();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
