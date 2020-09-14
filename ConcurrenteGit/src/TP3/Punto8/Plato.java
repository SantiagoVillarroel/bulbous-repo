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
public class Plato extends Instalacion {
    

    public Plato(int segs) {
        super(segs);
    }

    /**
     *
     * @throws InterruptedException
     */
    @Override
    public void usar() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" comiendo...");
        Thread.sleep(segs*1000);
        System.out.println(Thread.currentThread().getName()+" terminó de comer.");
    }
}
