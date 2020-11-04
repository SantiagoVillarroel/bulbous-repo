/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.BarberoConMonitores;

import teoria.BarberoDormilon.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Barberia {

    private Semaphore semSillon = new Semaphore(1, true);
    private Semaphore semSalida = new Semaphore(0, true);
    private Semaphore semBarbero;
    private Semaphore semSillas = new Semaphore(3,true);
    private CantSillas csillas;
    private boolean barberoOcupado=false;

    public Barberia() {
        csillas= new CantSillas(2);
        this.semBarbero = new Semaphore(0, true);
    }
    
    public void afeitar(String color) throws InterruptedException {
        System.out.println(color + Thread.currentThread().getName() + " ------- ZZZ duerme...");
        semBarbero.acquire();
        System.out.println(color + Thread.currentThread().getName() + " !!!-------------- se despierta. Y empieza a cortar el pelo");
        Thread.sleep(2500);
        System.out.println(color + Thread.currentThread().getName() + " TERMINA DE CORTAR PELO");
        semSalida.release();
    }
    
    public synchronized boolean serAtendido(String color) throws InterruptedException {
        boolean res= this.semSillas.tryAcquire();
        if(res){
            while(barberoOcupado){
                System.out.println(color+Thread.currentThread().getName()+" se sienta en silla de espera");
                this.wait();  
            }
            semSillas.release();
            this.barberoOcupado=true;
        }
        return res;
    }
    
    public synchronized void terminarCorte(String color){
        this.barberoOcupado=false;
        this.notify();
    }
    
    public void recibirCorte(String color){
        try {
            semBarbero.release();
            System.out.println(color+Thread.currentThread().getName()+" ------recibe corte----");
            semSalida.acquire();
            System.out.println(color+Thread.currentThread().getName()+" ++++++++++++++++se va con corte nuevo");
        } catch (InterruptedException ex) {
            Logger.getLogger(Barberia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    
}
