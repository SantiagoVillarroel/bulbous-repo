/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.Hamsters;

import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Jaula {
    private Plato plato= new Plato(3);
    private Rueda rueda= new Rueda();
    private ReentrantLock rlock= new ReentrantLock(true);
    private int comiendo=0;

    public Jaula() {
    }
    
    
    public void correr(String nombre){
        rlock.lock();
        rueda.rodar(nombre);
        rlock.unlock();
    }
    
    public void comer(String nombre){
        this.empiezaAComer(nombre);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Jaula.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.come(nombre);
    }
    
    private synchronized void empiezaAComer(String nombre){
        while(this.comiendo>=3){
            System.out.println(nombre+" espera a comer");
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Jaula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private synchronized void come(String nombre){
        System.out.println(nombre+" empieza a comer");
        plato.comer(nombre);
        this.notify();
    }
}
