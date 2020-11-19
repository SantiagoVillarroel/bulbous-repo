/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Empaquetador implements Runnable{
    private Mostrador mostrador;
    double peso;
    public Empaquetador(Mostrador m){
        this.mostrador=m;
    }
    public void run(){
        while(true){
            try {
                peso=mostrador.tomarPastel();
                mostrador.soltarPastel(peso);
            } catch (InterruptedException ex) {
                Logger.getLogger(Empaquetador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
