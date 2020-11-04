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
public class CantSillas {
    private int cant;
    private Semaphore sem = new Semaphore(1);

    public CantSillas(int cant) {
        this.cant = cant;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public void liberar(){
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CantSillas.class.getName()).log(Level.SEVERE, null, ex);
        }
        cant++;
        sem.release();
    }
    public boolean ocupar(){
        boolean res=false;
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CantSillas.class.getName()).log(Level.SEVERE, null, ex);
        }
        res= cant>0;
        if(res)
            cant--;
        sem.release();
        return res;
    }
    
    
            
    
}
