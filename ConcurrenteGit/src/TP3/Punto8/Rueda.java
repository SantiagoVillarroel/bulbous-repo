/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP3.Punto8;

public class Rueda extends Instalacion {
    

    public Rueda(int segs) {
        super(segs);
    }
    
    public synchronized void usar() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" jugando...");
        super.usar();
        System.out.println(Thread.currentThread().getName()+" terminó de correr.");
    }
}
