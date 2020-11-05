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
public class VendedorTickets extends Persona implements Runnable{
    public VendedorTickets(String nombre, Estacion est){
        super(nombre, est);
    }
    public void run(){
        try {
            while(true){
                this.estacion.venderPasaje();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(VendedorTickets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
