/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Jubilado extends Persona implements Runnable{
    public Jubilado(String id, GestorSala sala){
        super(id, sala);
    }
    public void run(){
        while(true){
            try {
                sala.entrarSalaJubilado(nombre);
                Thread.sleep(2000);
                sala.salirSala(nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jubilado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
