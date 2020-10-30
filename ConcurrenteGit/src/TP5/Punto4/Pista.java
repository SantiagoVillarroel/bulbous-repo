/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Pista {
    
    private Semaphore pista= new Semaphore(1,true);
    
    public void aterrizar(String color){
        try {
            System.out.println(color+" ||||||||QUIERE USAR LA PISTA para ATERRIZAR|||||||");
            pista.acquire();
            System.out.println(color+" ---------------- va a aterrizar.");
            Thread.sleep(3000);
            System.out.println(color+" +++++++ ATERRIZÓ CON ÉXITO");
            pista.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void despegar(String color){
        try {
            System.out.println(color+" .............le dan P E R M I S O para DESPEGAR .................");
            pista.acquire();
            System.out.println(color+" ---------------- va a despegar.");
            Thread.sleep(3000);
            System.out.println(color+" +++++++ DESPEGÓ CON ÉXITO");
            pista.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

