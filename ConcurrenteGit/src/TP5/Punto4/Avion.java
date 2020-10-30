/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Punto4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Avion implements Runnable {

    private TorreDeControl torre;
    private String color;

    public Avion(TorreDeControl torre, String color) {
        this.torre = torre;
        this.color = color;
    }

    

    public void run() {
        while (true) {
            double x = Math.random();
            if (x > 0.5) {
                torre.manejarPista("aterrizaje", color);
                this.pasarRatoEnTierra();
            } else {
                torre.manejarPista("despegar", color);
                this.volar();
            }

        }
    }

    private void volar() {
        try {
            System.out.println(color + "_________________Volando.");
            Thread.sleep(9000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pasarRatoEnTierra() {
        try {
            System.out.println(color + "_________________ Pasando rato en tierra.");
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
