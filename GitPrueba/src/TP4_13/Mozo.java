/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_13;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Mozo extends Trabajador implements Runnable{
    public Mozo(String nombre, Confiteria conf){
        super(nombre, conf);
    }
    public void run(){
        try {
            this.confiteria.atender(nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
