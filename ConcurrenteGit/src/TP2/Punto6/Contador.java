/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2.Punto6;

/**
 *
 * @author Faustino
 */
public class Contador {
    private int i;

    public Contador() {
        this.i = 0;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public synchronized void sumar(){
        this.i++;
    }
    
    public synchronized void restar(){
        this.i--;
    }
}
