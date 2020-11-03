/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_14;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Santiago
 */
public class Cocinero extends Trabajador implements Runnable{
    public Cocinero(String nombre, Confiteria conf){
        super(nombre, conf);
    }
    public void run(){
        try {
            this.confiteria.cocinar(nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
