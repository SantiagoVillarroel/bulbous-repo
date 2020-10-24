/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PARCIAL1_TEMA1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Perro extends Animal implements Runnable{
    public Perro(String nombre, char e, Comedor com){
        super(nombre, e, com);
    }
    public void run(){
        try {
            this.comedor.comer(nombre, especie);
        } catch (InterruptedException ex) {
            Logger.getLogger(Perro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
