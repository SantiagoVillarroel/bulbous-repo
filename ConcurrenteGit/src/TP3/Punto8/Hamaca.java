/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto8;

/**
 *
 * @author Faustino
 */
public class Hamaca extends Instalacion {
    

    public Hamaca(int segs) {
        super(segs);
    }
    public synchronized void usar() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" descansando...");
        super.usar();
        System.out.println(Thread.currentThread().getName()+" terminó de descansar.");
    }
}
