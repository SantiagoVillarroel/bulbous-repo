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
public class MainThread {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5,
            2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1,
            1});
        long initialTime = System.currentTimeMillis();
        CajeraThread c1 = new CajeraThread("Cajera 1",cliente1,initialTime);
        CajeraThread c2= new CajeraThread("Cajera2",cliente2,initialTime);
        Thread t1= new Thread(c1,"Cajera 1");
        Thread t2= new Thread(c2,"Cajera 2");
        t1.start();
        t2.start();
    }
}
