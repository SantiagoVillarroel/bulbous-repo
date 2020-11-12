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
public class Persona implements Runnable{
    protected String nombre;
    protected GestorSala sala;
    public Persona(String id, GestorSala sala){
        this.nombre=id;
        this.sala=sala;
    }
    public void run(){
        while(true){
            try {
                sala.entrarSala(nombre);
                Thread.sleep(2000);
                sala.salirSala(nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
