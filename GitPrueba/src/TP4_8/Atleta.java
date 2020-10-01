/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4_8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Atleta implements Runnable {

    private Testigo testigo;
    private int num;
    private final int min=9, max=11, rango=max-min+1;

    public Atleta(int num, Testigo testigo) {
        this.num = num;
        this.testigo = testigo;
    }

    public void run() {
        try {
            double tiempo=(Math.round((Math.random()*rango+min)*100.0))/100.0; //Obtengo un double en (9, 12)
            this.testigo.getSem().acquire(); //Atleta adquiere testigo
            System.out.println("Atleta "+this.num +" corriendo");
            Thread.sleep((int)tiempo*100); //Multiplico por 100 y no por 1000 para debugging
            System.out.println("Atleta " + num + " entregó el testigo y tardó "+tiempo+" segundos.");
            this.testigo.getSem().release(); //Atleta entrega el testigo
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}
