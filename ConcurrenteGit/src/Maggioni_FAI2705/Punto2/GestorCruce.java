/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maggioni_FAI2705.Punto2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class GestorCruce {
    private Semaphore oeste= new Semaphore(0,true);
    private Semaphore sur= new Semaphore(1,true);
    
    public void cambiaSemaforos(){
        boolean res= oeste.tryAcquire();
        if(res){
            sur.release();
            System.out.println("1");
        }else{
            try {
                sur.acquire();
                oeste.release();
                System.out.println("2");
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void sale(String sema){
        try {
            System.out.println(Thread.currentThread().getName()+" pasando el semaforo "+sema);
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void llegaOeste(){
        try {
            System.out.println(Thread.currentThread().getName()+" esperando semaforo oeste");
            oeste.acquire();
            this.sale("oeste");
            oeste.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llegaSur(){
        try {
            System.out.println(Thread.currentThread().getName()+" esperando semaforo sur");
            sur.acquire();
            this.sale("sur");
            sur.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorCruce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
