/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto13;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleado extends Persona implements Runnable {

    public Empleado(String nombre, ConfiteriaPequeña confi, String color) {
        super(nombre, confi, color);
    }

  
    
    public void run(){
        boolean hambre=false;
        while(!hambre){
            try {
                Thread.sleep(2000);
                double va= (Math.random());
                if(va>0.5){
                    System.out.println(color+Thread.currentThread().getName()+" me dio hambreee.");
                    try {
                        hambre= this.confi.comerAlgo(color);
                        if(hambre)
                            System.out.println(color+Thread.currentThread().getName()+" vuelvo al laburo, muy buena comida.");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    this.trabajando();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        System.out.println(color+Thread.currentThread().getName()+"~~~~~~~~~~~~~~~~~ ya comió, está LLENO.");
    }
    
    private void trabajando(){
        System.out.println(color+Thread.currentThread().getName()+" trabajando!!");
        try {
            Thread.sleep(1300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
