/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maggioni_FAI2705;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Donante extends Persona implements Runnable {

    public Donante(String nombre, Clinica clinica,String color){
        super(nombre, clinica,color);
    }

    public void run(){
        boolean atendido= false;
        boolean turno= false;
        while(!atendido){
            try {
                
                Thread.sleep(400);
                if(!turno){
                this.clinica.pedirTurno(nombre);
                turno=true;}
                System.out.println(color+Thread.currentThread().getName()+" yendo a la clinica");
                atendido= this.clinica.irALaClinicaYDonar(nombre);
                if(!atendido){
                    this.pasear();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Donante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void pasear(){
        try {
            System.out.println(color+Thread.currentThread().getName()+"ya que no hay lugar en la clinica, paseo un poco y despues "
                    + " vuelvo y pruebo de vuelta");
            Thread.sleep(9000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Donante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
