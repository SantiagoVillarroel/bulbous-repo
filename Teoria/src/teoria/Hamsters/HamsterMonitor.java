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
public class HamsterMonitor implements Runnable {

    private Jaula jale;
    private String miNombre;
 //cambio
    public HamsterMonitor(Jaula jale, String miNombre) {
        this.jale = jale;
        this.miNombre = miNombre;
        System.out.println("");
    }



    public void run() {
        while (true) {
            jale.comer(miNombre);
            jale.correr(miNombre);
        }
    }
}
