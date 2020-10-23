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
public class Durmiente implements Runnable{
    private Reloj reloj;
    private int hora;
    String nombre;
    public Durmiente(String nombre, Reloj reloj, int hora){
        this.nombre=nombre;
        this.reloj=reloj;
        this.hora=hora; //Hora de ir a trabajr
    }
    public void run(){
        try {
            while(true){
                this.reloj.despertar(nombre, hora);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Durmiente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
