/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.Hamsters;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Rueda {

    public synchronized void rodar(String nombre) {
        try {
            System.out.println(nombre + " empieza a rodar");
            System.out.println("");
            Thread.sleep((long) Math.random() * 1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Rueda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
