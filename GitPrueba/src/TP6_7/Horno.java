/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP6_7;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Horno implements Runnable{
    private Random r = new Random();
    private int tipo;
    private Mostrador mostrador;
    private double[] pesos = new double[3];
    public Horno(double pesoA, double pesoB, double pesoC, Mostrador m){
        pesos[0]=pesoA;
        pesos[1]=pesoB;
        pesos[2]=pesoC;
        this.mostrador=m;
    }
    public void run(){
        while(true){
            tipo = r.nextInt(3);
            try {
                System.out.println("Torta de tipo "+pesos[tipo]+" está siendo horneada");
                Thread.sleep(1000);
                mostrador.hornearTorta(pesos[tipo]);                
            } catch (InterruptedException ex) {
                Logger.getLogger(Horno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
