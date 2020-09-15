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
public class Instalacion {
    int segs;

    public Instalacion(int segs) {
        this.segs = segs;
    }
    public synchronized void usar() throws InterruptedException{
        Thread.sleep(segs*1000);
    }
}
