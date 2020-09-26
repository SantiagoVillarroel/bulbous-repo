/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Punto9;

/**
 *
 * @author Faustino
 */
public class Taxi implements Runnable {
    private AdminSem as;

    public Taxi(AdminSem as) {
        this.as = as;
    }
    
    public void run(){
        as.taxi();
    }
}
