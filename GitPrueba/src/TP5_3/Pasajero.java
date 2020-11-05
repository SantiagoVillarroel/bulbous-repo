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
public class Pasajero extends Persona implements Runnable{
    public Pasajero(String nombre, Estacion est){
        super(nombre, est);
    }
    public void run(){
        try{
            this.estacion.comprarPasaje(nombre);
            this.estacion.ocuparAsiento();
            System.out.println(nombre+" subió al tren.");
            this.estacion.bajarDeTren(nombre);
        }catch (InterruptedException ex) {
                Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
