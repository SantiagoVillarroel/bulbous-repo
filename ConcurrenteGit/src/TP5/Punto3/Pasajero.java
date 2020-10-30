/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Pasajero implements Runnable {
    private ControlTren ct;
    private String color;

    public Pasajero(ControlTren ct, String color) {
        this.ct = ct;
        this.color = color;
    }
    
    public void run(){
        while(true){
            ct.comprarTicket(color);
            System.out.println(color+"Ticket comprado. ESPERA QUE LLEGUE EL TREN.");
            ct.subirseAlTren(color);
            System.out.println(color+"Pasajero recien llega del paseo, estira las piernas antes de volver a COMPRAR PASAJE.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
